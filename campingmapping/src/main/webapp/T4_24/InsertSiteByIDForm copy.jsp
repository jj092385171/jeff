<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>新增營區位表單</title>
			<style>
				form {
					margin: 0 auto;
					width: 600px;
				}

				.class1 {
					border: 1px solid black;
					width: 500px;
					padding: 20px;

				}
			</style>
		</head>

		<body>
			<form name="InsertSiteByIDForm" action="<c:url value='/T4_24/InsertSiteByIDServlet' />" method="POST"
				enctype="multipart/form-data">
				<table border="1">
					<thead>
						<tr bgcolor='lightblue'>
							<th height="60" colspan="2" align="center">
								<h2>新增營區位資料</h2>
							</th>
						</tr>
					</thead>
					<tbody>
						<tr bgcolor='lightgreen'>
							<td width="120" height="40">營區位名:</td>
							<td width="600" height="40" align="left"><input id='siteName' style="text-align: left"
									name="siteName" value="${param.siteName}" type="text" size="14">
								<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.siteName}</div>
							</td>
						</tr>
						<tr bgcolor='lightgreen'>
							<td width="120" height="40">選擇營區位圖片:</td>
							<td width="600" height="40" align="left"><input id='sitePictures' name="sitePictures"
									type="file" size="20">
								<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.sitePictures}
								</div>
							</td>
						</tr>
						<tr bgcolor='lightgreen'>
							<td width="120" height="40">總營位:</td>
							<td width="600" height="40" align="left"><input id='totalSites' name="totalSites"
									value="${param.totalSites}" type="text" size="20">
								<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.totalSites}</div>
							</td>
						</tr>
						<tr bgcolor='lightgreen'>
							<td width="120" height="40">營位金額:</td>
							<td width="600" height="40" align="left"><input id='siteMoney' name="siteMoney"
									value="${param.siteMoney}" type="text" size="20">
								<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.siteMoney}</div>
							</td>
						</tr>
						<tr bgcolor='lightgreen'>
							<td width="120" height="40">營地編號:</td>
							<td width="600" height="40" align="left"><input id='campID' name="campID"
									readonly="readonly" value='${ cctBean.campID }' type="text" size="20">
							</td>
						</tr>
						<tr bgcolor='lightblue'>
							<td height="50" colspan="2" align="center"><input type="submit" value="送出"></td>
						</tr>
					</tbody>
				</table>
			</form>

			<div class='class1'>
				<form name="InsertSiteByIDForm">
					營地編號: <input type="text" name='campID' readonly="readonly" value='${ cctBean.campID }'><br>
					營地: <input type="text" name='campName' readonly="readonly" value='${ cctBean.campName }'><br>
					縣市編號: <input type="text" name='cityID' readonly="readonly" value='${ cctBean.cityID }'><br>
					縣市名: <input type="text" name='cityName' readonly="readonly" value='${ cctBean.cityName }'><br>
					縣市XXX:<c:forEach var='city' items='${cityList}'>
						<input type="radio" name="cityIDXXX" readonly="readonly" checked
							value="${city.cityID}" />${city.cityName}
					</c:forEach><br>
					縣市:<c:forEach var='city' items='${cityList}'>
						<input type="radio" name="cityID" readonly="readonly" value="${city.cityID}" />${city.cityName}
					</c:forEach><br>
					地址: <input type="text" name='location' readonly="readonly" value='${ cctBean.location }'><br>
					圖片: <input type="file" name="campPictures" readonly="readonly"><br>
					簡介: <input type="text" name='discription' readonly="readonly" value='${ cctBean.discription }'><br>
					標籤XXX: <c:forEach var='tag' items='${cctBean.tagList}'>
						<input type="checkbox" name="tagIDXXX" readonly="readonly" checked
							value="${tag.tagID}" />${tag.tagName}
					</c:forEach><br>
					標籤: <c:forEach var='tag' items='${tagList}'>
						<input type="checkbox" name="tagID" readonly="readonly" value="${tag.tagID}" />${tag.tagName}
					</c:forEach>
				</form>
			</div>

			<a href="<c:url value='IndexShowAllPageServlet' />">回首頁</a>
		</body>

		</html>