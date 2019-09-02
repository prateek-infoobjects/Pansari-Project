<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

	<head>

		<meta charset="utf-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
				<meta name="viewport" content="width=device-width, initial-scale=1">
					<meta name="description"
						content="This page is created by Prateek Agarwal">
						<meta name="author" content="Prateek Agarwal">
							<%-- <meta name="keywords"
							content="Akshay,Hundia,Resume,Akshay Hundia Profile,Akshay Hundia CMU,Hundia Akshay CMU, Hundia Akshay,Akshay Hundia cloud"> --%>

							<title>Pansari Promoters</title>



<!--Starting here-->


  <!-- Custom fonts for this template-->
  <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="resources/css/sb-admin.css" rel="stylesheet">
  <script data-require="jquery@3.2.1" data-semver="3.2.1" src="resources/vendor/jquery/jquery.m.js"></script>
  <script data-require="jq-router@*" data-semver="4.3.0" src="resources/vendor/jquery/jq-router.js"></script>

  <!-- Styles-->
  <link rel="stylesheet" href="resources/css/styles.css">

<!--ending here-->


							<!-- jQuery -->
							  <%-- <script src="resources/script.js"></script> --%>
							<script src="resources/vendor/jquery/jquery.min.js"></script>
							<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
							<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css" rel="stylesheet" type="text/css">
								<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>

								<!-- Bootstrap Core CSS -->
								<!-- Latest compiled and minified CSS -->
								<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

									<!-- Optional theme -->
									<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
										<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" crossorigin="anonymous">

											<!-- Latest compiled and minified JavaScript -->
											<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
											<%-- <link href="resources/img/profile.png" rel="shortcut icon"
											type="image/x-icon" /> --%>
											<!-- Theme CSS -->
											<style type="text/css">
											.login-form {
												width: 340px;
												margin: 50px auto;
											}
											.login-form form {
												margin-bottom: 15px;
												background: #f7f7f7;
												box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
												padding: 30px;
											}
											.login-form h2 {
												margin: 0 0 15px;
											}
											.form-control, .btn {
												min-height: 38px;
												border-radius: 2px;
											}
											.btn {
												font-size: 15px;
												font-weight: bold;
											}



											/* Absolute Center Spinner */
.loading {
  position: fixed;
  z-index: 999;
  height: 2em;
  width: 2em;
  overflow: show;
  margin: auto;
  top: 0;
  left: 0;
  bottom: 0;
  right: 0;
}

/* Transparent Overlay */
.loading:before {
  content: '';
  display: block;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
    background: radial-gradient(rgba(20, 20, 20,.8), rgba(0, 0, 0, .8));

  background: -webkit-radial-gradient(rgba(20, 20, 20,.8), rgba(0, 0, 0,.8));
}

/* :not(:required) hides these rules from IE9 and below */
.loading:not(:required) {
  /* hide "loading..." text */
  font: 0/0 a;
  color: transparent;
  text-shadow: none;
  background-color: transparent;
  border: 0;
}

.loading:not(:required):after {
  content: '';
  display: block;
  font-size: 10px;
  width: 1em;
  height: 1em;
  margin-top: -0.5em;
  -webkit-animation: spinner 1500ms infinite linear;
  -moz-animation: spinner 1500ms infinite linear;
  -ms-animation: spinner 1500ms infinite linear;
  -o-animation: spinner 1500ms infinite linear;
  animation: spinner 1500ms infinite linear;
  border-radius: 0.5em;
  -webkit-box-shadow: rgba(255,255,255, 0.75) 1.5em 0 0 0, rgba(255,255,255, 0.75) 1.1em 1.1em 0 0, rgba(255,255,255, 0.75) 0 1.5em 0 0, rgba(255,255,255, 0.75) -1.1em 1.1em 0 0, rgba(255,255,255, 0.75) -1.5em 0 0 0, rgba(255,255,255, 0.75) -1.1em -1.1em 0 0, rgba(255,255,255, 0.75) 0 -1.5em 0 0, rgba(255,255,255, 0.75) 1.1em -1.1em 0 0;
box-shadow: rgba(255,255,255, 0.75) 1.5em 0 0 0, rgba(255,255,255, 0.75) 1.1em 1.1em 0 0, rgba(255,255,255, 0.75) 0 1.5em 0 0, rgba(255,255,255, 0.75) -1.1em 1.1em 0 0, rgba(255,255,255, 0.75) -1.5em 0 0 0, rgba(255,255,255, 0.75) -1.1em -1.1em 0 0, rgba(255,255,255, 0.75) 0 -1.5em 0 0, rgba(255,255,255, 0.75) 1.1em -1.1em 0 0;
}

/* Animation */

@-webkit-keyframes spinner {
  0% {
    -webkit-transform: rotate(0deg);
    -moz-transform: rotate(0deg);
    -ms-transform: rotate(0deg);
    -o-transform: rotate(0deg);
    transform: rotate(0deg);
  }
  100% {
    -webkit-transform: rotate(360deg);
    -moz-transform: rotate(360deg);
    -ms-transform: rotate(360deg);
    -o-transform: rotate(360deg);
    transform: rotate(360deg);
  }
}
@-moz-keyframes spinner {
  0% {
    -webkit-transform: rotate(0deg);
    -moz-transform: rotate(0deg);
    -ms-transform: rotate(0deg);
    -o-transform: rotate(0deg);
    transform: rotate(0deg);
  }
  100% {
    -webkit-transform: rotate(360deg);
    -moz-transform: rotate(360deg);
    -ms-transform: rotate(360deg);
    -o-transform: rotate(360deg);
    transform: rotate(360deg);
  }
}
@-o-keyframes spinner {
  0% {
    -webkit-transform: rotate(0deg);
    -moz-transform: rotate(0deg);
    -ms-transform: rotate(0deg);
    -o-transform: rotate(0deg);
    transform: rotate(0deg);
  }
  100% {
    -webkit-transform: rotate(360deg);
    -moz-transform: rotate(360deg);
    -ms-transform: rotate(360deg);
    -o-transform: rotate(360deg);
    transform: rotate(360deg);
  }
}
@keyframes spinner {
  0% {
    -webkit-transform: rotate(0deg);
    -moz-transform: rotate(0deg);
    -ms-transform: rotate(0deg);
    -o-transform: rotate(0deg);
    transform: rotate(0deg);
  }
  100% {
    -webkit-transform: rotate(360deg);
    -moz-transform: rotate(360deg);
    -ms-transform: rotate(360deg);
    -o-transform: rotate(360deg);
    transform: rotate(360deg);
  }
}

											</style>
											<link href="resources/css/freelancer.min.css" rel="stylesheet">

												<!-- Custom Fonts -->
												<link href="resources/vendor/font-awesome/css/font-awesome.min.css"
													rel="stylesheet" type="text/css">
													<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
														rel="stylesheet" type="text/css">
														<link
															href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
															rel="stylesheet" type="text/css">

															<script type='text/javascript'>


															$(document).ready(function() {
																//var fqdn="https://pansari-promoter-api-dot-pansari-promoter-app.appspot.com"
																// var fqdn="http://localhost:8080"



																var helpers =
																{

																	buildDropdown: function(result, dropdown, emptyMessage)
																	{
																		// Remove current options
																		dropdown.html('');
																		// Add the empty option with the empty message
																		dropdown.append('<option value="">' + emptyMessage + '</option>');
																		// Check result isnt empty
																		if(result != '')
																		{
																			// Loop through each of the results and append the option to the dropdown
																			$.each(result, function(k, v) {
																				dropdown.append('<option value="' + v.userid + '">' + v.name + '</option>');
																			});
																		}
																	}
																}
																$('#user-dropdown').hide();
																$.ajax({
																	url: fqdn+"/users",
																	type: "GET",
																	contentType: 'application/json',
																	crossDomain: true,
																	dataType: "json",
																	success: function (response) {
																		$("#loading-button").hide();
																		console.log("List of users retrived successfully");
																		// for (var i=0; i<response.length; i++)
																		// console.log(JSON.parse(response[i]))
																		// for (var i = 0, len = response.length; i < len; i++) {
																		// 	console.log(response[i].name);
																		// 	console.log(response[i].username);
																		// }
																		helpers.buildDropdown(
																			response,
																			$('#user-dropdown'),
																			'Select a user'
																		);
																		$('#user-dropdown').show();

																	},


																	error: function (xhr, status) {
																		$("#loading-button").hide();
																		console.error("error");
																	}
																});
																// var settings = {
																// 	'cache': false,
																// 	'dataType': "json",
																// 	"crossDomain": true,
																// 	"url": "http://localhost:8080/items/list",
																// 	"method": "GET",
																	// "headers": {
																	// 	"accept": "application/json",
																	// 	"Access-Control-Allow-Origin":"*"
																	// }
																// }
																//
																// $.ajax(settings).done(function (response) {
																// 	console.log(response);
																//
																// });

																$("#login-button").click(function(e) {
																	e.preventDefault();
																	var username = $("#login-username").val();
																	var password = $("#login-password").val();
																	if (!(username == '' || password == '')) {
																		$("#submitdata").empty();
																		console.log("Name: " + username + ", passwords: " + password);
																	} else {
																		console.log("Please Fill All Fields.");
																	}
																});

																var t = $('#example').DataTable();
																var counter = 1;

																$('#addRow').on( 'click', function () {
																	t.row.add( [
																		counter +'.1',
																		counter +'.2',
																		counter +'.3',
																		counter +'.4',
																		counter +'.5'
																	] ).draw( false );

																	counter++;
																} );

																$('#full-screen-loading').hide();
																// Automatically add a first row of data
																//$('#addRow').click();
																$('#submit-details').on('click', function(event) {
																	$('#full-screen-loading').show();
																	//event.preventDefault(); // To prevent following the link (optional)
																	var userid=$( "#user-dropdown option:selected" ).val();

																	var jsDate = $('#datepicker').datepicker('getDate');
																	var datestamp;
																	if (jsDate !== null) { // if any date selected in datepicker
																		jsDate instanceof Date; // -> true

																		var month=jsDate.getMonth() +1//getMonth starts from 0 index
																		month = (month < 10) ? '0' + month : month;// to make 6 to 06
																		var day=jsDate.getDate()
																		day = (day < 10) ? '0' + day : day;//to make 5 to 05
																		datestamp=jsDate.getFullYear()+"-" + month+ "-"+day
																	}
																	console.log(userid+","+datestamp);

																	function capitalizeFirstLetter(value) {
																		return value.charAt(0).toUpperCase() + value.slice(1);
																	}


																	$.ajax({
																		url: fqdn+"/realtime/getlocationreadings?userid="+userid+"&datestamp="+datestamp,
																		type: "GET",
																		contentType: 'application/json',
																		crossDomain: true,
																		dataType: "json",
																		success: function (response) {
																			var headerRow = '';
																			var bodyRows = '';
																			console.log(response);
																			if(response==""){
																				$('#full-screen-loading').hide();
																				alert("No response received for the user for "+datestamp)
																				return;
																			}
																			var cols = Object.keys(response[0]);
																			cols.map(function(col) {
																				headerRow += '<th>' + capitalizeFirstLetter(col) + '</th>';
																			});
																			headerRow += '<th>' + "Link"+ '</th>';
																			response.map(function(row) {
																				bodyRows += '<tr>';
																				// To do: Loop over object properties and create cells
																				cols.map(function(colName) {
																					if(colName=="received"){
																						var receivedDate=new Date(row[colName]);
																						bodyRows += '<td>' +
																						receivedDate.toLocaleString('en-US', { hour: 'numeric',minute: 'numeric',second :'numeric', hour12: true })
																						+ '</td>';
																					}
																					else{
																						bodyRows += '<td>' + row[colName] + '</td>';
																					}
																				});
																				var url="http://maps.google.com/maps?q="+row["latitude"]+","+row["longitude"];
																				url='<a href='+url+'  target="_blank">'+
																				'<button>Map Location</button>'+
																				'</a>';
																				bodyRows += '<td>' + url + '</td>';
																				bodyRows += '</tr>';

																			});


																			var x ='<table id="actual-table" class="display" style="width:100%"' +
																			'><thead><tr>' +
																			headerRow +
																			'</tr></thead><tbody>' +
																			bodyRows +
																			'</tbody></table>';

																			$("#example-table").html(x);
																			$('#actual-table').DataTable();
																			$('#full-screen-loading').hide();
																		},

																		error: function (xhr, status) {
																			console.error("error");
																		}
																	});
																});
															});

															$( function() {
																$( "#datepicker" ).datepicker();
															} );

															</script>
														</head>

														<body id="page-top" class="index">
<div class="loading" id="full-screen-loading">Loading...</div>
															<!-- Navigation -->
															<nav id="mainNav"
																class="navbar navbar-default navbar-fixed-top navbar-custom">
																<img class="img-responsive" src="resources/images/pansari-logo.png"
																	style="width:300px;height:100px;" align="left">
																	<div class="container">

																		<!-- Brand and toggle get grouped for better mobile display -->
																		<div class="navbar-header page-scroll">

																			<button type="button" class="navbar-toggle" data-toggle="collapse"
																				data-target="#bs-example-navbar-collapse-1">
																				<span class="sr-only">Toggle navigation</span> Menu <i
																				class="fa fa-bars"></i>
																			</button>
																			<a class="navbar-brand" style="margin-left:25px" href="#page-top">Pansari Promoters</a>
																		</div>


															<!-- /.navbar-collapse -->
														</div>
														<!-- /.container-fluid -->
													</nav>

													<!-- Header -->
													<header>
														<div class="container">

															<%-- 	<div class="row">



															<div class="login-form">
															<form method="post" action="#">
															<h2 class="text-center" style="color:black">Log in</h2>
															<div class="form-group">
															<input type="text" class="form-control" placeholder="Username" required="required" id="login-username">
														</div>
														<div class="form-group">
														<input type="password" class="form-control" placeholder="Password" required="required" id="login-password">
													</div>
													<div class="form-group">
													<button type="submit" class="btn btn-primary btn-block" id="login-button">Log in</button>
												</div>
												<%-- <div class="clearfix">
												<label class="pull-left checkbox-inline"><input type="checkbox"> Remember me</label>
												<a href="#" class="pull-right">Forgot Password?</a>
											</div>
										</form>
										<%-- <p class="text-center"><a href="#">Create an Account</a></p>
									</div>

								</div>--%>
							</div>
						</header>

						<div class="container">
							<div class="row">
								<%-- <div class="dropdown">
								<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Select User
								<span class="caret"></span></button>
								<ul class="dropdown-menu">
								<li><a href="#">HTML</a></li>
								<li><a href="#">CSS</a></li>
								<li><a href="#">JavaScript</a></li>
							</ul>
						</div> --%>

							<div class="dropdown" style="display: inline;">
								<select id="user-dropdown"></select>
							</div>

<button class="buttonload" id="loading-button">
  <i class="fa fa-spinner fa-spin"></i>Loading
</button>

							<p style="float:right;display: inline;">Date(YYYY-MM-DD): <input type="text" id="datepicker"></p>

						<div id="example-table"></div>
						<%-- <table id="example" class="display" style="width:100%;color:black">
						<thead>
						<tr>
						<th>UserID</th>
						<th>Date</th>
						<th>Time</th>
						<th>Latitude</th>
						<th>Longitude</th>
					</tr>
				</thead>
				<tfoot>
				<tr>
				<th>UserID</th>
				<th>Date</th>
				<th>Time</th>
				<th>Latitude</th>
				<th>Longitude</th>
			</tr>
		</tfoot>
	</table> --%>
</div>
<button type="button" class="btn btn-primary" id="submit-details">Submit</button>
</div>
<%-- <!-- Contact Section -->
<section id="contact">
<div class="container">
<div class="row">
<div class="col-lg-12 text-center">
<h2>Contact Me</h2>
<hr class="star-primary">
</div>
</div>
<div class="row">
<div class="col-lg-8 col-lg-offset-2">
<!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
<!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
<form name="sentMessage" id="contactForm" action="sendemail"
novalidate>
<div class="row control-group">
<div
class="form-group col-xs-12 floating-label-form-group controls">
<label>Name</label> <input type="text" class="form-control"
placeholder="Name" id="name" required
data-validation-required-message="Please enter your name.">
<p class="help-block text-danger"></p>
</div>
</div>
<div class="row control-group">
<div
class="form-group col-xs-12 floating-label-form-group controls">
<label>Email Address</label> <input type="email"
class="form-control" placeholder="Email Address" id="email">
<p class="help-block text-danger"></p>
</div>
</div>
<div class="row control-group">
<div
class="form-group col-xs-12 floating-label-form-group controls">
<label>Phone Number</label> <input type="tel"
class="form-control" placeholder="Phone Number" id="phone">
<p class="help-block text-danger"></p>
</div>
</div>
<div class="row control-group">
<div
class="form-group col-xs-12 floating-label-form-group controls">
<label>Message</label>
<textarea rows="5" class="form-control" placeholder="Message"
id="message"></textarea>
<p class="help-block text-danger"></p>
</div>
</div>
<br>
<div id="success"></div>
<div class="row">
<div class="form-group col-xs-12">
<button type="submit" class="btn btn-success btn-lg" id="myBtn">Send</button>
</div>
</div>
<script>
document
.getElementById("myBtn")
.addEventListener(
"click",
function() {
var msg = document
.getElementById("name").value
+ ","
+ +document
.getElementById("phone").value
+ ","
+ document
.getElementById("email").value
+ ","
+ document
.getElementById("message").value;
var xmlHttp = new XMLHttpRequest();
xmlHttp
.open("GET",
"sendemail?data="
+ msg,
false); // false for synchronous request
xmlHttp.send(null);
//alert( xmlHttp.responseText);
alert("Your message has been sent to Akshay. Thanks for reaching.");
location.reload();
});
</script>
</form>
</div>
</div>
</div>
</section> --%>

<!-- Footer -->
<%-- <footer class="text-center">
<div class="footer-above">
<div class="container">
<div class="row">
<div class="footer-col col-md-6">
<h3>Location</h3>
<p>
5880 Northumberland Street <br>Pittsburgh, PA 15217
</p>
</div>
<div class="footer-col col-md-6">
<h3>Around the Web</h3>
<ul class="list-inline">
<li><a href="https://www.facebook.com/ahundia"
class="btn-social btn-outline"><i
class="fa fa-fw fa-facebook"></i></a></li>
<li><a
href="https://plus.google.com/u/0/102512671059126681141"
class="btn-social btn-outline"><i
class="fa fa-fw fa-google-plus"></i></a></li>
<li><a href="https://twitter.com/akshayhundia1"
class="btn-social btn-outline"><i
class="fa fa-fw fa-twitter"></i></a></li>
<li><a href="https://www.linkedin.com/in/ahundia"
class="btn-social btn-outline"><i
class="fa fa-fw fa-linkedin"></i></a></li>

</ul>
</div>
<!-- <div class="footer-col col-md-4">
<h3>About Freelancer</h3>
<p>Freelance is a free to use, open source Bootstrap theme created by <a href="http://startbootstrap.com">Start Bootstrap</a>.</p>
</div> -->
</div>
</div>
</div>
<div class="footer-below">
<div class="container">
<div class="row">
<div class="col-lg-12">Copyright &copy; ahundia.com 2016</div>
</div>
</div>
</div>
</footer> --%>

<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
<div
	class="scroll-top page-scroll hidden-sm hidden-xs hidden-lg hidden-md">
	<a class="btn btn-primary" href="#page-top"> <i
		class="fa fa-chevron-up"></i>
	</a>
</div>

<!-- Portfolio Modals -->
