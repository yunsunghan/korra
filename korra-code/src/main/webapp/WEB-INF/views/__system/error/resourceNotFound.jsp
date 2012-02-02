<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:directive.page contentType="text/html;charset=UTF-8" isErrorPage="true"/>
<jsp:directive.include file="/WEB-INF/views/__system/taglibs.jsp"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><spring:message code="app.title" text="Tbizpoint Workplace"/></title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<spring:url value="/resources/styles/${SKIN}/backoffice/backoffice.css" var="backoffice_css" />
	<link rel="stylesheet" type="text/css" href="${backoffice_css}" media="screen, print" />
	<spring:url value="/resources/scripts/${SKIN}/backoffice/backoffice.js" var="backoffice_js" />
	<script type="text/javascript" src="${backoffice_js}"></script>
</head>
<body>
<div id="wrap">
	<div id="errorcontainer">
		<div id="errorcon">
			<div class="noconnect">
				<div class="noconnectcon">
					<p class="tit">Resource Not Found<br />
					요청하신 페이지를 찾을수 없습니다. 다시 확인해 주십시요. </p>
					<p class="desc01"><a href ="<spring:url value="/userlogout"/>">메인페이지 </a>로 이동하기</p>
					<p class="desc02">지속적인 문제가 발생하면, 고객센터 : <strong>1588 – 0000</strong><br />또는 E-mail : <span><a href="mailto:help@doamin.com">mailto:help@domain.com</a></span> 로 연락 주시기 바랍니다.</p>
				</div>
			</div>
		</div>
	</div>
</div> 
</body>		
</html>