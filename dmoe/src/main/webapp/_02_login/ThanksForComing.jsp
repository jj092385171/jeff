<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var='logoutMessage' scope='session' >
<font color='blue' >
   訪客${ memberName }，感謝您使用本系統。<BR>
   您已經登出<BR>
</font>
</c:set>
