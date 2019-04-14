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

  @GetMapping("/phoneNumbers")
  public Collection<PhoneNumber> phoneNumbers() {
    System.out.println("getting numbers");
    return repository.findAll().stream()
      .collect(Collectors.toList());
  }

  @PostMapping("/phoneNumbers")
  public PhoneNumber addPhoneNumber(@RequestBody PhoneNumber phoneNumber) {
    System.out.println(phoneNumber.toString());
    return repository.save(phoneNumber);
  }

  @GetMapping("/activeNums")
  public Collection<PhoneNumber> activeNums(@RequestParam("days") String days) {
    System.out.println("getting active numbers");
    return repository.activeNums(days).stream()
      .collect(Collectors.toList());
  }
}
