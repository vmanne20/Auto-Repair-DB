package edu.vt.cs4604.troop;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;
import org.json.JSONObject;

@RestController
class CustomerController {
  @Autowired
  private CustomerRepository repository;

  public CustomerController(CustomerRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/customers")
  public Collection<Customer> customers() {
    System.out.println("getting customers");
    return repository.findAll().stream()
      .collect(Collectors.toList());
  }

  @PostMapping("/customers")
  public Customer addCustomer(@RequestBody Customer customer) {
    System.out.println(customer.toString());
    return repository.save(customer);
  }

  @PutMapping("/customers")
  public Customer updateCustomer(@RequestBody Customer customer) {
    System.out.println(customer.toString());
    return repository.save(customer);
  }

  @DeleteMapping("/customers")
  public JSONObject deleteCustomer(@RequestBody Long c_id) {
    System.out.println(c_id);
    // Car deletedCar = null;
    JSONObject obj = new JSONObject();
    try {
        // deletedCar = repository.findById(carId).get();
        repository.deleteById(c_id);
        obj.put("Result", "OK");
    } catch (Exception e) {
        e.printStackTrace();
        obj.put("Result", "ERROR");
    }
    return obj;
  }

  @GetMapping("/activeCustomers")
  public Collection<Customer> activeCustomers() {
    System.out.println("getting active customers");
    return repository.activeCustomers().stream().collect(Collectors.toList());
  }
}
