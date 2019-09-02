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

<!-- jQuery -->
<script src="resources/vendor/jquery/jquery.min.js"></script>


<!-- Bootstrap Core CSS -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

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

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<%-- <script>
	(function(i, s, o, g, r, a, m) {
		i['GoogleAnalyticsObject'] = r;
		i[r] = i[r] || function() {
			(i[r].q = i[r].q || []).push(arguments)
		}, i[r].l = 1 * new Date();
		a = s.createElement(o), m = s.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = g;
		m.parentNode.insertBefore(a, m)
	})(window, document, 'script',
			'https://www.google-analytics.com/analytics.js', 'ga');

	ga('create', 'UA-91650969-1', 'auto');
	ga('send', 'pageview');
</script> --%>
<script type='text/javascript'>

$(document).ready(function() {
	$("#login-button").click(function(e) {
		e.preventDefault();
		var username = $("#login-username").val();
		var password = $("#login-password").val();
		if (!(username == '' || password == '')) {
			$("#submitdata").empty();
			alert("Name: " + username + "<brpasswords: " + password);
		} else {
			alert("Please Fill All Fields.");
		}
	});
});
</script>
</head>

<body id="page-top" class="index">

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

			<!-- Collect the nav links, forms, and other content for toggling -->
			<%-- <div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li class="hidden"><a href="#page-top"></a></li>
					<li class="page-scroll"><a href="#current">Current Postion</a>
					</li>
					<li class="page-scroll"><a href="#education">Education</a></li>
					<li class="page-scroll"><a href="#portfolio">Projects</a></li>
					<li class="page-scroll"><a href="#skills">Skills</a></li>
					<li class="page-scroll"><a href="#job">Experience</a></li>
					<li class="page-scroll"><a href="#leader">Leadership</a></li>
					<li class="page-scroll"><a href="#contact">Contact</a></li>
				</ul>
			</div> --%>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<!-- Header -->
	<header>
		<div class="container">
			<div class="row">
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
				        </div> --%>
				    </form>
				    <%-- <p class="text-center"><a href="#">Create an Account</a></p> --%>
				</div>
				<%-- <div class="col-lg-12">
					<%-- <img class="img-responsive" src="resources/img/my1.png" alt="">
					<div class="intro-text">
						<span class="name">Akshay Hundia</span>
						<p>
							<b>12Software Engineer with 7+ years of experience in designing
								and developing cutting edge products using Object Oriented
								Programming. An equally effective problem solver and
								entrepreneur experienced in creating technological solutions to
								solve real world issues. My current focus area is building cloud based enterprise solutions.</b>
						</p>
						<hr class="star-light">
						<span class="skills">Backend Stack (Micro-services) | Cloud Application | Blockchain developer</span>
						<p>Cloud and Distributed Systems</p>
					</div>
				</div> --%>
			</div>
		</div>
	</header>

	<%-- <!-- Portfolio Grid Section -->
	<section id="current">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2>Current Postion</h2>
					<hr class="star-primary">
				</div>
			</div>
			<div class="col-sm-4 portfolio-item">
			</div>
			<div class="col-sm-4 portfolio-item">
					<div style="vertical-align: middle; text-align: center; max-width:350px; margin-top:25%; margin-bottom:25%;">
						<img src="resources/img/slb.jpg" class="img-responsive" alt=""
							style="display: block; margin-left: auto; margin-right: auto;">
						<br />
						<p>
							<a href="#slbModal" class="portfolio-link" data-toggle="modal">

								Cloud & Data Infrastructure Engineer</a>
						</p>

						<a href="#slbModal"  data-toggle="modal">

                        								What I do at Schlumberger?</a>
					</div>

				</div>
			<div class="col-sm-4 portfolio-item">
			</div>
			<!-- <div class="row">
				<div class="col-sm-4 portfolio-item">
					  <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                            </div>
                        </div>
					<div style="vertical-align: middle; text-align: center;">
						<img src="resources/img/cmu.jpeg" class="img-responsive" alt=""
							style="display: block; margin-left: auto; margin-right: auto;">
						<br />
						<p>
							<a href="#raModal" class="portfolio-link" data-toggle="modal">

								Research Assistant </a>
						</p>

						<a href="https://www.cylab.cmu.edu">Cylab</a>
					</div>

				</div>
				<div class="col-sm-4 portfolio-item">
					<div style="vertical-align: middle; text-align: center;">
						<img src="resources/img/cmu.jpeg" class="img-responsive" alt=""
							style="display: block; margin-left: auto; margin-right: auto;">
						<br />
						<p>
							<a href="#tadModal" class="portfolio-link" data-toggle="modal">

								Teaching Assistant </a>
						</p>

						<a
							href="http://www.heinz.cmu.edu/academic-resources/course-results/course-details/index.aspx?cid=295">Distributed
							Systems</a>
					</div>

				</div>
				<div class="col-sm-4 portfolio-item">

					<div style="vertical-align: middle; text-align: center;">
						<img src="resources/img/cmu.jpeg" class="img-responsive" alt=""
							style="display: block; margin-left: auto; margin-right: auto;">
						<br />
						<p>
							<a href="#tajModal" class="portfolio-link" data-toggle="modal">

								Teaching Assistant </a>
						</p>

						<a
							href="http://www.heinz.cmu.edu/academic-resources/course-results/course-details/index.aspx?cid=302">Intermediate
							Java II</a>
					</div>

				</div>

			</div> -->
		</div>
	</section> --%>
	<!-- About Section -->
	<%-- <section class="success" id="education">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2>Education</h2>
					<hr class="star-light">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6">
				<img src="resources/img/cmu.jpeg" class="img-responsive" alt=""
                							style="display: block; margin-left: auto; margin-right: auto;">
                						<br />
					<p>
						<b>Master of Information Systems Management (May, 2017)</b>
					</p>
				</div>
				<div class="col-lg-6">
				    <img src="resources/img/daiict.png" class="img-responsive" alt=""
                                							style="display: block; margin-left: auto; margin-right: auto;">
                                						<br />
					<p style='text-align:center;'>
						<b>Bachelor of Technology in Information and Communication
							Technology (May, 2011)</b>
					</p>
				</div>
				<div class="col-lg-8 col-lg-offset-2 text-center">
					<!-- <a href="resources/files/unofficial_academic_record-Fall.pdf" download class="btn btn-lg btn-outline"> <i
						class="fa fa-download"></i> Download Unofficial Transcripts
					</a> -->
					<a href="resources/files/akshay-hundia.pdf" download
						class="btn btn-lg btn-outline"> <i class="fa fa-download"></i>
						Download Resume
					</a>
				</div>
			</div>
		</div>
	</section> --%>



	<%-- <!-- Portfolio Grid Section -->
	<section id="portfolio">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2>Academic Projects</h2>
					<hr class="star-primary">
					<h3>Capstone</h3>
					<div class="col-sm-4 portfolio-item"></div>
					<div class="col-sm-4 portfolio-item">
						<a href="#capModal" class="portfolio-link" data-toggle="modal">
							<div class="caption">
								<div class="caption-content">
									Kent Parker Media platform <i class="fa fa-search-plus fa-3x"></i>
								</div>
							</div> <img src="resources/img/kp.png" class="img-responsive" alt=""
							style="height: 280px; width: 400px; display: block; margin-left: auto; margin-right: auto;">
							<h4>Kent Parker</h4>
							<p>Chief Technology Architect</p>
						</a>


					</div>
					<div class="col-sm-4 portfolio-item"></div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4 portfolio-item"></div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<hr class="star-primary">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4 portfolio-item">
					<a href="#ddcModal" class="portfolio-link" data-toggle="modal">
						<div class="caption">
							<div class="caption-content">
								<p>Distributed Data Center</p>
							</div>
						</div> <img src="resources/img/replication.svg" class="img-responsive"
						alt=""
						style="height: 230px; width: 400px; display: block; margin-left: auto; margin-right: auto;">
						<h5 style="text-align: center;">Distributed Data Center</h5>
					</a>

				</div>
				<div class="col-sm-4 portfolio-item">
					<a href="#pittModal" class="portfolio-link" data-toggle="modal">
						<div class="caption">
							<div class="caption-content">
								<p>PittCabs: Real-time transit and Dynamic pricing</p>
							</div>
						</div> <img src="resources/img/kafka.png" class="img-responsive" alt=""
						style="height: 230px; width: 400px; display: block; margin-left: auto; margin-right: auto;">
						<h5 style="text-align: center;">PittCabs</h5>
					</a>
				</div>
				<div class="col-sm-4 portfolio-item">
					<a href="#docModal" class="portfolio-link"
						data-toggle="modal">
						<div class="caption">
							<div class="caption-content">
								<p>Docker containerized web service</p>
							</div>
						</div> <img src="resources/img/database.png" class="img-responsive"
						alt=""
						style="height: 230px; width: 400px; display: block; margin-left: auto; margin-right: auto;">
						<h5 style="text-align: center;">Storage and Databases</h5>
					</a>
				</div>
				<div class="col-sm-4 portfolio-item">
					<a href="#portfolioModal4" class="portfolio-link"
						data-toggle="modal">
						<div class="caption">
							<div class="caption-content">
								<p>Fast interactive web services</p>
							</div>
						</div> <img src="resources/img/webservices.png" class="img-responsive"
						alt=""
						style="height: 230px; width: 400px; display: block; margin-left: auto; margin-right: auto;">
						<h5 style="text-align: center;">Fast interactive web services</h5>
					</a>
				</div>
				<div class="col-sm-4 portfolio-item">
					<a href="#portfolioModal5" class="portfolio-link"
						data-toggle="modal">
						<div class="caption">
							<div class="caption-content">
								<p>Big Data Analytics</p>
							</div>
						</div> <img src="resources/img/big-data.png" class="img-responsive"
						alt=""
						style="height: 230px; width: 400px; display: block; margin-left: auto; margin-right: auto;">
						<h5 style="text-align: center;">Big Data Analytics</h5>
					</a>
				</div>
				<div class="col-sm-4 portfolio-item">
					<a href="#portfolioModal6" class="portfolio-link"
						data-toggle="modal">
						<div class="caption">
							<div class="caption-content">
								<p>Marketing Analytics</p>
							</div>
						</div> <img src="resources/img/ma.jpg" class="img-responsive" alt=""
						style="height: 230px; width: 400px; display: block; margin-left: auto; margin-right: auto;">
						<h5 style="text-align: center;">Marketing Analytics</h5>
					</a>
				</div>
			</div>
		</div>
	</section> --%>
	<!-- About Section -->
	<%-- <section class="success" id="skills">
		<div class="container" style="padding-top:5%;padding-bottom:5%;">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2>Skills</h2>
					<hr class="star-light">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4 col-lg-offset-2">
					<p>Languages:</p>
				</div>
				<div class="col-lg-6">
					<p>Java, React, Python, HTML5, CSS3, JavaScript, NodeJS, Shell
						Scripting(CentOS/Ubuntu), C++, C</p>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4 col-lg-offset-2">
					<p>Frameworks & Development Toolkits:</p>
				</div>
				<div class="col-lg-6">
					<p>Native Android (Coursera Certified), React Native, AWS,
						Azure, Docker, Spring, Hibernate</p>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4 col-lg-offset-2">
					<p>Code Repository & Management:</p>
				</div>
				<div class="col-lg-6">
					<p>Git, Bit-bucket, SVN, Gerrit, Jenkins, Rally</p>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4 col-lg-offset-2">
					<p>Databases:</p>
				</div>
				<div class="col-lg-6">
					<p>MySQL, Oracle, Mongo DB, Dynamo DB, Redis, Elastic Search,
						Hadoop, HBase</p>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4 col-lg-offset-2">
					<p>Cloud Services:</p>
				</div>
				<div class="col-lg-6">
					<p>Amazon Web Services, Microsoft Azure</p>
				</div>
			</div>



		</div>
	</section> --%>

	<!-- Portfolio Grid Section -->
	<%-- <section id="job">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2>Job Experience</h2>
					<hr class="star-primary">
				</div>
			</div>
			<div class="row">
				<!-- <div class="col-sm-4 portfolio-item">
					<a href="#portfolioModal6" class="portfolio-link"
						data-toggle="modal"> <!-- <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                            </div>
                        </div> <img src="resources/img/cmuj.png"
						class="img-responsive" alt="" height:230px;width:400px;display: block; margin-left: auto; margin-right: auto;>
					</a>
				</div>
				<div class="col-sm-4 portfolio-item">
					<a href="#portfolioModal1" class="portfolio-link"
						data-toggle="modal"> <!-- <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                            </div>
                        </div> <img src="resources/img/sf.png"
						class="img-responsive" alt="" height:230px;width:400px;display: block; margin-left: auto; margin-right: auto;>
					</a>
				</div> -->
				<div class="col-sm-3 portfolio-item">
					 <div style="vertical-align: middle; text-align: center;">
						<img src="resources/img/cmu.jpeg" class="img-responsive" alt=""
							style="display: block; margin-left: auto; margin-right: auto;">
						<br />
						<p>
							<a href="#raModal" class="portfolio-link" data-toggle="modal">

								Research Assistant </a>
						</p>

						<a href="https://www.cylab.cmu.edu">Cylab</a>
					</div>

				</div>
				<!-- <div class="col-sm-3 portfolio-item">
					<div style="vertical-align: middle; text-align: center;">
						<img src="resources/img/cmu.jpeg" class="img-responsive" alt=""
							style="display: block; margin-left: auto; margin-right: auto;">
						<br />
						<p>
							<a href="#tadModal" class="portfolio-link" data-toggle="modal">

								Teaching Assistant </a>
						</p>

						<a
							href="http://www.heinz.cmu.edu/academic-resources/course-results/course-details/index.aspx?cid=295">Distributed
							Systems</a>
					</div>

				</div>
				<div class="col-sm-3 portfolio-item">

					<div style="vertical-align: middle; text-align: center;">
						<img src="resources/img/cmu.jpeg" class="img-responsive" alt=""
							style="display: block; margin-left: auto; margin-right: auto;">
						<br />
						<p>
							<a href="#tajModal" class="portfolio-link" data-toggle="modal">

								Teaching Assistant </a>
						</p>

						<a
							href="http://www.heinz.cmu.edu/academic-resources/course-results/course-details/index.aspx?cid=302">Intermediate
							Java II</a>
					</div>

				</div>-->

				<div class="col-sm-3 portfolio-item">

					<div style="vertical-align: middle; text-align: center;">
						<img src="resources/img/samsung.jpg" class="img-responsive" alt=""
							style="display: block; margin-left: auto; margin-right: auto;">
						<br />
						<p style="margin-top:40px;">
							<a href="#samModal" class="portfolio-link" data-toggle="modal">

								Lead Engineer </a>
						</p>

						<a
							href="http://www.samsung.com/in/aboutsamsung/home/">Samsung Research and Development Institute </a>
					</div>

				</div>
				<div class="col-sm-3 portfolio-item">

					<div style="vertical-align: middle; text-align: center;">
						<img src="resources/img/hpe.jpg" class="img-responsive" alt=""
							style="display: block; margin-left: auto; margin-right: auto;">
						<br />
						<p style="margin-top:45px;">
							<a href="#hpeModal" class="portfolio-link" data-toggle="modal">

								Software Engineer II </a>
						</p>

						<a
							href="https://www.hpe.com/us/en/home.html">Hewlett Packard Enterprise </a>
					</div>

				</div>
				<div class="col-sm-3 portfolio-item">

					<div style="vertical-align: middle; text-align: center;">
						<img src="resources/img/mi.jpeg" class="img-responsive" alt=""
							style="display: block; margin-left: auto; margin-right: auto;">
						<br />
						<p style="margin-top:60px;">
							<a href="#miModal" class="portfolio-link" data-toggle="modal">

								Engineer II, MFG-IT </a>
						</p>

						<a
							href="https://www.maximintegrated.com/en.html">Maxim Integrated </a>
					</div>

				</div>









			</div>

			<div class="container" style="margin-bottom:50px;">
				<div class="row">
					<div class="col-lg-12 text-center">
						<h3>
							<u>Entrepreneur</u>
						</h3>
					</div>
				</div>
				<br/>
				<div class="row">
					<div class="col-sm-4 portfolio-item"></div>
					<div class="col-sm-4 portfolio-item">
						<a href="#portfolioModal1" class="portfolio-link"
							data-toggle="modal"> <!-- <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                            </div>
                        </div> --> <img src="resources/img/sf.png"
							class="img-responsive" alt=""
							style="height: 200px; width: 300px; display: block; margin-left: auto; margin-right: auto;">
						</a>
						<h4 style="text-align: center;">Chief Technology Officer</h4>

					</div>
					<div class="col-sm-4 portfolio-item"></div>
				</div>
			</div>
		</div>
	</section> --%>

	<%-- <!-- About Section -->
	<section class="success" id="leader">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2>Leadership and Accomplishments</h2>
					<hr class="star-light">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<p>Collaborated with Pittsburgh Port Authority, as a member of
						'Students for Urban Data Systems', to improve public bus services.
					</p>
				</div>
				<div class="col-lg-12">
					<p>Served as the Convener, Student Government, DA-IICT for the
						year 2010-2011.</p>
				</div>
				<div class="col-lg-12">
					<p>Deputy-Convener, Cultural Committee 2009-2010.</p>
				</div>
				<div class="col-lg-12">
					<p>Coordinator of Rampage (Fashion event) in Annual Fest 2010.</p>
				</div>
				<div class="col-lg-12">
					<p>Founder Member of Excursion Club in DA-IICT.</p>
				</div>


			</div>
		</div>
	</section> --%>

	<!-- Contact Section -->
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
	</section>

	<!-- Footer -->
	<footer class="text-center">
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
	</footer>

	<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
	<div
		class="scroll-top page-scroll hidden-sm hidden-xs hidden-lg hidden-md">
		<a class="btn btn-primary" href="#page-top"> <i
			class="fa fa-chevron-up"></i>
		</a>
	</div>

<!-- Portfolio Modals -->
	<div class="portfolio-modal modal fade" id="slbModal" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-3>
						<div class="modal-body">
							<h2>Schlumberger</h2>
						<hr/>
						<br/>

						<div class="col-md-6">
							<h4>
								<a href="https://www.software.slb.com/delfi">Delfi data ecosystem</a>
							</h4>
							<hr class="star-primary">
							<img src="resources/img/delfi.jpeg"
								class="img-responsive img-centered" alt="">
							<p>DELFI is cloud based cognitive solution to enable Machine Learning & Data Analytics on exploration and production data.</p>
							<p>It is a multi-tenant solution build leveraging Google Cloud Project and SOA architecture. This platform has enabled end users to extract meaningful information from their data.</p>

                        </div>
                        <div class="col-md-6" style='text-align:left;'>
                            <h4>My Contribution</h4>
                            <b>Technology:</b>Java and Python,Google compute engine,Google datastore,Google App Engine,Google Dataflow,Google Stackdriver,Redis/Memcache,Key Management System,Kubernetes,Hyperledger composer / Blockchain
                            <br/><br/>

                            <b>Role:</b>Cloud Software Engineer responsible for building foundation micro-services for the new cloud-based (multi-tenant) cognitive E&P environment called DELFI.
                            <br/><br/>

                            <b>Responsibilities:</b>
                            <ul style='text-align:left;'>
                            <li> Implemented core APIs for DELFI Datalake, which enabled ingestion and discovery of large, fluid and unstructured data into the datalake.</li>
                            <li>Designed and built micro-services for data indexing in an efficient manner which provided fast data access to end users.</li>
                            <li>Implemented record level authorization which provided fine-grained control for sensitive data.</li>
                            <li>Implemented search capabilities such as Geo Spacial, Geo Location, Bounding Box etc, which drastically increased the user experience.</li>
                            <li>Leveraged Hyperledger composer (Blockchain) framework for implementing POC for data trading platform.</li>
                            </ul>

							<ul class="list-inline item-details">

								<li>Start Date: <strong>July 2017 </strong>
								</li>
								<li>Service: <strong>Cloud & Data Infrastructure
										 </strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Portfolio Modals -->
	<div class="portfolio-modal modal fade" id="raModal" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>Research Assistant</h2>
							<h4>
								<a href="https://www.cylab.cmu.edu/">Cylab, Carnegie Mellon
									University</a>
							</h4>
							<hr class="star-primary">
							<img src="resources/img/cylab.png"
								class="img-responsive img-centered" alt="">
							<p>Built a web browser extension to gather required data for
								consumer behaviour analysis based on ads and to route it to the
								server.</p>
							<p>Created a Centralized Distributed Rule Engine using
								customized rules, to analyse collected data useful for instant
								trend prediction.</p>
							<ul class="list-inline item-details">

								<li>Start Date: <strong>November 2016 </strong>
								<li>End Date: <strong>May 2017 </strong>
								</li>
								<li>Service: <strong>Web Development & Data
										Analytics </strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Portfolio Modals -->
	<div class="portfolio-modal modal fade" id="tajModal" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>Teaching Assistant</h2>
							<h4>Intermediate Java-II</h4>
							<h4>
								<a
									href="http://www.heinz.cmu.edu/academic-resources/course-results/course-details/index.aspx?cid=302">Carnegie
									Mellon University</a>
							</h4>
							<hr class="star-primary">
							<p>The focus of this mini is on problem solving using the
								Java programming language. We will study such topics as Java's
								object model, inheritance, polymorphism, error handling, event
								handling, the Java I/O system, graphical user interfaces, the
								JDK2 collection classes, multiple threads of control,
								interfaces, inner classes, JDBC, network programming using
								sockets and RMI.</p>
							<p>Conduct weekly review sessions to help students in
								grasping concepts.</p>
							<p>Evaluate assignments and homework with detailed feedback
								and uniform grading.</p>
							<ul class="list-inline item-details">

								<li>Start Date: <strong>August 2016 </strong>
								</li>
								<li>Service: <strong>Web Development & Object
										Oriented Programming</strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Portfolio Modals -->
	<div class="portfolio-modal modal fade" id="capModal" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>Kent Parker Media Platform</h2>
							<h4>Capstone</h4>
							<h4>
								<a
									href="http://www.heinz.cmu.edu/academic-resources/course-results/course-details/index.aspx?cid=302">Carnegie
									Mellon University</a>
							</h4>
							<hr class="star-primary">
							<p>Kent Parker is a media tool that allows journalists to
								search for stories based on their categories. It also allows
								companies and organizations and individuals with newsworthy news
								to share.</p>

							<p>Features developed:</p>
							<ul style="text-align: left;">
								<li>It allows newsmakers and media outlets to connect.</li>

								<li>The right journalists connect with the right
									newsmakers.</li>

								<li>It is a social media platform specifically for
									newsworthy content.</li>

								<li>Ethics are the foundation of our platform.</li>

								<li>Newsmakers and media outlets and journalists can give
									feedback to each other on a five-point scale.</li>

								<li>New organizations are able to build a media plan, which
									encompasses all news outlets from community papers to top media
									outlets.</li>

								<li>Members are able to maintain connections with
									journalists regardless of a change of employment or career.</li>

								<li>The fray that exists on other platforms does not live
									on Kent Parker.</li>

								<li>Kent Parker allows a newsmaker to track and document
									their media archives.</li>

								<li>Kent Parker increases transparency by allowing all
									visitors to the website, members and non-members to view the
									initial pitches and the resulting news stories.</li>
							</ul>
							<ul class="list-inline item-details">

								<li>Start Date: <strong>January 2017 </strong>
								</li>
								<li>Service: <strong>Design platform, Web
										Development, Object Oriented Programming</strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="portfolio-modal modal fade" id="tadModal" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>Teaching Assistant</h2>
							<h4>Distributed Systems</h4>
							<h4>
								<a
									href="http://www.heinz.cmu.edu/academic-resources/course-results/course-details/index.aspx?cid=295">Carnegie
									Mellon University</a>
							</h4>
							<hr class="star-primary">
							<p>This course has three major objectives. First, it is
								designed to introduce students to the principles underlying
								distributed computing and the design of distributed systems.
								Second, it aims to provide students with the opportunity to
								exercise these principles in the context of real applications by
								having the students use technologies such as XML, SOAP, Web
								services, and JEE-based application servers. Finally, it seeks
								to endow students with the capacity to analyze, design, evaluate
								and recommend distributed computing solutions skills in response
								to business problems.</p>
							<ul>
								<li>Distributed computing architectures: P2P, client server
								</li>
								<li>Inter-process communication</li>
								<li>Distributed objects and remote invocation</li>
								<li>Naming and Name services</li>
								<li>Time and Global State Management</li>
								<li>Transactions and Concurrency control</li>
								<li>Distributed Transactions</li>
							</ul>
							<p>Conduct weekly lab sessions to help students in completing
								projects and assignments.</p>
							<p>Conduct weekly review sessions to help students in
								grasping concepts.</p>
							<p>Evaluate assignments and homework with detailed feedback
								and uniform grading.</p>
							<ul class="list-inline item-details">

								<li>Start Date: <strong>January 2016 </strong>
								</li>
								<li>Service: <strong>Web Development & Distributed
										Systems</strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="portfolio-modal modal fade" id="ddcModal" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>Distributed Data center</h2>
							<h4>Cloud computing</h4>
							<h4>
								<img src="resources/img/kv_storage.png"
									class="img-responsive img-centered" alt="">
									<img src="resources/img/Project1.jpg"
									class="img-responsive img-centered" alt="">
							</h4>
							<hr class="star-primary">
							<p>Storing, processing and analyzing this data is an enormous
								challenge and has long surpassed the storage, memory and
								computing capabilities of a single machine. We require
								distributed, scalable data storage systems to handle this
								big-data challenge. While there are many types of distributed
								databases and storage systems, in this project we will focus on
								distributed key-value store, a commonly adopted solution for
								scaling up data storage. These key-value stores are considered
								to be a type of NoSQL storage system, as they do not have full
								relational capabilities of systems such as MySQL, which you
								explored in a previous project.</p>
							<ul style="text-align: left;">

								<li>Describe the motivation and design space for
									distributed key-value stores.</li>
								<li>Compare and contrast the advantages and disadvantages
									of using replication in distributed key-value stores.</li>
								<li>Extend a distributed key-value store with replication
									schemes.</li>
								<li>Discuss the various levels of consistency that can
									employed in a distributed data store.</li>
								<li>Implement and evaluate strong consistency and eventual
									consistency models for a distributed key-value store.</li>
								<li>Compare the various trade-offs that exist in using
									different levels of consistency.</li>
								<li>Explore the advantages and disadvantages of replicating
									over different geographical locations.</li>
								<li>Distributed computing architectures: P2P, client server</li>

							</ul>

							<ul class="list-inline item-details">

								<li>Start Date: <strong>August 2016 </strong>
								<li>End Date: <strong>October 2016 </strong>
								</li>
								<li>Service: <strong>Multi-Threading, Consistency
										& Distributed Systems</strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="portfolio-modal modal fade" id="pittModal" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>PittCabs: Real-time transit and Dynamic pricing</h2>
							<h4>Cloud computing</h4>
							<h4>
								<img src="resources/img/Task1.jpg"
									class="img-responsive img-centered" alt="">
									<img src="resources/img/kafka.jpg"
									class="img-responsive img-centered" alt="">
							</h4>
							<hr class="star-primary">
							<p>Recently there has been an increased interest in real-time
								data. Sources include sensor data (primarily due to the
								explosion of Internet of Things (IoT) devices), social network
								interactions and business critical data generated in real time.
								These events need to be processed with extremely low latency, in
								the order of seconds, failing which the company loses its
								competitive edge in the market.</p>
							<p>This is where stream processing systems come in, having
								specifically been designed to process billions of events
								everyday with low latency. Apache Kafka and Apache Samza are two
								such systems which enable processing a stream of data in
								real-time (with low latency).</p>
							<ul style="text-align: left;">
								<li>Scenarios where stream processing is the preferred
									model.</li>
								<li>Fault tolerance and high performance mechanisms
									employed in streaming frameworks.</li>
								<li>Kafka and Samza integrate together to achieve
									fault-tolerance.</li>
								<li>Generated a stream of data using Kafka and made it
									available for a Samza consumer.</li>
								<li>Designed and implemented a solution to join and process
									multiple streams of GPS data using the Samza API to enabled a
									driver matching service like Uber.</li>
							</ul>

							<ul class="list-inline item-details">

								<li>Start Date: <strong>November 2016 </strong>
								<li>End Date: <strong>December 2016 </strong>
								</li>
								<li>Service: <strong>Stream Processing &
										Distributed Systems</strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="portfolio-modal modal fade" id="docModal" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>Docker containerized web service</h2>
							<h4>Cloud computing</h4>
							<h4>
								<img src="resources/img/docker.png"
									class="img-responsive img-centered" alt="">
							</h4>
							<hr class="star-primary">
							<p>Recently there has been an increased interest in real-time
								data. Sources include sensor data (primarily due to the
								explosion of Internet of Things (IoT) devices), social network
								interactions and business critical data generated in real time.
								These events need to be processed with extremely low latency, in
								the order of seconds, failing which the company loses its
								competitive edge in the market.</p>
							<p>This is where stream processing systems come in, having
								specifically been designed to process billions of events
								everyday with low latency. Apache Kafka and Apache Samza are two
								such systems which enable processing a stream of data in
								real-time (with low latency).</p>
							<ul style="text-align: left;">
								<li>Compared containers with VMs with respect
									to design, performance, security, deployment, and portability.</li>
								<li>Containers communicating with each other and
									with the host machine.</li>
								<li>Created, implemented, and deployed containerized
									applications on a cloud service.</li>
								<li>Manageed automatic deployment of containers using Amazon
									ECS, and these techniques can be used to architect
									a web application which can automatically scale based on load.</li>
							</ul>

							<ul class="list-inline item-details">

								<li>Start Date: <strong>September 2016 </strong>
									<li>End Date: <strong>October 2016 </strong>
								</li>
								<li>Service: <strong>Docker, Container, Scaling &
										Distributed Systems</strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="portfolio-modal modal fade" id="samModal"
										tabindex="-1" role="dialog" aria-hidden="true">
										<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>Lead Engineer</h2>
							<h4>
								<a
																	href="http://www.samsung.com/in/aboutsamsung/samsungelectronics/india/rnd/">Samsung
									R&D Institute</a>
							</h4>
							<hr class="star-primary">
							<p>Implemented web services to send personalized ads as quick
								access links to Samsung mobile browsers for better user
								engagement.</p>
							<p>Refactored the design of Quick Access APIs to improve its
								throughput from Samsung browser & to enable better tracking of
								users.</p>

							<ul class="list-inline item-details">

								<li>Start Date: <strong>April 2016 </strong>
								</li>
								<li>End Date: <strong>May 2016 </strong>
								</li>
								<li>Service: <strong>Web Development, Distributed
										Systems & Mobile</strong>
								</li>
								<li>Skills: <strong>Java Spring and Hibernate,
										NodeJS, MySQL, Mongo DB, Python, Git, Gerrit, Jenkins</strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
																data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="portfolio-modal modal fade" id="hpeModal" tabindex="-1"
										role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>Software Engineer II</h2>
							<h4>
								<a href="https://www.hpe.com/us/en/home.html">Hewlett-Packard
									Enterprise R&D labs</a>
							</h4>
							<hr class="star-primary">
							<p>Implemented platform APIs for HP Oneview, which enabled
								clients and partners to control the configuration of blade
								servers.</p>
							<p>Devised Linux and Python scripts to ensure replication of
								data over the nodes which helped in making the system highly
								available.</p>

							<ul class="list-inline item-details">

								<li>Start Date: <strong>May 2015 </strong>
								</li>
								<li>End Date: <strong>March 2016 </strong>
								</li>
								<li>Service: <strong>Web Development, Distributed
										Systems & Data Center</strong>
								</li>
								<li>Skills: <strong>Java Spring and Hibernate,
										PostgreSQL, Python, Shell scripts, JavaScript, HTML, Kafka</strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
																data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="portfolio-modal modal fade" id="miModal" tabindex="-1"
										role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>Engineer-II, MFG-IT</h2>
							<h4>
								<a href="https://www.maximintegrated.com">Maxim Integrated</a>
							</h4>
							<hr class="star-primary">
							<p>Introduced Agile framework and collaborated with
								stakeholders as the Scrum Master, reducing the project delivery
								time by 10%.</p>
							<p>Implemented a Factory Automation Suite comprising of a
								cloud based master engine controlling & managing slave
								applications.</p>
							<p>Devised custom ETL scripts for the cleansing and
								validation of the data, which reduced the loading errors by 13%.
							</p>

							<ul class="list-inline item-details">

								<li>Start Date: <strong>June 2011 </strong>
								</li>
								<li>End Date: <strong>April 2015 </strong>
								</li>
								<li>Service: <strong>Web Development & Distributed
										Systems</strong>
								</li>
								<li>Skills: <strong>Java, REST, Oracle, Python,
										Shell scripts, JavaScript, HTML, ActiveMQ, SVN</strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
																data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<!-- Plugin JavaScript -->
	<script
										src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

	<!-- Contact Form JavaScript -->
	<script src="resources/js/jqBootstrapValidation.js"></script>
	<script src="resources/js/contact_me.js"></script>

	<!-- Theme JavaScript -->
	<script src="resources/js/freelancer.min.js"></script>


								</body>

</html>
