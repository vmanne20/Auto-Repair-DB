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
    System.out.println("getting Certs");
    Query q = em.createNativeQuery("select c.* from certification c where c.m_id = :mechId", Cert.class)
                .setParameter("mechId", m_id);  
    List<Cert> certList = q.getResultList();
    return certList.stream()
        .collect(Collectors.toList());
  }

  @GetMapping("/get-repair-certs")
  public Collection<Cert> getRepairCerts(@RequestParam("r_id") Long r_id) {
    System.out.println("getting Certs");
    Query q = em.createNativeQuery("select c.* from certification c where c.r_id = :repairId", Cert.class)
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
