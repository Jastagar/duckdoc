<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>HEELO</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
    
    <div class="container-lg">
	    <%@ include file="comps/navbar.jspf" %>
    	<table class="table table-striped">
    		<thead>
	    		<tr>
	    			<th>ID</th>
	    			<th>User Name</th>
	    			<th>Task</th>
	    			<th>TargetTime</th>
    		</tr>
    		</thead>
    		
    		<tbody>
    			<c:forEach items="${todos}" var="todo">
    				<c:if test="${todo.done}">
	    				<tr class="bg-success">
	    					<td class="text-white">${todo.id}</td>
	    					<td class="text-white">${todo.username}</td>
	    					<td class="text-white">${todo.description}</td>
	    					<td class="text-white">${todo.targetTime}</td>
	    					<td class="text-white">
	    						<button onClick="deleteTodo(${todo.id})" class="btn btn-danger"> Delete </button>
	    					</td>
	    					<td class="text-white">
	    						<a href="/updateTodo?id=${todo.id}" class="btn btn-warning"> Update </a>
	    					</td>
	    				</tr>
    				</c:if>
					<c:if test="${!todo.done}">
						<tr>
	    					<td>${todo.id}</td>
	    					<td>${todo.username}</td>
	    					<td>${todo.description}</td>
	    					<td>${todo.targetTime}</td>
	    					<td>
	    						<a onClick="deleteTodo(${todo.id})" class="btn btn-danger"> Delete </a>
	    					</td>
	    					<td class="text-white">
	    						<a href="/updateTodo?id=${todo.id}" class="btn btn-warning"> Update </a>
	    					</td>
	    				</tr>
					</c:if>
    			</c:forEach>
    		</tbody>
    	</table>
    	
    	<a href="/addTodo" class="btn btn-primary">
    		Add ToDo
    	</a>
    </div>
    <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script>
    	function deleteTodo(id){
			const formData = new FormData()
			formData.append("id",id);
			
			fetch("/deleteTodo",{
					method:"POST",
					body:formData,
					redirect:"follow"
				}).then(e =>{
				console.log("Log->",e);
			})
    	}
    </script>
    
</body>
</html>