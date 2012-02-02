<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:directive.page contentType="text/html;charset=UTF-8" />
<jsp:directive.include file="/WEB-INF/views/__system/taglibs.jsp"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>popup</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
	<link rel="stylesheet" type="text/css" href="<spring:url value="/styles/${SKIN}/backoffice/backoffice.css"/>" media="screen, print" />
	<script type="text/javascript" src="<spring:url value="/scripts/${SKIN}/backoffice/backoffice.js"/>"></script>
	<decorator:head/>
</head>
<body id="popup">
	<decorator:body/>
</body>
</html>
