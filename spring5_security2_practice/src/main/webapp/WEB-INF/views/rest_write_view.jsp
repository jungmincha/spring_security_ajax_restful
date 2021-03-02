<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang = "en" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
<meta name="_csrf" th:content="${_csrf.token}"/>
<meta name="_csrf_header" th:content="${_csrf.headerName}"/>


<title>Insert title here</title>
<meta charset="utf-8">

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
  
  
  
  
  
  
  
<script type="text/javascript">

   $(document).ready(function(){
       
      //https://m.blog.naver.com/PostView.nhn?blogId=moonv11&logNo=220605582547&proxyReferer=https:%2F%2Fwww.google.com%2F
      $("#writeForm").submit(function(event){
         
         event.preventDefault();
         
           var name = $("#bName").val();
           var bTitle = $("#bTitle").val();
           var bContent = $("#bContent").val();           
         /*   var bId = $("#bId").val();
           var bGroup = $("#bGroup").val();
           var bStep = $("#bStep").val();
           var bIndent = $("#bIndent").val(); */
    
           console.log(bContent);
           console.log($(this).attr("action"));

           
           var form = {
                
                  bName: name,
                   bContent: bContent,
                   bTitle: bTitle,
                  /*  bGroup : bGroup,
                   bStep : bStep,
                   bIndent : bIndent
                   bId: bId, */
           };
          //dataType: 'json',
           $.ajax({
             type : 'Post',
             url : $(this).attr("action"),
            cache : false,
            // async : true,
           
             contentType:'application/json; charset=utf-8',
              data: JSON.stringify(form), 
              
              beforeSend : function(xhr)
              {   /*데이터를 전송하기 전에 헤더에 csrf값을 설정한다*/
                  xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
              },
              
             success: function(result) {       
               if(result == "SUCCESS"){
                  //list로 
                  
                  $(location).attr('href', '${pageContext.request.contextPath}/restful/board')                            
               }                       
             },
             error: function (e) {
                 console.log("abcde");
            	 console.log(e);
             }
         })          
   
       }); // end submit()
       
   }); // end ready()
</script>
</head>
<body>
<div class = "container">
   <table class="table table-bordered" border = "1" id="list-table" width="500" cellpadding="0" cellspacing="0" border="1">
      <form id="writeForm" action="${pageContext.request.contextPath}/restful/rest_write_view" method="post">
       <%--   <input type="hidden" id="bId" value="${reply_view.bId}">
         <input type="hidden" id="bGroup" value="${reply_view.bGroup}">
         <input type="hidden" id="bStep" value="${reply_view.bStep}">
         <input type="hidden" id="bIndent" value="${reply_view.bIndent}"> --%>
         
<td style="text-align:center">번호</td>
<td></td>
</tr>

<tr>
<td style="text-align:center" >조회수</td>
<td></td>
</tr>

<tr>
<td style="text-align:center">이름</td>
<td>
<input type = "text" id = "bName"   style="width:100%; height:100%;">

</td>
</tr>

<tr>
<td style="text-align:center">제목</td>
<td>
<input type = "text" id = "bTitle"  style="width:100%; height:100%;">
</td>
</tr>

<tr>
<td style="text-align:center">내용</td>
<td>
<textarea rows="10" id="bContent" style="width:100%; height:100%;">
</textarea>
</td>
</tr>

<tr>
<td style="text-align:center"> <input type = "submit" value = "작성 완료">

<td><a href = "${pageContext.request.contextPath}/restful/board">목록으로</a>&nbsp;&nbsp;



</tr>
</form>

  <div class="content">
		<br/><br/>
		<h3>파일 업로드</h3>
		<form action="${pageContext.request.contextPath}/common/upload?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
		  <table>
		    <tr>
		      <td>Select File</td>
		      <td><input type="file" name="uploadFile" /></td>
		      <td>
		        <button type="submit">Upload</button>
		      </td>
		    </tr>
		  </table>
		</form>
	</div>

</table>
</div>
</div>
</body>
</html>