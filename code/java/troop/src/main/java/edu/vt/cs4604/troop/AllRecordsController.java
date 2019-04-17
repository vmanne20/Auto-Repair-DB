package edu.vt.cs4604.troop;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class AllRecordsController {
  @Autowired
  private AllRecordsRepository repository;

  public AllRecordsController(AllRecordsRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/allRecords")
  public Collection<AllRecords> allRecords() {
    System.out.println("getting all records");
    return repository.allRecords().stream().collect(Collectors.toList());
  }
}
