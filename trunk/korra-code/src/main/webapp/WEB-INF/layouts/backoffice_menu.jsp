<jsp:directive.page contentType="text/html;charset=UTF-8" />
	<li<c:if test="${menuType eq 'index' or menuType eq 'front_index' }"> class="fir on"</c:if>><a href="<spring:url value="/backoffice/index"/>">홈</a>
		<ul>
			<li class="fir"><a href="<spring:url value="/backoffice/index"/>">관리자 홈</a></li>
			<li><a href="<spring:url value="/front/index"/>">사용자 홈</a></li>
		</ul>
	</li>
<li<c:if test="${menuType eq 'codecategory'}"> class="fir on"</c:if>><a href="<spring:url value="/backoffice/codecategorys"/>">카테고리</a>
	<ul>
		<li class="fir"><a href="<spring:url value="/backoffice/codecategorys"/>">CodeCategory List</a></li>
		<li><a href="<spring:url value="/backoffice/codecategorys/create"/>">CodeCategory Create</a></li>
	</ul>
</li>
<li<c:if test="${menuType eq 'codecreator'}"> class="fir on"</c:if>><a href="<spring:url value="/backoffice/codecreators"/>">코드관리</a>
	<ul>
		<li class="fir"><a href="<spring:url value="/backoffice/codecreators"/>">CodeCreator List</a></li>
		<li><a href="<spring:url value="/backoffice/codecreators/create"/>">CodeCreator Create</a></li>
	</ul>
</li>
<li<c:if test="${menuType eq 'contentpage'}"> class="fir on"</c:if>><a href="<spring:url value="/backoffice/contentpages"/>">컨텐츠관리</a>
	<ul>
		<li class="fir"><a href="<spring:url value="/backoffice/contentpages"/>">ContentPage List</a></li>
		<li><a href="<spring:url value="/backoffice/contentpages/create"/>">ContentPage Create</a></li>
	</ul>
</li>
<li<c:if test="${menuType eq 'account'}"> class="fir on"</c:if>><a href="<spring:url value="/backoffice/accounts"/>">사용자관리</a>
	<ul>
		<li class="fir"><a href="<spring:url value="/backoffice/accounts"/>">Account List</a></li>
		<li><a href="<spring:url value="/backoffice/accounts/create"/>">Account Create</a></li>
	</ul>
</li>
<li<c:if test="${menuType eq 'analyzer'}"> class="fir on"</c:if>><a href="<spring:url value="/backoffice/analyzers"/>">통계분석</a>
	<ul>
		<li><a href="<spring:url value="/backoffice/analyzers"/>">Analyzer</a></li>
	</ul>
</li>
<li<c:if test="${menuType eq 'errorhistory'}"> class="fir on"</c:if>><a href="<spring:url value="/backoffice/errorhistorys"/>">에러로그</a>
	<ul>
		<li class="fir"><a href="<spring:url value="/backoffice/errorhistorys"/>">ErrorHistory List</a></li>
		<li><a href="<spring:url value="/backoffice/errorhistorys/create"/>">ErrorHistory Create</a></li>
	</ul>
</li>
