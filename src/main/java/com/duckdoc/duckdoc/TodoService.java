package com.duckdoc.duckdoc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<Todo>();
	private int todosCount = 4;
	static {
		todos.add(new Todo(1,"jastagar","SpringBoot Study0",LocalDate.now().plusYears(1),true));
		todos.add(new Todo(2,"Jastagar1","SpringBoot Study1",LocalDate.now().plusYears(2),false));
		todos.add(new Todo(3,"Jastagar2","SpringBoot Study2",LocalDate.now().plusYears(3),false));
		todos.add(new Todo(4,"Jastagar3","SpringBoot Study3",LocalDate.now().plusYears(4),false));
	}
	
	public List<Todo> getTodosByUsername(String username) {
		
		Predicate<Todo> predi = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predi).toList();
	}
	
	public List<Todo> addTodo(String des,String username, int days){
		Todo newtodo = new Todo((int)(Math.random()*100000),username,des,LocalDate.now().plusDays(days),false);
		this.todosCount++;
		todos.add(newtodo);
		return this.getTodosByUsername(username);
	}
	
	public Todo getTodoById(int id) {
		Predicate<Todo> predi = todo -> todo.getId()==id;
		return todos.stream().filter(predi).findFirst().get();
	}
	
	public boolean deleteTodo(int id) {
		Predicate<Todo> predi = todo -> todo.getId()==id;
		return todos.removeIf(predi);
	}
	
	public Todo updateTodo(int id, String des) {
		for(Todo t:todos) {
			if(t.getId()==id) {
				t.setDescription(des);
				return t;
			}
		}
		return null;
	}
	
	public int getTodosCount() {
		return todosCount;
	}
}
