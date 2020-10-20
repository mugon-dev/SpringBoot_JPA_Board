<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="layout/header.jsp"%>

<main>
	<div class="text-center mb-4">
		<h1 class="h3 mb-3 font-weight-normal">게시글 목록</h1>
	</div>
	<hr />
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Title</th>
				<th scope="col">READCOUNT</th>
				<th scope="col">CREATEDATE</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${ boards.content}">
			<tr>
				<th scope="row">${board.id }</th>
				<td><a href="/board/${board.id }">${board.title }</a></td>
				<td>${board.readCount }</td>
				<td>${board.createDate }</td>
				<td><a href="/board/${board.id }"><button>상세보기</button></a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<button onclick="prev()">이전</button>
	<button onclick="next()">다음</button>
</main>
<script type="text/javascript">
function prev(){
	console.log(${boards.pageable.pageNumber });
	var pageNumber = ${boards.pageable.pageNumber-1 };
	location.href="/list?page="+pageNumber;
}
function next(){
	console.log(${boards.pageable.pageNumber }+1);
	var pageNumber = ${boards.pageable.pageNumber+1 };
	location.href="/list?page="+pageNumber;
}
</script>
<%@ include file="layout/footer.jsp"%>