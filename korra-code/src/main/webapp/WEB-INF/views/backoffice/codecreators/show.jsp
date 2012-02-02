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
<spring:url value="${BACK_CTX}/codecreators" var="list_url"></spring:url>
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

<tr id="roo_subject">
<th colspan="2">subject:</th><td>${result.codeCreator.subject}</td>
</tr>

<tr id="roo_codeCreator_shortUrl">
<th colspan="2">shortUrl:</th><td><a href="${shortUrl}${result.codeCreator.shortUrl}" target="_blank">${result.codeCreator.shortUrl}</a></td>
</tr>


<tr id="roo_codeCreator_contentUrl">
<th colspan="2">contentUrl:</th><td>${result.codeCreator.contentUrl}</td>
</tr>


<tr id="roo_codeCreator_codeFormat">
<th colspan="2">codeFormat:</th><td>${result.codeCreator.codeFormat}</td>
</tr>
<!-- ----------- files s ----------------- -->
<tr id="roo_codeCreator_codeFiles">
<th colspan="2">codeFiles:</th>
<td>
	<c:forEach items="${result.codeCreator.codeFiles}" var="codeFile">
		<img src="${codeFile.fileUrl}"/>,
	</c:forEach>
</td>
</tr>
<!-- ----------- files e ----------------- -->

<tr id="roo_codeCreator_writeDate">
<th colspan="2">writeDate:</th><td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" type="DATE" value="${result.codeCreator.writeDate}"/></td>
</tr>


</tbody>
</table>
</c:if>
<c:if test="${empty result}">No codeCreator found with this id.</c:if>
<div class="btnarea">
<spring:url value="${BACK_CTX}/codecreators/update/${result.codeCreator.id}" var="update_url"></spring:url>
<div class="btn_rgt">
<span class="button bluebtn"><a href="${update_url}">Update</a></span><span class="button whitebtn"><a href="${list_url}">List</a></span>
</div>
</div>
</body>

<!-- - - - - - - - - - - - - Show End... - - - - - - - - - - - - -->


<jsp:directive.include file="/WEB-INF/views/backoffice/__footer.jsp"/>
</html>
