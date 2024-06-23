package com.duckdoc.duckdoc;

public class Courses {
	private int id;
	private String name;
	private String description;
	
	public Courses(int id,String name, String des) {
		super();
		this.id = id;
		this.name = name;
		this.description = des;
	}
	
	public String getDescription() {
		return description;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
}
