<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="layout/header.jsp"%>

<main>
	<h1>상세보기</h1>
	<hr />
	<table border="1">
		<tr>
			<td>ID</td>
			<td>TITLE</td>
			<td>CONTENT</td>
			<td>READCOUNT</td>
			<td>CREATEDATE</td>
		</tr>
		<tr>
			<td>${board.id }</td>
			<td><input id="title" type="text" value="${board.title }"/></td>
			<td><input id="content" type="text" value="${board.content }"/></td>
			<td>${board.readCount }</td>
			<td>${board.createDate }</td>
		</tr>
	</table>
	<button onclick="deleteBoard(${board.id})">삭제</button>
	<button onclick="updateBoard(${board.id})">수정</button>
</main>
<script type="text/javascript">
function updateBoard(id){
	//id,title,content
	let title_el = document.querySelector("#title").value;
	let content_el = document.querySelector("#content").value;
	console.log("id",id);
	console.log("title",title_el);
	console.log("content",content_el);

	let board = {
			title: title_el,
			content: content_el
			};
	console.log(board);
	fetch("/board/"+id,{
		method: "put",
		headers: {
			'Content-Type': 'application/json; charset=utf-8',
		},
		body: JSON.stringify(board)
		})
	.then(res=>res.text())
	.then(res=>{
		if(res=="ok"){
			alert("수정완료");
			location.reload();
		}else{
			alert("수정실패");
		}
		});
}


function deleteBoard(id){
	fetch("/board/"+id,{
		method:"delete"
		})
		.then(res=>res.text())
		.then(res=>{
				if(res=="ok"){
					alert("삭제성공");
					location.href="/list";
				}else{
					alert("삭제실패");
				}
			});	
}

</script>

<%@ include file="layout/footer.jsp"%>