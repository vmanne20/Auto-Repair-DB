package edu.vt.cs4604.troop;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface RepairCertRepository extends JpaRepository<RepairCert, RepairCertId> {

}