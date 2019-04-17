package edu.vt.cs4604.troop;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;
import javax.persistence.*;

@RestController
class AllRecordsController {
  @Autowired
  private AllRecordsRepository repository;
  private EntityManagerFactory emfactory;
  private EntityManager em;

  public AllRecordsController(AllRecordsRepository repository) {
    this.repository = repository;
    emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
    em = emfactory.createEntityManager();
  }

  @GetMapping("/allRecords")
  public void allRecords() {
    System.out.println("getting all records");
    em.createNamedQuery("allRecordsQuery");
  }
}
