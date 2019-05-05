package edu.vt.cs4604.troop;

import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

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

  @PersistenceContext
  private EntityManager em;

  public RepairController(RepairRepository repository) {
    this.repository = repository;
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
        repairNames.add(r.getName());
    }
    return repairNames.stream()
        .collect(Collectors.toList());
  }

//   @GetMapping("/get-estimates")
//   public Collection<Repair> getEstimates(@RequestParam Map<String,String> requestParams) {

//     System.out.println("getting Repair Certs");
//     List<Repair> certList = new ArrayList<>();
//     return certList.stream()
//         .collect(Collectors.toList());
//   }

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
