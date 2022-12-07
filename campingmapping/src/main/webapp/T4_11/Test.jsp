<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Insert title here</title>
        </head>

        <body>
            <h2>揪團管理</h2>
            <Form action="<c:url value='/controller'/>" method="POST">
                <input type="submit" name="item" value="新增" />
                <input type="submit" name="item" value="刪除" />
                <input type="submit" name="item" value="修改" />
                <input type="submit" name="item" value="查詢" />
            </Form>
           <form name="form" action="<c:url value='/view'/>" method="POST">
           <input type="submit" name="" value="GO" /> 
           </form>
</body>

        </html>