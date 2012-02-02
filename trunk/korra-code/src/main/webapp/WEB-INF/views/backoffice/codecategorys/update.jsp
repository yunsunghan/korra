<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:directive.page contentType="text/html;charset=UTF-8"></jsp:directive.page>
<jsp:directive.include file="/WEB-INF/views/__system/taglibs.jsp"/>
<jsp:directive.include file="/WEB-INF/views/backoffice/__header.jsp"/>
</head>
<!--WARNING: This file is Not maintained by ROO! IT WON'T BE OVERWRITTEN unless you specify :)-->

<!-- - - - - - - - - - - - - Update Start... - - - - - - - - - - - - -->


<body>
<spring:url value="${BACK_CTX}/codecategorys" var="list_url"></spring:url>
<div class="h2box">
<h2>Entity Management</h2>
</div>
<h3>View</h3>
<div class="btnarea_top">
<div class="btn_rgt">
<span class="button whitebtn"><a href="${list_url}">List</a></span>
</div>
</div>
<c:url value="/backoffice/codecategorys/update" var="form_url"></c:url>
<form:form action="${form_url}" id="action_form" method="POST" modelAttribute="codecategory" onsubmit="return false;">
<table class="tbl_view" style="margin-bottom:30px;" summary="This is Entity Show">
<caption>Entity Create</caption>
<col width="10%">
<col width="10%">
<col width="80%">
<tbody>
<!--fields : id-->
<!--skip : id-->
<!--fields : version-->
<!--skip : version-->
<!--fields : parentid-->
<tr id="roo_parentId">
<th colspan="2">parentId:</th><td>
<form:input cssStyle="width:250px" id="_parentId" maxlength="30" path="parentId" size="0"></form:input>
<br>
<form:errors cssClass="errors" id="_parentId" path="parentId"></form:errors>
</td>


</tr>
<!--fields : title-->
<tr id="roo_title">
<th colspan="2">title:</th><td>
<form:input cssStyle="width:250px" id="_title" maxlength="30" path="title" size="0"></form:input>
<br>
<form:errors cssClass="errors" id="_title" path="title"></form:errors>
</td>


</tr>
<!--fields : codecreators-->
<tr id="roo_codeCreators">
<th colspan="2">codeCreators:</th><td>
<c:if test="${not empty codecreators}">codeCreatorsis Many :)</c:if>
<br>
<form:errors cssClass="errors" id="_codeCreators" path="codeCreators"></form:errors>
</td>


</tr>
</tbody>
</table>
<form:hidden id="_id" path="id"></form:hidden>
<form:hidden id="_version" path="version"></form:hidden>
</form:form>
<div class="btnarea">
<div class="btn_cen">
<span class="button bluebtn"><a href="#" onclick="checkForm()">Apply</a></span>
</div>
<div class="btn_rgt02">
<span class="button whitebtn">
<spring:url value="/backoffice/codecategorys" var="list_url"></spring:url>
<a href="${list_url}">List</a></span>
</div>
</div>
</body>

<!-- - - - - - - - - - - - - Update End... - - - - - - - - - - - - -->


<jsp:directive.include file="/WEB-INF/views/backoffice/__footer.jsp"/>
</html>
