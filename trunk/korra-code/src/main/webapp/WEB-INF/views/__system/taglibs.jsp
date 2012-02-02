<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="__port" value=":${pageContext.request.serverPort}" />
<c:set var="SKIN" value="blue" />

<spring:url var="BACK_IMAGE_PATH" value="/resources/images/${SKIN}/backoffice" />
<spring:url var="FRONT_IMAGE_PATH" value="/resources/images/${SKIN}/front" />
<spring:url var="REQUEST_SERVER_PATH" value="${fn:indexOf('HTTPS', pageContext.request.protocol) gt -1 ? 'https' : 'http'}://${pageContext.request.serverName}${fn:indexOf('80', pageContext.request.serverPort) gt -1 ? '' : __port}${pageContext.request.contextPath}" />
<c:set var="BACK_CTX" value="${REQUEST_SERVER_PATH}/backoffice" />
<c:set var="FRONT_CTX" value="${REQUEST_SERVER_PATH}/front" />