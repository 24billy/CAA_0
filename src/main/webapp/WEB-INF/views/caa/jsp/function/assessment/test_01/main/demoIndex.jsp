<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>測驗首頁</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">

<link href="resources/css/myStyles.css" rel="stylesheet">

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

<script type="text/javascript"
	src="resources/js/jquery.dataTables.min.js"></script>

<!-- Bootbox -->
<script src="resources/js/bootbox.min.js"></script>

<style>
.highlight_kpi {
	
}
</style>
</head>

<body>
	<div id="container">

		<div class="hide1" id="nextPage">showTest02Process.do?next=test_01/demo/demoPage01</div>
		<div id="titleDiv">
			<div class="wrapper">
				<p class="text">操作示範</p>
			</div>
		</div>
		<div id="btnDiv">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-3">
					<div class="blue_bg_btn">
						開始
						<p class="red_border">✔</p>
					</div>
				</div>

				<div class="col-md-3">
					<div class="blue_bg_btn">
						略過
						<p class="red_border">✘</p>
					</div>
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>
	</div>

</body>

<script>
	$(document).ready(
			function() {
				// 取出 sessionStorage
				var reactionTimeList = sessionStorage
						.getItem('ReactionTimeList');
				console.log("ReactionTimeList : " + reactionTimeList);

				$('body').keydown(
						function(event) {

							var response = event.which;
							var next = $('#nextPage').text();

							var params = {
								"response" : response,
								"next" : next
							};

							if (event.which == 56) { // 數字8 換下一頁
								var durationTime = 1500; // 凝視點顯示時間 (毫秒)

								document.location.href = next
										+ "&durationTime=" + durationTime;
							}

							if( event.which == 50 ) { // 數字2 換下一頁
					   	    	console.log("按下2了");
					   	    	document.location.href="showTest02Process.do?next=test_01/practice/practice";
					   	    }
							
							if (event.which == 27) { // ESC
								console.log("跳出測驗");
								window.close();
							}
						});
			});
</script>
</html>