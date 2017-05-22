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

		<div class="hide1" id="nextPage">showTest02Process.do?next=test_01/demo/demoPage15</div>
		<div class="text-center">
			<h3>示範2</h3>
		</div>
		<div class="text-center" style="height: 80%; weight: 80%;">
			<img src="resources/images/test01/demo_pic/17.JPG" style="height:90%;">
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
							if (event.which == 27) { // ESC
								console.log("跳出測驗");
								window.close();
							}
						});
				
				// 2秒後 自動跳下一頁 題目的顯示秒數只在題目頁設定
				setTimeout(function() {
					var next = $('#nextPage').text();
					document.location.href = next;
				}, 750);
			});
</script>
</html>