<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<script>
function goTimeOut() {
	var message = '${message}';
	alert(message);
	window.location.href = 'user/showLogin.do';
}
goTimeOut();
</script>
