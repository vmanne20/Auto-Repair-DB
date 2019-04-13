package edu.vt.cs4604.troop;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;

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
}
