<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>
<main>
	<h1>글쓰기 페이지</h1>
	<hr />
	
	<div id="form-container" class="container">
		<form action="/save" method="post">
				<div class="form-group">
					<label for="display_name">Title</label> 
					<input class="form-control" name="display_name" type="text" name="title"/>
				</div>
			<div class="row form-group">
				<input name="content" type="hidden" >
				<div id="editor-container">
					<p>A robot who has developed sentience, and is the only robot
						of his kind shown to be still functioning on Earth.</p>
				</div>
			</div>
			<div class="row">
				<button class="btn btn-primary" type="submit">Save</button>
			</div>
		</form>
	</div>
</main>
<!-- Include the Quill library -->
<script src="https://cdn.quilljs.com/1.0.0/quill.js"></script>
<script>
	var quill = new Quill('#editor-container', {
		modules : {
			toolbar : [ [ 'bold', 'italic' ],
					[ 'link', 'blockquote', 'code-block', 'image' ], [ {
						list : 'ordered'
					}, {
						list : 'bullet'
					} ] ]
		},
		placeholder : 'Compose an epic...',
		theme : 'snow'
	});

	var form = document.querySelector('form');
	form.onsubmit = function() {
		// Populate hidden form on submit
		var content = document.querySelector('input[name=content]');
		content.value = JSON.stringify(quill.getContents());
		var title = document.querySelector('input[name=title]').value;
		console.log("content: ",content);
		console.log("title: : ",title);
		console.log("Submitted", $(form).serialize(), $(form).serializeArray());
		
		// No back end to actually submit to!
		alert('Open the console to see the submit data!')
		return false;
	};
</script>
<%@ include file="layout/footer.jsp"%>