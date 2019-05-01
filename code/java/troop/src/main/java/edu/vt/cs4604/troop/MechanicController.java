package edu.vt.cs4604.troop;

import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
class MechanicController {
  @Autowired
  private MechanicRepository repository;

  @PersistenceContext
  private EntityManager em;

  public MechanicController(MechanicRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/get-mechanics")
  public Collection<Mechanic> mechanics() {
    System.out.println("getting mechanics");
    return repository.findAll().stream()
      .collect(Collectors.toList());
  }

  @PostMapping("/add-mechanics")
  public Mechanic addMechanic(@RequestBody Mechanic mechanic) {
    System.out.println(mechanic.toString());
    return repository.save(mechanic);
  }

  @PutMapping("/update-mechanics")
  public Mechanic updateMechanic(@RequestBody Mechanic mechanic) {
    System.out.println(mechanic.toString());
    return repository.save(mechanic);
  }

  @DeleteMapping("/delete-mechanics")
  public JSONObject deleteMechanic(@RequestBody Long mechId) {
    System.out.println(mechId);
    JSONObject obj = new JSONObject();
    try {
        repository.deleteById(mechId);
        obj.put("Result", "OK");
    } catch (Exception e) {
        e.printStackTrace();
        obj.put("Result", "ERROR");
    }
    return obj;
  }

  @GetMapping("/activeMechs")
  public Collection<Mechanic> activeMechs(@RequestParam("days") String days) {
    System.out.println("getting active cars");
    return repository.activeMechs(days).stream()
      .collect(Collectors.toList());
  }
}
