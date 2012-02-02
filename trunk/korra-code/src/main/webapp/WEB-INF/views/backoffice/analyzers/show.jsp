<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:directive.page contentType="text/html;charset=UTF-8"></jsp:directive.page>
<jsp:directive.include file="/WEB-INF/views/__system/taglibs.jsp"/>
<jsp:directive.include file="/WEB-INF/views/backoffice/__header.jsp"/>
</head>
<!--WARNING: This file is Not maintained by ROO! IT WON'T BE OVERWRITTEN unless you specify :)-->

<!-- - - - - - - - - - - - - Show Start... - - - - - - - - - - - - -->


<body>
<spring:url value="${BACK_CTX}/analyzers" var="list_url"></spring:url>
<div class="h2box">
<h2>Entity Management</h2>
</div>
<h3>View</h3>
<div class="btnarea_top">
<div class="btn_rgt">
<span class="button whitebtn"><a href="${list_url}">List</a></span>
</div>
</div>
<c:if test="${not empty rawLog}">
<table class="tbl_view" style="margin-bottom:30px;" summary="This is Entity Show">
<caption>Entity Show</caption>
<col width="10%">
<col width="10%">
<col width="80%">
<tbody>

<tr id="roo_codecreator_acceptLanguage">
<th colspan="2">acceptLanguage:</th><td>${rawLog.acceptLanguage}</td>
</tr>


<tr id="roo_codecreator_userAgent">
<th colspan="2">userAgent:</th><td>${rawLog.userAgent}</td>
</tr>


<tr id="roo_codecreator_writeDate">
<th colspan="2">writeDate:</th><td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" type="DATE" value="${rawLog.writeDate}"/></td>
</tr>

<tr id="roo_codecreator_codeCreatorId">
<th colspan="2">codeCreatorId:</th><td>${rawLog.codeCreatorId}</td>
</tr>


</tbody>
</table>
</c:if>
<c:if test="${empty result}">No CodeCreator found with this id.</c:if>
<div class="btnarea">
<spring:url value="${BACK_CTX}/analyzers/update/${rawLog.id}" var="update_url"></spring:url>
<div class="btn_rgt">
<span class="button whitebtn"><a href="${list_url}">List</a></span>
</div>
</div>
</body>

<!-- - - - - - - - - - - - - Show End... - - - - - - - - - - - - -->


<jsp:directive.include file="/WEB-INF/views/backoffice/__footer.jsp"/>
</html>
