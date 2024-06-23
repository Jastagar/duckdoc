package com.duckdoc.duckdoc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<Todo>();
	private int todosCount = 4;
	static {
		todos.add(new Todo(1,"jastagar","SpringBoot Study",LocalDate.now().plusYears(1),true));
		todos.add(new Todo(2,"jastagar1","SpringBoot Study1",LocalDate.now().plusYears(2),false));
		todos.add(new Todo(3,"jastagar2","SpringBoot Study2",LocalDate.now().plusYears(3),false));
		todos.add(new Todo(4,"jastagar3","SpringBoot Study3",LocalDate.now().plusYears(4),false));
	}
	
	public List<Todo> getTodosByUsername(String username) {
		return todos;
	}
	
	public List<Todo> addTodo(String des,String username, int days){
		Todo newtodo = new Todo((int)(Math.random()*100000),username,des,LocalDate.now().plusDays(days),false);
		this.todosCount++;
		todos.add(newtodo);
		return this.getTodosByUsername(username);
	}

	public int getTodosCount() {
		return todosCount;
	}
}
