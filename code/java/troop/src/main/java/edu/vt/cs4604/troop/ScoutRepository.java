package edu.vt.cs4604.troop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface ScoutRepository extends JpaRepository<Scout, String> {
}
