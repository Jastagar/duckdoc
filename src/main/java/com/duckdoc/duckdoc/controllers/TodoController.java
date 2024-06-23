package com.duckdoc.duckdoc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.duckdoc.duckdoc.Todo;
import com.duckdoc.duckdoc.TodoService;

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
	public String showAddTodoForm() {
		return "addTodo";
	}
	@RequestMapping(value="/addTodo",method=RequestMethod.POST)
	public String addNewTodo(@RequestParam String des, @RequestParam String username) {
		todoService.addTodo(des,username);
		return "redirect:todosHtml";
	}
}
