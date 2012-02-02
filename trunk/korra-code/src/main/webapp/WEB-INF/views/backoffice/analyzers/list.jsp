<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:directive.page contentType="text/html;charset=UTF-8"></jsp:directive.page>
<jsp:directive.include file="/WEB-INF/views/__system/taglibs.jsp"/>
<jsp:directive.include file="/WEB-INF/views/backoffice/__header.jsp"/>
        <script type="text/javascript" src="../swf/swfobject.js"></script>
        <script type="text/javascript">
            var swfVersionStr = "10.2.0";
            var xiSwfUrlStr = "../swf/playerProductInstall.swf";
            var flashvars = {};
            var params = {};
            params.quality = "high";
            params.bgcolor = "#ffffff";
            params.allowscriptaccess = "sameDomain";
            params.allowfullscreen = "true";
            var attributes = {};
            attributes.id = "TimeLog";
            attributes.name = "TimeLog";
            attributes.align = "middle";
            swfobject.embedSWF(
                "../swf/TimeLog.swf", "flashContent", 
                "100%", "300", 
                swfVersionStr, xiSwfUrlStr, 
                flashvars, params, attributes);
            swfobject.createCSS("#flashContent", "display:block;text-align:left;");
        </script>
</head>
<!--WARNING: This file is Not maintained by ROO! IT WON'T BE OVERWRITTEN unless you specify :)-->

<!-- - - - - - - - - - - - - List Start... - - - - - - - - - - - - -->


<body>
<spring:url value="${BACK_CTX}/analyzers/excel" var="excel_url"></spring:url>
<div class="h2box">
<h2>Entity Management</h2>
</div>
<h3>Entity List</h3>
<div class="btnarea_top">
<div class="btn_rgt">
<span class="button whitebtn"><a href="${excel_url}">Excel Download</a></span>
</div>
</div>
<c:if test="${not empty result}">
<table class="tbl_list" id="tbl_list" summary="This is Entity List">
<caption>Entity List</caption>
<col width="10%">
<col width="10%">
<col width="10%">
<col width="10%">
<col width="10%">
<col width="10%">
<col width="-10%">
<thead>
<tr>
<th class="first">Id</th>

<th>acceptLanguage</th>

<th>user_agent</th>

<th>writeDate</th>

<th>codeCreateId</th>

<th>Management</th>
</tr>
</thead>
<tbody>
<spring:url value="${BACK_CTX}/analyzers/show" var="show_url"></spring:url>
<spring:url value="/resources" var="img"></spring:url>
<c:forEach items="${result.rawLogList}" var="rawLog">
	<tr>
		<td>${fn:substring(rawLog.id, 0, 20)}</td>
		<td>${fn:substring(rawLog.acceptLanguage, 0, 20)}</td>
		<td>${fn:substring(rawLog.userAgent, 0, 20)}</td>
		<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" type="DATE" value="${rawLog.writeDate}"/></td>
		<td>${fn:substring(rawLog.codeCreatorId, 0, 20)}</td>
		<td><a href="${show_url}/${rawLog.id}">[View]</a></td>
	</tr>
</c:forEach>
<c:if test="${empty result}">
<tr>
<td colspan="11">Not Found for rawLog Data</td>
</tr>
</c:if>
</tbody>
</table>
</c:if>
<div class="paging">
<c:if test="${not empty result.pageView}">${result.pageView}</c:if>
<div class="btn_rgt">
<span class="button whitebtn"><a href="${excel_url}">Excel Download</a></span>
</div>
</div>
        <div id="flashContent">
            <p>
                To view this page ensure that Adobe Flash Player version 
                10.2.0 or greater is installed. 
            </p>
            <script type="text/javascript"> 
                var pageHost = ((document.location.protocol == "https:") ? "https://" : "http://"); 
                document.write("<a href='http://www.adobe.com/go/getflashplayer'><img src='" 
                                + pageHost + "www.adobe.com/images/shared/download_buttons/get_flash_player.gif' alt='Get Adobe Flash player' /></a>" ); 
            </script> 
        </div>
</body>

<!-- - - - - - - - - - - - - List End... - - - - - - - - - - - - -->


<jsp:directive.include file="/WEB-INF/views/backoffice/__footer.jsp"/>
</html>
