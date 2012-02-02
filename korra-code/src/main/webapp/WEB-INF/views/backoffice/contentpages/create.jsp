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
<c:url value="/backoffice/contentpages/create" var="form_url"></c:url>
<form:form action="${form_url}" id="action_form" method="POST" modelAttribute="contentpage" onsubmit="return false;">
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
<!--fields : context-->
<tr id="roo_context">
<th colspan="2">context:</th><td>
<form:textarea cssStyle="width:100%" id="_context" maxlength="30" path="context" size="0"></form:textarea>
<br>
<form:errors cssClass="errors" id="_context" path="context"></form:errors>
</td>
</tr>
<!--fields : updatedate-->
<tr id="roo_updateDate">
<th colspan="2">updateDate:</th><td>
<form:input cssStyle="width:250px" id="_updateDate" maxlength="30" path="updateDate" size="0"></form:input>
<a href="#" onclick="showCal(this)"><img alt="Show Calendar" src="${BACK_IMAGE_PATH}/icon_calendar.gif"></a>
<br>
<form:errors cssClass="errors" id="_updateDate" path="updateDate"></form:errors>
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
<!--fields : codecreator-->
<tr id="roo_codeCreator">
<th colspan="2">codeCreator:</th><td>
<c:if test="${not empty codecreators}">codeCreatoris ManyToOne :)</c:if>
<br>
<form:errors cssClass="errors" id="_codeCreator" path="codeCreator"></form:errors>
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
<spring:url value="/backoffice/contentpages" var="list_url"></spring:url>
<a href="${list_url}">List</a></span>
</div>
</div>
</body>
</html>
