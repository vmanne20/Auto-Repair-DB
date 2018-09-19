package edu.vt.cs4604.troop;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class ScoutController {
  @Autowired
  private ScoutRepository repository;

  public ScoutController(ScoutRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/scouts")
  public Collection<Scout> scouts() {
    System.out.println("getting scouts");
    return repository.findAll().stream()
      .collect(Collectors.toList());
  }
  @PostMapping("/scouts")
  public Scout addScout(@RequestBody Scout scout) {
    System.out.println(scout.toString());
    return repository.save(scout);
  }

  @GetMapping("/activeScouts")
  public Collection<Scout> activeScouts() {
    System.out.println("getting active scouts");
    return repository.activeScouts().stream()
      .collect(Collectors.toList());
}
