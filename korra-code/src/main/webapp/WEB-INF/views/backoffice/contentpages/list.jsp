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
<spring:url value="${BACK_CTX}/contentpages/excel" var="excel_url"></spring:url>
<spring:url value="${BACK_CTX}/contentpages/create" var="create_url"></spring:url>
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
<col width="30%">
<thead>
<tr>
<th class="first">Id</th>

<th>Context</th>

<th>Update Date</th>

<th>Write Date</th>

<th>Code Creator</th>

<th>Management</th>
</tr>
</thead>
<tbody>
<spring:url value="${BACK_CTX}/contentpages/show" var="show_url"></spring:url>
<spring:url value="${BACK_CTX}/contentpages/update" var="update_url"></spring:url>
<spring:url value="${BACK_CTX}/contentpages/delete/${contentpage.id}" var="delete_url"></spring:url>
<spring:url value="/resources" var="img"></spring:url>
<c:forEach items="${result.contentPageList}" var="contentpage">
<tr>
<td>${fn:substring(contentpage.id, 0, 20)}</td><td>${fn:substring(contentpage.context, 0, 20)}</td><td>
<fmt:formatDate pattern="yyyy. M. d" type="DATE" value="${contentpage.updateDate}"></fmt:formatDate>
</td><td>
<fmt:formatDate pattern="yyyy. M. d" type="DATE" value="${contentpage.writeDate}"></fmt:formatDate>
</td><td>${fn:substring(contentpage.codeCreator, 0, 20)}</td><td><a href="${show_url}/${contentpage.id}">[View]</a><a href="${update_url}/${contentpage.id}">[Modify]</a><a href="${delete_url}/${contentpage.id}">[Delete]</a></td>
</tr>
</c:forEach>
<c:if test="${empty result}">
<tr>
<td colspan="7">Not Found for contentpage Data</td>
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
</html>
