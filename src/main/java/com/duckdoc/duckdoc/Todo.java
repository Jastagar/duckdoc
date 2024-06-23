package com.duckdoc.duckdoc;

import java.time.LocalDate;

public class Todo {
	private int id;
	private String username;
	private String description;
	private LocalDate targetTime;
	private boolean done;
	
	public Todo(int id, String username, String description, LocalDate targetTime, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetTime = targetTime;
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetTime() {
		return targetTime;
	}

	public void setTargetTime(LocalDate targetTime) {
		this.targetTime = targetTime;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todos [id=" + id + ", username=" + username + ", description=" + description + ", targetTime="
				+ targetTime + ", done=" + done + "]";
	}
	
	
	
	
}
