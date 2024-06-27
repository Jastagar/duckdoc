<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>HEELO</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
    
    <div class="container-lg">
	    <form:form modelAttribute="todo" class="d-flex flex-column align-items-center" method="POST">
	    	<fieldset>
	    		<form:label path="description">Task:</form:label>
	    		<form:input path="description" class="form-control" type="text"/>	  		  		
	    	</fieldset>
	    	<fieldset>
	    		<form:label path="targetTime">Date:</form:label>
	    		<form:input path="targetTime" class="form-control" type="text"/>	  		  		
	    	</fieldset>
	    	<form:input path="id" class="form-control" type="hidden"/>
	    	<form:input path="done" class="form-control" type="hidden"/>
	    	<button id="submitButton" class="btn btn-warning d-inline">
	    		Update
	    	</button>
	    </form:form>
    </div>
    <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    
    <script>
		const button = document.getElementById("submitButton")
    	function updateTodo(id){
			const value = document.getElementById("updateInput").value
			const formData = new FormData()
			formData.append("id",id)
			formData.append("des",value)
			console.log("Value",value)
			fetch("/updateTodo",{
				method:"POST",
				body:formData,
				redirect:"follow"
			}).then(e => console.log("LOG-->",e) )		
			
    	}
		// button.addEventListener('click',()=>updateTodo(${todo.id}))
    </script>
</body>
</html>