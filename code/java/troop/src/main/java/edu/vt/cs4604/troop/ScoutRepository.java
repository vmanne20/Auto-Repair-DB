package edu.vt.cs4604.troop;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface ScoutRepository extends JpaRepository<Scout, Long> {
     /**
     * Finds person by using the last name as a search criteria.
     * @param lastName
     * @return  A list of persons whose last name is an exact match with the given last name.
     *          If no persons is found, this method returns null.
     */
    public List<Scout> activeScouts();
}
