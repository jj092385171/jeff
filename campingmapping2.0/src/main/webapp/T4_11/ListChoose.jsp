<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Insert title here</title>
        </head>

        <body>
            <h2>請選擇欲前往表單</h2>
            <Form action="<c:url value='/listchoose'/>" method="POST">
                <input type="submit" name="item" value="揪團" />
                <input type="submit" name="item" value="申請" />
                <input type="submit" name="item" value="留言" />
            </Form>
        </body>

        </html>