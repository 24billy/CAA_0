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

<script type="text/javascript" src="resources/js/jquery.dataTables.min.js"></script>

<!-- Bootbox -->
<script src="resources/js/bootbox.min.js"></script>
        
<style>
    .highlight_kpi {

    }   
</style>
</head>
<body>
	<div id="container">
		<div class="hide1" id="nextPage">Q2</div>
		<div id="materialDiv">
			<div class="wrapper"><p class="text" style="font-size: 40px;">+</p></div>
		</div>
	</div>
</body>
<script>
$(document).ready(function(){
    $('body').keydown(function(event){
   	    if( event.which == 27 ) { // ESC
   	        console.log("跳出測驗");
   	    	window.close();
   	    }
    });
    
    var next = $('#nextPage').text();
    
//     console.log("next = " + next);
    
    var href = "test2.do?next=" + next;
   
    // 1.5秒後 自動跳下一頁
    setTimeout('document.location.href="' + href + '"', 5000);
});
</script>
</html>