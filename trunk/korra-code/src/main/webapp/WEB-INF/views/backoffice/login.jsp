<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:directive.page contentType="text/html;charset=UTF-8" />
<jsp:directive.include file="/WEB-INF/views/__system/taglibs.jsp"/>
<jsp:directive.page import="org.springframework.security.core.AuthenticationException"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>	
<script type="text/javascript">
	function message(code){
		if(code == "E1"){
			alert("Tbizpoint 회원 인증에 실패 했습니다. 로그인 정보를 다시 확인해 주십시요.");
		} else if (code=="E2") {
			alert("세션이 종료되었습니다. 다시 로그인 해주십시요.");
		}
	}
	window.onload = function(){
		message("${param.code}");
	};
	
	function enter(){
		if (event.keyCode==13){
			document.getElementById("action_form").submit();
		}
	}
	function check(){
		document.getElementById("action_form").submit();
	}
</script>	
</head>
<body>
<spring:url value="/static/j_spring_security_check" var="form_url" />
<form name="f" id="action_form" action="${fn:escapeXml(form_url)}" method="post">
<div id="login_wrap">
	<div id="login_container">
		<spring:url value="/resources" var="image_url"/>
		<div class="logarea">
			<fieldset>
				<label for="ID" class="titid"><img src="${BACK_IMAGE_PATH}/tit_id.gif" alt="ID" /></label>
				<input type="text" style="width:176px;" class="inputbox" name="j_username" id="j_username" value="admin"/>
				<label for="Password" class="titpwd"><img src="${BACK_IMAGE_PATH}/tit_pwd.gif" alt="password" /></label>
				<span class="inpwd">
				<input type="password" name="j_password" id="j_password" style="width:176px;" onkeypress="javascript:enter();" class="inputbox" />
				</span>				
			</fieldset>
			<div class="loginbtn">
				<p><input type="checkbox" name="_spring_security_remember_me" id="remember_me" />아이디 저장</p>
				<span class="button bluebtn">
					<a href="#" onclick="check();">로그인</a>
				</span>
			</div>

			<div class="explain">
				<ul>
				   	<c:if test="${not empty param.login_error}">
				   		<div class="errors">
				   			로그인에 성공하지 못했습니다. 다시 시도해 주십시요.<br />
				   			(${SPRING_SECURITY_LAST_EXCEPTION.message})
				   		</div>
				   	</c:if>				
					<li>비밀번호를 잊으셨나요?</li>
					<li> 관리자에게 문의해주세요</li>
					<li>문의처 (Tel : xxxx-xxxx eMail : <a href="mailto:xxx@xxx.co.kr">xxx@xxx.co.kr</a>)</li>
				</ul>
				<p><a href="<spring:url value="/"/>">사용자 페이지 메인가기 ></a></p>
			</div>
		</div>
	</div>
</div>
</form>
</body>
</html>