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
<spring:url value="${BACK_CTX}/contentpages" var="list_url"></spring:url>
<div class="h2box">
<h2>Entity Management</h2>
</div>
<h3>View</h3>
<div class="btnarea_top">
<div class="btn_rgt">
<span class="button whitebtn"><a href="${list_url}">List</a></span>
</div>
</div>
<c:if test="${not empty result}">
<table class="tbl_view" style="margin-bottom:30px;" summary="This is Entity Show">
<caption>Entity Show</caption>
<col width="10%">
<col width="10%">
<col width="80%">
<tbody>
<tr id="roo_contentpage_id">
<th colspan="2">id:</th><td>${result.contentPage.id}</td>
</tr>


<tr id="roo_contentpage_version">
<th colspan="2">version:</th><td>${result.contentPage.version}</td>
</tr>


<tr id="roo_contentpage_context">
<th colspan="2">context:</th><td>${result.contentPage.context}</td>
</tr>


<tr id="roo_contentpage_updateDate">
<th colspan="2">updateDate:</th><td>${result.contentPage.updateDate}</td>
</tr>


<tr id="roo_contentpage_writeDate">
<th colspan="2">writeDate:</th><td>${result.contentPage.writeDate}</td>
</tr>


<tr id="roo_contentpage_codeCreator">
<th colspan="2">codeCreator:</th><td>${result.contentPage.codeCreator}</td>
</tr>


</tbody>
</table>
</c:if>
<c:if test="${empty result}">No ContentPage found with this id.</c:if>
<div class="btnarea">
<spring:url value="${BACK_CTX}/contentpages/update/${result.contentPage.id}" var="update_url"></spring:url>
<div class="btn_rgt">
<span class="button bluebtn"><a href="${update_url}">Update</a></span><span class="button whitebtn"><a href="${list_url}">List</a></span>
</div>
</div>
</body>

</html>
