package edu.vt.cs4604.troop;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

// import java.util.ArrayList;
import java.util.Collection;
// import java.util.List;
import java.util.stream.Collectors;
// import javax.persistence.*;

@RestController
class AllRecordsController {
  @Autowired
  private AllRecordsRepository repository;
//   private EntityManagerFactory emfactory;
//   private EntityManager em;

  public AllRecordsController(AllRecordsRepository repository) {
    this.repository = repository;
    // emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
    // em = emfactory.createEntityManager();
  }

  @GetMapping("/allRecords")
  public Collection<AllRecords> allRecords() {
    System.out.println("getting all records");
    // Query q = em.createNamedQuery("allRecordsQuery");
    // List<Object[]> results = q.getResultList();
    // List<AllRecords> records = new ArrayList<>();
    // results.stream().forEach((record) -> {
    //     Long c_id = ((Long) record[0]).longValue();
    //     String c_name = (String) record[1];
    //     String c_address = (String) record[2];
    //     String c_number = (String) record[3];
    //     String make_year = (String) record[4];
    //     String make = (String) record[5];
    //     String model = (String) record[6];
    //     records.add(new AllRecords(c_id, c_name, c_address, c_number, make_year, make, model));
    // });
    return repository.allRecords().stream().collect(Collectors.toList());
  }
}
