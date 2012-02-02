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
<spring:url value="${BACK_CTX}/errorhistorys" var="list_url"></spring:url>
<div class="h2box">
<h2>Entity Management</h2>
</div>
<h3>View</h3>
<div class="btnarea_top">
<div class="btn_rgt">
<span class="button whitebtn"><a href="${list_url}">List</a></span>
</div>
</div>
<c:url value="/backoffice/errorhistorys/update" var="form_url"></c:url>
<form:form action="${form_url}" id="action_form" method="POST" modelAttribute="errorhistory" onsubmit="return false;">
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
<!--fields : errormessage-->
<tr id="roo_errorMessage">
<th colspan="2">errorMessage:</th><td>
<form:input cssStyle="width:250px" id="_errorMessage" maxlength="30" path="errorMessage" size="0"></form:input>
<br>
<form:errors cssClass="errors" id="_errorMessage" path="errorMessage"></form:errors>
</td>


</tr>
<!--fields : stacktrace-->
<tr id="roo_stackTrace">
<th colspan="2">stackTrace:</th><td>
<form:input cssStyle="width:250px" id="_stackTrace" maxlength="30" path="stackTrace" size="0"></form:input>
<br>
<form:errors cssClass="errors" id="_stackTrace" path="stackTrace"></form:errors>
</td>


</tr>
<!--fields : writedate-->
<tr id="roo_writeDate">
<th colspan="2">writeDate:</th><td>
<form:input cssStyle="width:250px" id="_writeDate" maxlength="30" path="writeDate" size="0"></form:input>
<a href="#" onclick="showCal(this)"><img alt="Show Calendar" src="${BACK_IMAGE_PATH}/icon_calendar.gif"></a>
<br>
<form:errors cssClass="errors" id="_writeDate" path="writeDate"></form:errors>
</td>


</tr>
<!--fields : summary-->
<tr id="roo_summary">
<th colspan="2">summary:</th><td>
<form:input cssStyle="width:250px" id="_summary" maxlength="30" path="summary" size="0"></form:input>
<br>
<form:errors cssClass="errors" id="_summary" path="summary"></form:errors>
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
<spring:url value="/backoffice/errorhistorys" var="list_url"></spring:url>
<a href="${list_url}">List</a></span>
</div>
</div>
</body>

<!-- - - - - - - - - - - - - Update End... - - - - - - - - - - - - -->


<jsp:directive.include file="/WEB-INF/views/backoffice/__footer.jsp"/>
</html>
