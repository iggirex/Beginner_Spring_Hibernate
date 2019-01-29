<!DOCTYPE html>
<html>
<head>

	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/static-resources/css/index.css">
		
	<script src="${pageContext.request.contextPath}/static-resources/js/index.js">
	</script>

	<title>Hello World</title>
</head>

	Hello World of Spring!
	
	<br><br>
	
	Student name: ${param.studentName}
	
	<br><br>
	
	Message = ${message}
	
	<br><br>
	
	<input type="button" onclick="doSomeWork()" value="Click Me" />
	
	<br><br>
	
	<!-- need  ${pageContext.request.contextPath} to access root dir of app -->
	<img id="image" 
		src="${pageContext.request.contextPath}/static-resources/images/hellNoWorld.png">

</html>