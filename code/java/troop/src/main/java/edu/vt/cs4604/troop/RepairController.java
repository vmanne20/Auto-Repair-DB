package edu.vt.cs4604.troop;

import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

@RestController
class RepairController {
  @Autowired
  private RepairRepository repository;

  @Autowired
  private MechanicRepository mr;

  @PersistenceContext
  private EntityManager em;

  public RepairController(RepairRepository repository, MechanicRepository mr) {
    this.repository = repository;
    this.mr = mr;
  }

  @GetMapping("/get-repairs")
  public Collection<Repair> repairs() {
    System.out.println("getting repairs");
    return repository.findAll().stream()
      .collect(Collectors.toList());
  }

//   "SELECT r.r_name, m.m_name, c.make_year, c.make, c.model," +
//     "cust.c_name, crm.r_date FROM mechanic m, repair r, car c, customer cust, car_repair_mechanic crm" + 
//     "WHERE crm.m_id = m.m_id AND crm.r_id = r.r_id AND crm.car_id = c.car_id and c.c_id = cust.c_id"
  @GetMapping("/get-repair-info")
  public Collection<RepairInfoView> repairInfo() {
    System.out.println("getting repair info");
    Query q = em.createQuery("select r from RepairInfoView r", 
                RepairInfoView.class); 
    List<RepairInfoView> pastRepairList = q.getResultList();
    return pastRepairList.stream()
        .collect(Collectors.toList());
  }

  @GetMapping("/get-repair-names")
  public Collection<String> repairNames() {
    System.out.println("getting repair info");
    // Query q = em.createNativeQuery("select r.* from repair r", Repair.class); 
    List<Repair> allRepairs = repository.findAll();
    List<String> repairNames = new ArrayList<>();
    for (Repair r : allRepairs) {
        String obj = r.getId() + ":" + r.getName();
        repairNames.add(obj);
    }
    return repairNames.stream()
        .collect(Collectors.toList());
  }

//   @PostMapping("/get-estimates")
@RequestMapping(value = "/get-estimates", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
// @RequestBody List<String> repairIdList
  public Collection<Double> getEstimates(@RequestBody MultiValueMap<String, String> body) {

    // find qualified mechanics for each repair
    List<List<Long>> qualified = new ArrayList<>();
    Set<String> keySet = body.keySet();
    for (String id : keySet) {
        long r_id = Long.parseLong(id);
        List<Long> currRepairMechs = new ArrayList<>();
        for (Mechanic m : mr.findAll()) {
            long m_id = m.getId();
            int mismatchCount = ((Number) em.createNativeQuery("select count(*) from (select rc.cert_id from repair_certification rc where rc.r_id = :repairId" + 
                                    " and rc.cert_id not in ((select rc.cert_id from repair_certification rc where rc.r_id = :repairId) " +
                                    "intersect (select mc.cert_id from mechanic_certification mc where mc.m_id = :mechId))) as T1")
                                    .setParameter("repairId", r_id)
                                    .setParameter("mechId", m_id)
                                    .getSingleResult()).intValue();
            if (mismatchCount == 0) {
                currRepairMechs.add(m_id);
            }
        }
        qualified.add(currRepairMechs);
    }

    // calculate average hourly rate for each repair
    List<Double> avgRateList = new ArrayList<>();
    for (List<Long> currRepairMechs : qualified) {
        double total = 0.0;
        for (Long m_id : currRepairMechs) {
            double rate = ((Number) em.createNativeQuery("select m.hourly_rate from mechanic m where m.m_id = :mechId")
                                        .setParameter("mechId", m_id)
                                        .getSingleResult()).doubleValue();
            total += rate;
        }
        double avgRate = total / currRepairMechs.size();
        avgRateList.add(avgRate);
    }
    // if (qualified.size() == 0)
    //     avgRateList.add(0.0);

    // calculate total labor cost and total parts cost for each repair
    double totalLaborCost = 0.0;
    double totalPartsCost = 0.0;
    int i = 0;
    for (String id : keySet) {
        long r_id = Long.parseLong(id);
        double repairTime = ((Number) em.createNativeQuery("select r.r_time from repair r where r.r_id = :repairId")
                                        .setParameter("repairId", r_id)
                                        .getSingleResult()).doubleValue();
        totalLaborCost += (avgRateList.get(i) * repairTime * 1.5);

        double partsCost = ((Number) em.createNativeQuery("select r.parts_cost from repair r where r.r_id = :repairId")
                                        .setParameter("repairId", r_id)
                                        .getSingleResult()).doubleValue();
        totalPartsCost += partsCost;
        i++;
    }

    // return labor cost, parts cost, and total cost in list
    List<Double> costs = new ArrayList<Double>();
    costs.add(totalPartsCost); costs.add(totalLaborCost);
    return costs.stream()
        .collect(Collectors.toList());
  }

  @PostMapping("/add-repairs")
  public Repair addRepair(@RequestBody Repair repair) {
    System.out.println(repair.toString());
    return repository.save(repair);
  }

  @PutMapping("/update-repairs")
  public Repair updateRepair(@RequestBody Repair repair) {
    System.out.println(repair.toString());
    return repository.save(repair);
  }

  @DeleteMapping("/delete-repairs")
  public JSONObject deleteRepair(@RequestBody Long repairId) {
    System.out.println(repairId);
    JSONObject obj = new JSONObject();
    try {
        repository.deleteById(repairId);
        obj.put("Result", "OK");
    } catch (Exception e) {
        e.printStackTrace();
        obj.put("Result", "ERROR");
    }
    return obj;
  }

  @GetMapping("/activeRepairs")
  public Collection<Repair> activeRepairs(@RequestParam("days") String days) {
    System.out.println("getting active cars");
    return repository.activeRepairs(days).stream()
      .collect(Collectors.toList());
  }
}
