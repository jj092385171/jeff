<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE HTML>

        <html>

        <head>
            <meta charset="utf-8" />
            <title>EEIT56_露營</title>
        </head>

        <body>
            <div>
                <a href="<c:url value='/IndexShowAllPageServlet' />"><strong>營地_營區位管理</strong></a>
            </div>

            <hr>

            <!-- Form -->
            <h3>新增營地資料:</h3>
            <form method="post" action="<c:url value='/T4_24/InsertCampServlet' />" enctype="multipart/form-data">
                <div>
                    <input type="text" name="campName" value="${param.campName}" placeholder="營地名" />
                    <div style="color:#FF0000; font-size:60%; display: inline">
                        ${ErrorMsg.campName}</div>
                </div>
                <div>
                    <input name="campPictures" type="file">
                    <div style="color:#FF0000; font-size:60%; display: inline">
                        ${ErrorMsg.campPictures}</div>
                </div>
                <!-- Break -->
                <c:forEach var='city' items='${cityList}'>
                    <div>
                        ${city.cityName}<input type="radio" name="cityID" value="${city.cityID}">
                    </div>
                </c:forEach>
                <div style="color:#FF0000; font-size:60%; display: inline">
                    ${ErrorMsg.cityID}</div>
                <!-- Break -->
                <div>
                    <input type="text" name="location" value="${param.location}" placeholder="地址" />
                    <div style="color:#FF0000; font-size:60%; display: inline">
                        ${ErrorMsg.location}</div>
                </div>
                <!-- Break -->
                <div>
                    <c:forEach var='tag' items='${tagList}'>
                        ${tag.tagName}<input type="checkbox" name="tagID" value="${tag.tagID}">
                    </c:forEach>
                </div>
                <div style="color:#FF0000; font-size:60%; display: inline">
                    ${ErrorMsg.tagIDs}</div>
                <!-- Break -->
                <div>
                    <textarea name="description" placeholder="描述" rows="6"></textarea>
                </div>
                <!-- Break -->
                <div>
                    <input type="submit" value="Add" />
                    <input type="reset" value="Reset" />
                </div>
            </form>

            <hr>

            <h3>請輸入營地 ID:</h3>
            <form method="post" action=" <c:url value='/T4_24/InsertSiteByCampIDPageServlet' />">
                <div>
                    <input type="text" name="campIDSite" value="${param.campIDSite}" placeholder="營地編號" />
                    <div style="color:#FF0000; font-size:60%; display: inline">
                        ${ErrorMsg.campIDSite}</div>
                </div>
                <!-- Break -->
                <div>
                    <input type="submit" value="Add" />
                    <input type="reset" value="Reset" />
                </div>
            </form>

            <div>
                <a href="<c:url value='/t4_24camp/admin/QueryPageForm.jsp' />">&emsp;查詢&emsp;營地_營區位</a>
                <br>
                <a href="<c:url value='/t4_24camp/admin/InsertCampForm.jsp' />">&emsp;新增&emsp;營地_營位區</a>
                <br>
                <a href="<c:url value='/t4_24camp/admin/UpdatePage.jsp' />">&emsp;修改&emsp;營地_營區位</a>
                <br>
                <a href="<c:url value='/t4_24camp/admin/deletePage.jsp' />">&emsp;刪除&emsp;營地_營區位</a>
                <br>
                <a href="<c:url value='IndexShowAllPageServlet' />">回首頁</a>
            </div>

        </body>

        </html>