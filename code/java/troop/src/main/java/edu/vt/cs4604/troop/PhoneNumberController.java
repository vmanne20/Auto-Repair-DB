package edu.vt.cs4604.troop;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class PhoneNumberController {
  @Autowired
  private PhoneNumberRepository repository;

  public PhoneNumberController(PhoneNumberRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/numbers")
  public Collection<PhoneNumber> cars() {
    System.out.println("getting numbers");
    return repository.findAll().stream()
      .collect(Collectors.toList());
  }
  @PostMapping("/numbers")
  public PhoneNumber addCustomer(@RequestBody PhoneNumber number) {
    System.out.println(number.toString());
    return repository.save(number);
  }

  @GetMapping("/activeNums")
  public Collection<PhoneNumber> activeNums(@RequestParam("days") String days) {
    System.out.println("getting active numbers");
    return repository.activeNums(days).stream()
      .collect(Collectors.toList());
  }
}