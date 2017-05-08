<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>CAA</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">    
        
<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/css/heroic-features.css" rel="stylesheet">

<link href="resources/css/jquery.dataTables.min.css" rel="stylesheet">

<!-- jQuery -->
<script src="resources/js/jquery.js"></script>

<!-- jQuery -->
<script src="resources/js/jquery-ui.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="resources/js/bootstrap.min.js"></script>

<script type="text/javascript" src="resources/js/jquery.dataTables.min.js"></script>

<!-- Bootbox -->
<script src="resources/js/bootbox.min.js"></script>
        
    <style>
        .highlight_kpi {

        }   
    </style>
</head>

<body>
	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
<!-- 				<a class="navbar-brand" href="/index">認知測驗組</a> -->
				<a class="navbar-brand" href="javascript:void(0);" onclick="openmenu('console.do');">認知測驗組</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="javascript:void(0);" onclick="openmenu('showExaminerManagementView.do');">訪員管理</a></li>
					<li><a href="javascript:void(0);" onclick="openmenu('showCompanyManagementView.do');">單位管理</a></li>
					<li><a href="javascript:void(0);" onclick="openmenu('showSubjectManagementView.do');">資料管理</a></li>
				</ul>

				<a class="btn btn-default pull-right" href="javascript:window.close();">登出</a>
<!-- 				<a class="btn btn-default pull-right" href="javascript:void(0);" onclick="openmenu('exLogout.do');">登出</a> -->
				

			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Page Content -->
	<div class="container" id="reflashDiv">

		<!-- Jumbotron Header -->
		<header class="jumbotron">
			<h3>歡迎光臨!</h3>
			<p>歡迎進入本測驗後台管理。提供單位管理功能、訪員管理功能以及受測者資料管理功能。</p>
			</p>
		</header>

		<hr>

		<!-- Title -->
		<div class="row">
			<div class="col-lg-12">
				<h3>Menu</h3>
			</div>
		</div>
		<!-- /.row -->

		<!-- Page Features -->
		<div class="row text-center">

			<div class="col-md-4 col-sm-6 hero-feature">
				<div class="thumbnail">
					<!--
                    <img src="http://placehold.it/800x500" alt="">
-->
					<div class="caption">
						<h3>訪員管理</h3>
						<p>新增、編輯、刪除 主試者</p>
						<p>
							<a href="javascript:void(0);" onclick="openmenu('showExaminerManagementView.do');" class="btn btn-primary">進入!</a> <a href="#"
								class="btn btn-default">More Info</a>
						</p>
					</div>
				</div>
			</div>

			<div class="col-md-4 col-sm-6 hero-feature">
				<div class="thumbnail">
					<!--
                    <img src="http://placehold.it/800x500" alt="">
-->
					<div class="caption">
						<h3>單位管理</h3>
						<p>新增、刪除 單位</p>
						<p>
							<a href="javascript:void(0);" onclick="openmenu('showCompanyManagementView.do');" class="btn btn-primary">進入!</a> <a href="#"
								class="btn btn-default">More Info</a>
						</p>
					</div>
				</div>
			</div>

			<div class="col-md-4 col-sm-6 hero-feature">
				<div class="thumbnail">
					<!--
                    <img src="http://placehold.it/800x500" alt="">
-->
					<div class="caption">
						<h3>資料管理</h3>
						<p>新增、編輯、刪除 受試者 & 進行測驗、觀看結果</p>
						<p>
							<a href="javascript:void(0);" onclick="openmenu('showSubjectManagementView.do');" class="btn btn-primary">進入!</a> <a href="#"
								class="btn btn-default">More Info</a>
						</p>
					</div>
				</div>
			</div>

		</div>
		<!-- /.row -->

		<hr>

	</div>
	<!-- /.container -->
	
	<!-- Footer -->
	<footer>
		<div class="row">
			<div class="col-lg-12">
				<p>Copyright &copy; Your Website 2014</p>
			</div>
		</div>
	</footer>
	
</body>

<script type="text/javascript">
function openmenu(menu) {
	
	$.ajax({
		type : "POST",
		url : menu,
		dataType : 'html',
		success : function(data) {

			$('#reflashDiv').empty().html(data);
			
		},
		error : function(dataMp) {
		}
	});

}

</script>
</html>

