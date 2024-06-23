package com.duckdoc.duckdoc.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.duckdoc.duckdoc.Todo;
import com.duckdoc.duckdoc.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService todoService;
	
	
	public TodoController(TodoService todoSevice) {
		super();
		this.todoService = todoSevice;
	}

	@RequestMapping("/todos")
	public List<Todo> getAllTodos(@RequestParam String username){
		return todoService.getTodosByUsername(username);
	}
	
	@RequestMapping("/todosHtml")
	public String getAllTodosHtml(ModelMap model){
		model.addAttribute("todos",todoService.getTodosByUsername("jastagar"));
		return "allTodos";
	}
	
	@RequestMapping(value="/addTodo",method=RequestMethod.GET)
	public String showAddTodoForm(ModelMap model) {
		String username = (String)model.get("name");
		Todo todo = new Todo(0,username,"",LocalDate.now(),false);
		model.put("todo", todo); // Default
		return "addTodo";
	}
	
	@RequestMapping(value="/addTodo",method=RequestMethod.POST)
	public String addNewTodo(Todo todo, ModelMap model) {
		todoService.addTodo(todo.getDescription(),(String)model.get("name"),10);
		return "redirect:todosHtml";
	}
}
