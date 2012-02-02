<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:directive.page contentType="text/html;charset=UTF-8" />
<jsp:directive.include file="/WEB-INF/views/__system/taglibs.jsp"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><spring:message code="application_name"/></title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
	<link rel="SHORTCUT ICON" href="${REQUEST_SERVER_PATH}/${SKIN}/favicon.ico" />	
	<link rel="stylesheet" type="text/css" href="<spring:url value="/styles/${SKIN}/front/front.css"/>" media="screen, print" />
	<script type="text/javascript" src="<spring:url value="/scripts/${SKIN}/front/front.js"/>"></script>	
	<script type="text/javascript" src="<spring:url value="/scripts/component/common.js"/>"></script>	
	<c:set var="userLocale">
		<c:out value="${pageContext.response.locale}" default="en" />
	</c:set>
	<decorator:head/>
</head>
<body>
<div id="wrap">
<!-- ------------------------- header start ------------------------- -->
<div id="head">
	<h1><img src="<spring:url value="/resources"/>/images/domain/domain_logo.png" alt="Spring Roo Addon Max" /></h1>
	<div>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
	</div>
 		<div class="topmenu">
			<div class="front">
				<ul class="onedepth" id="ddtabs1">
<!-- 				 class="fir on" -->
					<li><a href="<spring:url value="/front/index"/>">Home</a></li>
					<li><a href="<spring:url value="/front/about"/>">What is KorraCode?</a></li>
					<li><a href="<spring:url value="/front/pricingnsignup"/>">Pricing &amp SignUp</a></li>
					<li><a href="<spring:url value="/front/help"/>">Help</a></li>
				</ul>
			</div>
		</div>
</div>
<!-- ------------------------- header end   ------------------------- -->
<div id="container" style="height: 500px;">
	<!-- 내용 시작 -->
	<decorator:body/>
	<!-- 내용 끝 -->
</div>
<!-- ------------------------- footer start ------------------------- -->
<div id="footer">
<table>
	<tr>
		<td>About</td>
		<td>Community</td>
		<td>Learn</td>
		<td>More</td>
		<td>KorraCode</td>
	</tr>
	<tr>
		<td>
			<p>Features</p>
			<p>Pricing &amp SignUp</p>
			<p>Insurance and Benefits</p>
		</td>
		<td>
			<p>Blog</p>
			<p>Testimonials</p>
			<p>Contributing Guests</p>
		</td>
		<td>
			<p>Tour</p>
			<p>Tutorials</p>
			<p>Support</p>
		</td>
		<td>
			<p>Affiliate Program</p>
			<p>Legal</p>
			<p>Our Team</p>
		</td>
		<td>
			<span><spring:message code="application_copylight"/></span>
		</td>
	</tr>
</table>
</div>
<!-- ------------------------- footer end   ------------------------- -->
</div>
</body>
</html>
