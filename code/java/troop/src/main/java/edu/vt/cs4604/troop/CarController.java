package edu.vt.cs4604.troop;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
class CarController {
  @Autowired
  private CarRepository repository;

  public CarController(CarRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/cars")
  public Collection<Car> cars() {
    System.out.println("getting cars");
    return repository.findAll().stream()
      .collect(Collectors.toList());
  }

  @PostMapping("/cars")
  public Car addCar(@RequestBody Car car) {
    System.out.println(car.toString());
    return repository.save(car);
  }

  @PutMapping("/cars")
  public Car updateCar(@RequestBody Car car) {
    System.out.println(car.toString());
    return repository.save(car);
  }

  @DeleteMapping("/cars")
  public void deleteCar(@RequestBody Car car) {
    System.out.println(car.toString());
    try {
        repository.delete(car);
    } catch (Exception e) {
        throw e;
    }
  }

  @GetMapping("/activeCars")
  public Collection<Car> activeCars(@RequestParam("days") String days) {
    System.out.println("getting active cars");
    return repository.activeCars(days).stream()
      .collect(Collectors.toList());
  }
}
