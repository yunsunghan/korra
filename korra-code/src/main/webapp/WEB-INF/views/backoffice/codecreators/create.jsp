<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:directive.page contentType="text/html;charset=UTF-8"></jsp:directive.page>
<jsp:directive.include file="/WEB-INF/views/__system/taglibs.jsp"/>
<jsp:directive.include file="/WEB-INF/views/backoffice/__header.jsp"/>
</head>
<!--WARNING: This file is Not maintained by ROO! IT WON'T BE OVERWRITTEN unless you specify :)-->

<!-- - - - - - - - - - - - - Create Start... - - - - - - - - - - - - -->


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
<c:url value="/backoffice/codecreators/create" var="form_url"></c:url>
<form:form action="${form_url}" id="action_form" method="POST" modelAttribute="codecreator" onsubmit="return false;">
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
<tr id="roo_subject">
<th colspan="2">subject:</th><td>
<form:input cssStyle="width:250px" id="_subject" maxlength="30" path="subject" size="0"></form:input>
<br>
<form:errors cssClass="errors" id="_subject" path="subject"></form:errors>
</td>
</tr>

<!--fields : shortUrl-->
<tr id="roo_category">
<th colspan="2">Category:</th><td>

	<form:select cssStyle="width:100%" id="_codeCategory" maxlength="30" path="codeCategory" size="0">
		<form:options itemValue="id" itemLabel="title" items="${codeCategorys}"/>
	</form:select>
	<br>
	<form:errors cssClass="errors" id="_codeCategory" path="codeCategory"></form:errors>
</td>
</tr>

<!--fields : contenturl-->
<tr id="roo_contentUrl">
<th colspan="2">contentUrl:</th><td>
<form:input cssStyle="width:250px" id="_contentUrl" maxlength="250" path="contentUrl" size="0"></form:input>
<br>
<form:errors cssClass="errors" id="_contentUrl" path="contentUrl"></form:errors>
</td>
</tr>
<!--fields : barcodeformat-->
<tr id="roo_barcodeFormat">
<th colspan="2">barcodeFormat:</th><td>
	<form:select cssStyle="width:250px" id="_codeFormat" maxlength="30" path="codeFormat" size="0" items="${codeformats}">
	</form:select>
	<br>
	<form:errors cssClass="errors" id="_codeFormat" path="codeFormat"></form:errors>
</td>
</tr>
</tbody>
</table>
</form:form>
<div class="btnarea">
<div class="btn_cen">
<span class="button bluebtn"><a href="#" onclick="checkForm()">Apply</a></span>
</div>
<div class="btn_rgt02">
<span class="button whitebtn">
<spring:url value="/backoffice/codecreators" var="list_url"></spring:url>
<a href="${list_url}">List</a></span>
</div>
</div>
</body>

<!-- - - - - - - - - - - - - Create End... - - - - - - - - - - - - -->


<jsp:directive.include file="/WEB-INF/views/backoffice/__footer.jsp"/>
</html>
