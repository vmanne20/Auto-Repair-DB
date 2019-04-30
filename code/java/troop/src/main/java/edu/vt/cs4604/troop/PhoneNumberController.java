package edu.vt.cs4604.troop;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

// import java.sql.Timestamp;
import java.util.Collection;
import java.util.stream.Collectors;
import org.json.JSONObject;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@RestController
class PhoneNumberController {
  @Autowired
  private PhoneNumberRepository repository;

  @PersistenceContext
  private EntityManager em;

  public PhoneNumberController(PhoneNumberRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/get-phone-numbers")
  public Collection<PhoneNumber> phoneNumbers(@RequestParam("c_id") Long c_id) {
    System.out.println("getting numbers");
    Query q = em.createNativeQuery("select p.* from phone_number p where p.c_id = :customerId", PhoneNumber.class)
                .setParameter("customerId", c_id);  
    List<PhoneNumber> phoneList = q.getResultList();
    return phoneList.stream()
        .collect(Collectors.toList());
  }

  @PostMapping("/add-phone-numbers")
  public PhoneNumber addPhoneNumber(@RequestBody PhoneNumber phoneNumber) {
    System.out.println(phoneNumber.toString());
    return repository.save(phoneNumber);
  }

  @PutMapping("/update-phone-numbers")
  public PhoneNumber updatePhoneNumber(@RequestBody PhoneNumber phoneNumber) {
    System.out.println(phoneNumber.toString());
    return repository.save(phoneNumber);
  }

  @DeleteMapping("/delete-phone-numbers")
  public JSONObject deletePhoneNumber(@RequestBody Long p_id) {
    System.out.println(p_id);
    JSONObject obj = new JSONObject();
    try {
        repository.deleteById(p_id);
        obj.put("Result", "OK");
    } catch (Exception e) {
        e.printStackTrace();
        obj.put("Result", "ERROR");
    }
    return obj;
  }
}
