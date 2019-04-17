package edu.vt.cs4604.troop;

import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
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
  public JSONObject deleteCar(@RequestBody Long carId) {
    System.out.println(carId);
    // Car deletedCar = null;
    JSONObject obj = new JSONObject();
    try {
        // deletedCar = repository.findById(carId).get();
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
