package edu.vt.cs4604.troop;

import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;
import javax.persistence.Query;

@RestController
class CertController {
  @Autowired
  private CertRepository repository;

  @PersistenceContext
  private EntityManager em;

  public CertController(CertRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/get-mechanic-certs")
  public Collection<Cert> getMechanicCerts(@RequestParam("m_id") Long m_id) {
    System.out.println("getting Mechanic Certs");
    Query q = em.createNativeQuery("select c.* from certification c, mechanic_certification mc where mc.m_id = :mechId and mc.cert_id = c.cert_id", Cert.class)
                .setParameter("mechId", m_id);  
    List<Cert> certList = q.getResultList();
    return certList.stream()
        .collect(Collectors.toList());
  }

  @GetMapping("/get-repair-certs")
  public Collection<Cert> getRepairCerts(@RequestParam("r_id") Long r_id) {
    System.out.println("getting Repair Certs");
    Query q = em.createNativeQuery("select c.* from certification c, repair_certification rc where rc.r_id = :repairId and rc.cert_id = c.cert_id", Cert.class)
                .setParameter("repairId", r_id);  
    List<Cert> certList = q.getResultList();
    return certList.stream()
        .collect(Collectors.toList());
  }

  @PostMapping("/add-certs")
  public Cert addCert(@RequestBody Cert cert) {
    System.out.println(cert.toString());
    return repository.save(cert);
  }

  @PutMapping("/update-certs")
  public Cert updateCert(@RequestBody Cert cert) {
    System.out.println(cert.toString());
    return repository.save(cert);
  }

  @DeleteMapping("/delete-certs")
  public JSONObject deleteCert(@RequestBody Long certId) {
    System.out.println(certId);
    JSONObject obj = new JSONObject();
    try {
        repository.deleteById(certId);
        obj.put("Result", "OK");
    } catch (Exception e) {
        e.printStackTrace();
        obj.put("Result", "ERROR");
    }
    return obj;
  }
}
