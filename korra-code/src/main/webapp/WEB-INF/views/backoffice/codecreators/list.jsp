<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:directive.page contentType="text/html;charset=UTF-8"></jsp:directive.page>
<jsp:directive.include file="/WEB-INF/views/__system/taglibs.jsp"/>
<jsp:directive.include file="/WEB-INF/views/backoffice/__header.jsp"/>
</head>
<!--WARNING: This file is Not maintained by ROO! IT WON'T BE OVERWRITTEN unless you specify :)-->

<!-- - - - - - - - - - - - - List Start... - - - - - - - - - - - - -->


<body>
<spring:url value="${BACK_CTX}/codecreators/excel" var="excel_url"></spring:url>
<spring:url value="${BACK_CTX}/codecreators/create" var="create_url"></spring:url>
<div class="h2box">
<h2>Entity Management</h2>
</div>
<h3>Entity List</h3>
<div class="btnarea_top">
<div class="btn_rgt">
<span class="button whitebtn"><a href="${excel_url}">Excel Download</a></span><span class="button bluebtn"><a href="${create_url}">Create</a></span>
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

<th>일반</th>
<th>Block-MySQL</th>
<th>NonBlock-MongoDB</th>
<th>Category</th>
<th>subject</th>
<th>Code Format</th>
<th>Files</th>
<th>Management</th>
</tr>
</thead>
<tbody>
<spring:url value="${BACK_CTX}/codecreators/show" var="show_url"></spring:url>
<spring:url value="${BACK_CTX}/codecreators/update" var="update_url"></spring:url>
<spring:url value="${BACK_CTX}/codecreators/delete/${codecreator.id}" var="delete_url"></spring:url>
<spring:url value="/resources" var="img"></spring:url>
<c:forEach items="${result.codeCreatorList}" var="codecreator">
<tr>
<td>
	${fn:substring(codecreator.id, 0, 20)}
</td>
<td>[<a href="${shortUrl}${codecreator.shortUrl}" target="_blank">일반</a>]</td>
<td>[<a href="http://localhost/korra-code/ab/${codecreator.shortUrl}" target="_blank">Block-MySQL</a>]</td>
<td>[<a href="http://localhost/korra-code/an/${codecreator.shortUrl}" target="_blank">NonBlock-MongoDB</a>]</td>
<td>${fn:substring(codecreator.codeCategory.title, 0, 20)}</td>
<td>${fn:substring(codecreator.subject, 0, 20)}</td>
<td>${fn:substring(codecreator.codeFormat, 0, 20)}</td>
<td>
	<c:forEach items="${codecreator.codeFiles}" var="codeFile">
	<c:if test="${fn:endsWith(codeFile.fileUrl,'_p100.png')}"><img src="${codeFile.fileUrl}"/></c:if>
	</c:forEach>
</td>
<td><a href="${show_url}/${codecreator.id}">[View]</a><a href="${update_url}/${codecreator.id}">[Modify]</a><a href="${delete_url}/${codecreator.id}">[Delete]</a></td>
</tr>
</c:forEach>
<c:if test="${empty result}">
<tr>
<td colspan="11">Not Found for codecreator Data</td>
</tr>
</c:if>
</tbody>
</table>
</c:if>
<div class="paging">
<c:if test="${not empty result.pageView}">${result.pageView}</c:if>
<div class="btn_rgt">
<span class="button whitebtn"><a href="${excel_url}">Excel Download</a></span><span class="button bluebtn"><a href="${create_url}">Create</a></span>
</div>
</div>
</body>

<!-- - - - - - - - - - - - - List End... - - - - - - - - - - - - -->


<jsp:directive.include file="/WEB-INF/views/backoffice/__footer.jsp"/>
</html>
