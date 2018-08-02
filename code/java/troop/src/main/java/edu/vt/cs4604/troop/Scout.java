package edu.vt.cs4604.troop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Scout {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String passportNumber;
}
