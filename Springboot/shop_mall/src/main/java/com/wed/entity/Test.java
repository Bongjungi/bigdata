package com.wed.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test {
	@Id	
	private Long id;
	
	private String name;
	private int age;
}
