package edu.vt.cs4604.troop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class ScoutController {
    private ScoutRepository repository;

    public ScoutController(ScoutRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/scouts")
    public Collection<Scout> scouts() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }
}
