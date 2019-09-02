<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

	<head>
		<!-- some changes acc to api req to be done -->
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
										<script src="resources/js/controllers/listCtrl.js"></script>

										<!-- Styles-->
										<link rel="stylesheet" href="resources/css/styles.css">

											<!--ending here-->
											<!---Script js-->
										  <script src="./resources/script.js"></script>
										  <script type = "text/javascript" 
										  src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js">
									   </script>
									      <script src = "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>
										</head>

										<body id="page-top">
											<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

												<!-- <a class="navbar-brand mr-1" href="index.html">Store Project</a> -->
												<img class="img-responsive" src="resources/images/pansari-logo.png" style="width:300px;height:100px;"
													align="left">

													<!-- <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
														<i class="fas fa-bars"></i>
													</button> -->


													<div id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-custom">
														<div class="container">

															<!-- Brand and toggle get grouped for better mobile display -->
															<div class="navbar-header page-scroll">
																<a class="navbar-brand" style="margin-left:25px" href="#page-top"><h1>Pansari Promoters</h1></a>
															</div>

														</div>
														<!-- /.container-fluid -->
													</div>

													<!-- Navbar Search -->
													<!-- <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
													<div class="input-group">
													<input type="text" class="form-control" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
													<div class="input-group-append">
													<button class="btn btn-primary" type="button">
													<i class="fas fa-search"></i>
												</button>
											</div>
										</div>
									</form> -->

								</nav>
								<div id="wrapper">

									<!-- Sidebar -->
									<ul class="sidebar navbar-nav">
										<li class="nav-item active">
											<a class="nav-link" href="#/user">
												<i class="fas fa-fw fa-table"></i>
												<span>User</span></a>
											</li>
											<li class="nav-item active">
												<a class="nav-link" href="#/item">
													<i class="fas fa-fw fa-table"></i>
													<span>Item</span></a>
												</li>
												<li class="nav-item active">
													<a class="nav-link" href="#/store">
														<i class="fas fa-fw fa-table"></i>
														<span>Store</span></a>
													</li>
													<li class="nav-item active">
														<a class="nav-link" href="#/locationreading">
															<i class="fas fa-fw fa-table"></i>
															<span>Location Reading</span></a>
														</li>
												</ul>

												<div class="my-view"></div>
												<footer class="sticky-footer">
													<div class="container my-auto">
														<div class="copyright text-center my-auto">
															<span>Copyright © 2019</span>
														</div>
													</div>
												</footer>

											</div>
											<!-- /# wrapper -->
											
											<!-- Scroll to Top Button-->
											<a class="scroll-to-top rounded" href="#page-top">
												<i class="fas fa-angle-up"></i>
											</a>

											<!-- Logout Modal-->
											<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
												aria-hidden="true">
												<div class="modal-dialog" role="document">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
															<button class="close" type="button" data-dismiss="modal" aria-label="Close">
																<span aria-hidden="true">×</span>
															</button>
														</div>
														<div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
														<div class="modal-footer">
															<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
															<a class="btn btn-primary" href="login.html">Logout</a>
														</div>
													</div>
												</div>
											</div>

											<!---Delete Modal-->
											<div class="modal" id="confirmModal" style="display: none; z-index: 1050;">
													<div class="modal-dialog">
													  <div class="modal-content">
														<div class="modal-body" id="confirmMessage">
														</div>
														<div class="modal-footer">
														  <button type="button" class="btn btn-default" id="confirmOk">Ok</button>
															  <button type="button" class="btn btn-default" id="confirmCancel">Cancel</button>
															</div>
													  </div>
													</div>
												  </div>

												  <div id="spinnerContainer" class="hidden spinner center">
													<div class="lds-roller">
														<div></div>
														<div></div>
														<div></div>
														<div></div>
														<div></div>
														<div></div>
														<div></div>
														<div></div>
													</div>
												</div>
											<!-- Bootstrap core JavaScript-->
											<script src="resources/vendor/jquery/jquery.min.js"></script>
											<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

											<!-- Core plugin JavaScript-->
											<script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

											<!-- Page level plugin JavaScript-->
											<script src="resources/vendor/datatables/jquery.dataTables.js"></script>
											<script src="resources/vendor/datatables/dataTables.bootstrap4.js"></script>

											<!-- Custom scripts for all pages-->
											<script src="resources/js/sb-admin.min.js"></script>

											<!-- Demo scripts for this page-->
											<script src="resources/js/demo/datatables-demo.js"></script>
												  
										</body>

									</html>
