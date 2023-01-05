<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>showAll</title>
<style>
.c1 {
	width: 588px;
	left: 500px;
	color: blue;
	justify-content: center;
	align-items: center;
	margin: auto
}

.t1 {
	border: 2px black solid;
	background-color: lightblue;
}

.t2 {
	border: 2px solid;
	border-color: black;
	background-color: lightgreen;
}

.t3 {
	border: 2px solid;
}

.b {
	text-align: center;
}
</style>
</head>

<body>
	<div class="c1">
		<table class="t1">
			<thead>
				<tr>

					<th>刊登編號</th>
					<th>uID</th>
					<th>職缺</th>
					<th>薪水</th>
					<th>人數</th>
					<th>地點</th>
					<th>上班時段</th>
					<th>上班日期</th>
					<th>照片</th>
					<th>備註</th>
					<th>上架日期</th>
					<th>下架日期</th>
				</tr>
			</thead>
			<tbody class="t2">
				<c:forEach var="JobBean" items="${showAllJob}">
					<tr>


						<td>${JobBean.rackID}</td>
						<td>${JobBean.uID}</td>
						<td>${JobBean.job}</td>
						<td>${JobBean.salary}</td>
						<td>${JobBean.quantity}</td>
						<td>${JobBean.place}</td>
						<td>${JobBean.date}</td>
						<td>${JobBean.time}</td>
						<td><img width="80" height="100"
							src="<c:url value='/JobServletImg?id=${JobBean.rackID}'/>" /></td>
						<td>${JobBean.remark}</td>
						<td>${JobBean.rackUp}</td>
						<td>${JobBean.rackDown}</td>


						<td>
<%-- 							<form action="<c:url value='/JobServletDelete'/>" method="POST" --%>
<!-- 								enctype="multipart/form-data"> -->
<%-- 								<input type="hidden" name="de" value="${JobBean.rackID}"> --%>
<!-- 								<button>刪除</button> -->
								<button class="delete" name="de" value='${JobBean.rackID}' type="button">刪除</button>

<!-- 							</form> -->
							<form action="<c:url value='/JobServletFindBeanByRackID'/>"
								method="POST" enctype="multipart/form-data">
								<input type="hidden" name="up" value="${JobBean.rackID}">
								<button>修改</button>
							</form>

						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<form action="<c:url value='/t4_09job/job/JobModel/jobCRUD.jsp' />"
		method="POST" enctype="multipart/form-data">
		<div class="b">
			<button>回首頁</button>
		</div>
	</form>

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.6.1.js"></script>
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

	<script>
    $(function(){
        $('.delete').click(function(){
            let id=$(this).attr("value");
            Swal.fire({
              title: 'Are you sure?',
              text: "You won't be able to revert this!",
              icon: 'warning',
              showCancelButton: true,
              confirmButtonColor: '#3085d6',
              cancelButtonColor: '#d33',
              confirmButtonText: 'Yes, delete it!'
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                      url:'/campingmapping2.0/JobServletDelete',
                      method:"post",
                      dataType:"text",
                      data: {"de":id},
                    })
                        .done(function () {
                            location.reload();
                            console.log("delete")
                         })//done
                         .fail(function(error) {
                             console.log(error)
                         })//fail end
                }//if
              })//then

          })//click end
    });
    //function end
</script>

</body>

</html>