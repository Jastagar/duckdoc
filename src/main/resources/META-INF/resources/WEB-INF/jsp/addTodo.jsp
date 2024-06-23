<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>HEELO</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
    
    <div class="container-lg">
	    <form class="d-flex flex-column align-items-center" method="post">
	    	<label>
	    		Name:<input name="username" class="form-control" type="text">
	    	</label>
	    	<label>
	    		Task:<input name="des" class="form-control" type="text">
	    	</label>
	    	<button class="btn btn-success d-inline">
	    		Add
	    	</button>
	    </form>
    </div>
    <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
</body>
</html>