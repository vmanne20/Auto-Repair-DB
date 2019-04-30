package edu.vt.cs4604.troop;

import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

@RestController
class CarController {
  @Autowired
  private CarRepository repository;

  @PersistenceContext
  private EntityManager em;

  public CarController(CarRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/get-cars")
  public Collection<Car> cars(@RequestParam("c_id") Long c_id) {
    System.out.println("getting customer's cars");
    Query q = em.createNativeQuery("select c.* from car c where c.c_id = :customerId", Car.class)
                .setParameter("customerId", c_id);  
    List<Car> carList = q.getResultList();
    return carList.stream()
        .collect(Collectors.toList());
  }

  @PostMapping("/add-cars")
  public Car addCar(@RequestBody Car car) {
    System.out.println(car.toString());
    return repository.save(car);
  }

  @PutMapping("/update-cars")
  public Car updateCar(@RequestBody Car car) {
    System.out.println(car.toString());
    return repository.save(car);
  }

  @DeleteMapping("/delete-cars")
  public JSONObject deleteCar(@RequestBody Long carId) {
    System.out.println(carId);
    JSONObject obj = new JSONObject();
    try {
        repository.deleteById(carId);
        obj.put("Result", "OK");
    } catch (Exception e) {
        e.printStackTrace();
        obj.put("Result", "ERROR");
    }
    return obj;
  }

  @GetMapping("/activeCars")
  public Collection<Car> activeCars(@RequestParam("days") String days) {
    System.out.println("getting active cars");
    return repository.activeCars(days).stream()
      .collect(Collectors.toList());
  }
}
