<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Maven + Spring MVC + @JavaConfig</title>

<script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
  
<spring:url value="/resources/css/style.css" var="coreCss" />
<spring:url value="/resources/js/survey.js" var="corejs" />
<!--<spring:url value="/resources/js/main.js" var="mainjs" />
<spring:url value="/resources/js/recorderWorker.js" var="voicejs" />
<spring:url value="/resources/js/recorder.js" var="recorder" />-->

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>

<link href="${coreCss}" rel="stylesheet" />
<script src="${corejs}"></script>
<!-- <script src="${voicejs}"></script>
<script src="${voicejs}"></script>
<script src="${recorder}"></script>-->


</head>
<body style="height:100%;background-color:#d9edf7">
<div class="container-fluid bg-info">
	<div id="main-body">
	</div>
    
   
   
</div>
</div>
</div>


  

</body>
</html>