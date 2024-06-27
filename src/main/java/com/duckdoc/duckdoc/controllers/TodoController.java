package com.duckdoc.duckdoc.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.duckdoc.duckdoc.Todo;
import com.duckdoc.duckdoc.TodoService;

import jakarta.validation.Valid;

@Controller
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
		String username = getLoggedInUsername(model);
		Todo todo = new Todo(0,username,"",LocalDate.now(),false);
		model.put("todo", todo); // Default
		return "addTodo";
	}

	private String getLoggedInUsername(ModelMap model) {
		Authentication authUser = SecurityContextHolder.getContext().getAuthentication();
		return authUser.getName();
	}
	
	@RequestMapping(value="/addTodo",method=RequestMethod.POST)
	public String addNewTodo(Todo todo, ModelMap model) {
		todoService.addTodo(todo.getDescription(),getLoggedInUsername(model),10);
		return "redirect:todosHtml";
	}
	
	@RequestMapping(value="/deleteTodo",method=RequestMethod.POST)
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:todosHtml";
	}
	
	@RequestMapping(value="/updateTodo",method=RequestMethod.GET)
	public String updateTodo(@RequestParam int id,ModelMap model) {
		Todo reqTodo = todoService.getTodoById(id);
		model.addAttribute("todo",reqTodo);
		return "updateTodo";
	}
	@RequestMapping(value="/updateTodo",method=RequestMethod.POST)
	public String updateTodo(@RequestParam int id,@RequestParam String description, @Valid Todo t, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todosHtml";
		}
		
		todoService.updateTodo(id,description);
		return "redirect:todosHtml";
	}
}
