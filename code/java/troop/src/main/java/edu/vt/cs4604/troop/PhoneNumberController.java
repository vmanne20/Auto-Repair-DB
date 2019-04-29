package edu.vt.cs4604.troop;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

// import java.sql.Timestamp;
import java.util.Collection;
import java.util.stream.Collectors;
import org.json.JSONObject;

// import javax.persistence.EntityManager;
// import javax.persistence.PersistenceContext;

@RestController
class PhoneNumberController {
  @Autowired
  private PhoneNumberRepository repository;

//   @Autowired
//   private CustomerRepository custRepo;

//   @PersistenceContext
//   private EntityManager em;

  public PhoneNumberController(PhoneNumberRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/get-phone-numbers")
  // @PathVariable(name = "c_id")
  public Collection<PhoneNumber> phoneNumbers(@RequestParam("c_id") Long c_id) {
    System.out.println("getting numbers");
    return repository.findById(c_id).stream()
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
    // Car deletedCar = null;
    JSONObject obj = new JSONObject();
    try {
        // deletedCar = repository.findById(carId).get();
        repository.deleteById(p_id);
        obj.put("Result", "OK");
    } catch (Exception e) {
        e.printStackTrace();
        obj.put("Result", "ERROR");
    }
    return obj;
  }

  @GetMapping("/activeNums")
  public Collection<PhoneNumber> activeNums(@RequestParam("days") String days) {
    System.out.println("getting active numbers");
    return repository.activeNums(days).stream()
      .collect(Collectors.toList());
  }
}
