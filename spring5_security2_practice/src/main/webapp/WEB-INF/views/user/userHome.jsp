<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
   <title>유저 페이지</title>
</head>

<body>

<h1>유저 페이지 입니다.</h1>

<p>principal: <sec:authentication property="principal"/></p>


<%-- <p>principal: <sec:authentication property="principal.member.username"/> --%>

 <p>EmpVO: <sec:authentication property="principal.emp"/></p> 
<p>사용자이름: <sec:authentication property="principal.emp.ename"/></p>
<p>사용자월급: <sec:authentication property="principal.emp.sal"/></p>
<p>사용자입사일자: <sec:authentication property="principal.emp.hiredate"/></p> 
<p>사용자커미션: <sec:authentication property="principal.emp.comm"/></p> 
<p>사용자직업: <sec:authentication property="principal.emp.job"/></p> 


<p><a href="<c:url value="/" />">홈</a></p>

 <!-- 로그인 중이 아닌 모든 사용자들에게 보여지는 페이지 -->
<sec:authorize access ="isAnonymous()">
<a href = "/login">로그인</a>
</sec:authorize>


<!-- 로그인 중 -->
<sec:authorize access ="isAuthenticated()">
<a href = "/logout">로그아웃</a>
</sec:authorize>



<sec:authorize access ="hasRole('ROLE_ADMIN')">
<a href = "/admin/adminHome">관리자 페이지</a>
</sec:authorize>


</body>
</html>