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

		<div class="hide1" id="nextPage">showTest02Process.do?next=test_01/demo/demoPage04</div>
		<div class="text-center">
			<h3>接著，電腦螢幕上會呈現一個圖形</h3>
			<h3>注意：<label style="color: red;">圖形呈現的時間長短不一定，請在圖形消失前正確作答</lable></h3>
		</div>
		<div class="text-center" style="height: 80%; weight: 80%;">
			<img src="resources/images/test01/demo_pic/06.JPG" style="height:90%;">
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

								document.location.href = next + "&durationTime="
										+ durationTime;
							}

							if (event.which == 27) { // ESC
								console.log("跳出測驗");
								window.close();
							}
						});
			});
</script>
</html>