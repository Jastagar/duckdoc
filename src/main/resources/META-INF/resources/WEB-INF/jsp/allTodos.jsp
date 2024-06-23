<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>HEELO</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
    
    <div class="container-lg">
	    <h1>
	        Welcome to
	    </h1>
	    <h2>
	        DuckDoc
	    </h2>
    	<table class="table table-striped">
    		<thead>
	    		<tr>
	    			<th>ID</th>
	    			<th>User Name</th>
	    			<th>Task</th>
	    			<th>TargetTime</th>
	    			<th>Done?</th>
    		</tr>
    		</thead>
    		
    		<tbody>
    			<c:forEach items="${todos}" var="todo">
    				<tr>
    					<td>${todo.id}</td>
    					<td>${todo.username}</td>
    					<td>${todo.description}</td>
    					<td>${todo.targetTime}</td>
    					<td>${todo.done}</td>
    				</tr>
    			</c:forEach>
    		</tbody>
    	</table>
    	
    	<a href="/addTodo" class="btn btn-primary">
    		Add ToDo
    	</a>
    </div>
    <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
</body>
</html>