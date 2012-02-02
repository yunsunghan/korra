<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:directive.page contentType="text/html;charset=UTF-8" />
<jsp:directive.include file="/WEB-INF/views/__system/taglibs.jsp"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><spring:message code="application_name"/></title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
	<link rel="SHORTCUT ICON" href="${REQUEST_SERVER_PATH}/${SKIN}/favicon.ico" />	
	<link rel="stylesheet" type="text/css" href="<spring:url value="/styles/${SKIN}/backoffice/backoffice.css"/>" media="screen, print" />
	<script type="text/javascript" src="<spring:url value="/scripts/${SKIN}/backoffice/backoffice.js"/>"></script>
	<script type="text/javascript" src="<spring:url value="/scripts/component/common.js"/>"></script>
	<c:set var="userLocale">
		<c:out value="${pageContext.response.locale}" default="en" />
	</c:set>	
	<script type="text/javascript">
		var djConfig="${userLocale}";
		var CTX='<spring:url value="/resources/" />';
		var att = new Object;	
		var p_target;
		function attachmentOpen(_target,_url){
			p_target = _target;
			att = window.document.getElementById('_'+_target);
			var targetUrl = _url;
			var winName = "window_"+_target;
			var winWidth = 370;
			var winHeight = 230;
			var winScroll = "No";
			var winResize = "No";
			var win = NewWindowOpen(targetUrl,winName,winWidth,winHeight,winScroll,winResize);		
		}
		function downloadOpen(_target,_url){
			p_target = _target;
			att = window.document.getElementById('_'+_target);
			var targetUrl = _url;
			var winName = "window_"+_target;
			var winWidth = 600;
			var winHeight = 335;
			var winScroll = "No";
			var winResize = "No";
			var win = NewWindowOpen(targetUrl,winName,winWidth,winHeight,winScroll,winResize);		
		}	
		function addFile(_value,_key) {
			att.add(new Option(_value,_key, true, true));
		}
		function addImage(_value) {
			sHTML = "<span><img src='"+_value+"'/></span>";
			oEditors.getById["_context"].exec("PASTE_HTML", [sHTML]);
		}
		function addAvi(_value) {
			sHTML = "<span><img src='"+_value+"'/></span>";
			oEditors.getById["_context"].exec("PASTE_HTML", [sHTML]);
		}
		function addMp3(_value) {
			sHTML = "<span><img src='"+_value+"'/></span>";
			oEditors.getById["_context"].exec("PASTE_HTML", [sHTML]);
		}
		function checkFile(_id) {
			checkFileProcess(window.document.getElementById(_id).options);
		}
		function checkFileProcess(attOptions){
			for(i=0; i < attOptions.length; i++){
				attOptions[i].selected = true;
			}
		}
		function delFile(_target) {
			att = window.document.getElementById('_'+_target);
			for(var i=0; i < att.options.length; i++){
				if(att.options[i].selected == true)	att.remove(att.selectedIndex);
			}
		}		
	</script>
	<decorator:head/>
</head>
<body>
<div id="wrap">
<!-- ------------------------- header start ------------------------- -->
<spring:url value="/static/j_spring_security_logout?spring-security-redirect=/backoffice_login" var="logout"/>
<div id="head">
	<h1><img src="<spring:url value="/resources"/>/images/domain/domain_logo.png" alt="Spring Roo Addon Max" /></h1>
	<div class="toputil">
		<sec:authorize access="hasRole('ROLE_ADMIN')">
		<p>${pageContext.request.userPrincipal.name}님 로그인 하셨습니다.</p>
		</sec:authorize>
		<ul>
			<li class="fir"><a href="${logout}">로그아웃</a></li>
		</ul>
	</div>

 		<div class="topmenu">
			<div class="front">
				<ul class="onedepth" id="ddtabs1">
					<jsp:directive.include file="/WEB-INF/layouts/backoffice_menu.jsp"/>
				</ul>
			</div>
		</div>
</div>
<!-- ------------------------- header end   ------------------------- -->
<div id="container">
	<!-- 내용 시작 -->
	<decorator:body/>
	<!-- 내용 끝 -->
</div>
<!-- ------------------------- footer start ------------------------- -->
<div id="footer">
	<span><spring:message code="application_copylight"/></span>
</div>
<!-- ------------------------- footer end   ------------------------- -->
</div>
</body>
</html>