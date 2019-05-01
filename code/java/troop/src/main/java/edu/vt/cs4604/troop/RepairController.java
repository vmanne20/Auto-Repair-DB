package edu.vt.cs4604.troop;

import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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