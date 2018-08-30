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
    return repository.findAll().stream()
      .collect(Collectors.toList());
  }
  @PostMapping("/scouts")
  public Scout addScout(Scout scout) {
    System.out.println(scout.toString());
    return repository.save(scout);
  }

  @DeleteMapping("/scouts/{id}")
  public void deleteScout(@PathVariable long id) {
    repository.deleteById(id);
  }
}
