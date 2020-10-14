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
				<th scope="col">Content</th>
				<th scope="col">READCOUNT</th>
				<th scope="col">CREATEDATE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${ boards}">
			<tr>
				<th scope="row">${board.id }</th>
				<td><a href="/board/${board.id }">${board.title }</a></td>
				<td>${board.content }</td>
				<td>${board.readCount }</td>
				<td>${board.createDate }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</main>

<%@ include file="layout/footer.jsp"%>