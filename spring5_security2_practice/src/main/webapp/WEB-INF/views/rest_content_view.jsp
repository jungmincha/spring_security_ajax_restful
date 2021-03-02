<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang = "en" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
<meta name="_csrf" th:content="${_csrf.token}"/>
<meta name="_csrf_header" th:content="${_csrf.headerName}"/>


   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


<title>Insert title here</title>
<script type="text/javascript">
   $(document).ready(function(){
       
      //https://m.blog.naver.com/PostView.nhn?blogId=moonv11&logNo=220605582547&proxyReferer=https:%2F%2Fwww.google.com%2F
      $("#updateForm").submit(function(event){
         
         event.preventDefault();
         
           var name = $("#bName").val();
           var bTitle = $("#bTitle").val();
           var bContent = $("#bContent").val();           
           var bId = $("#bId").val();
           
           console.log(bContent);
           console.log($(this).attr("action"));
           
           
           var form = {
                 bId: bId,
                  bName: name,
                   bContent: bContent,
                   bTitle: bTitle
           };
          //dataType: 'json',
           $.ajax({
             type : "PUT",
             url : $(this).attr("action"),
             cache : false,
             contentType:'application/json; charset=utf-8',
              data: JSON.stringify(form), 
              
              beforeSend : function(xhr)
              {   /*데이터를 전송하기 전에 헤더에 csrf값을 설정한다*/
                  xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
              },
              
              
             success: function (result) {       
               if(result == "SUCCESS"){
                  //list로 
                  
                  $(location).attr('href', '${pageContext.request.contextPath}/restful/board/')                            
               }                       
             },
             error: function (e) {
                 console.log(e);
             }
         })          
   
       }); // end submit()
       
   }); // end ready()
</script>
</head>
<body>


<div class = "container">
  
   <table class ="table table-hove" id="list-table"border="1">
      <form id="updateForm" action="${pageContext.request.contextPath}/restful/board/${content_view.bId}" method="post">
         <input type="hidden" id="bId" value="${content_view.bId}">
         <tr>
            <td> 번호 </td>
            <td> ${content_view.bId} </td>
         </tr>
         <tr>
            <td> 히트 </td>
            <td> ${content_view.bHit} </td>
         </tr>
         <tr>
            <td> 이름 </td>
            <td> <input type="text" id="bName" value="${content_view.bName}"></td>
         </tr>
         <tr>
            <td> 제목 </td>
            <td> <input type="text" id="bTitle" value="${content_view.bTitle}"></td>
         </tr>
         <tr>
            <td> 내용 </td>
            <td> <textarea rows="10" id="bContent" >${content_view.bContent}</textarea></td>
         </tr>
         <tr >
            <td colspan="2"> <input type="submit" value="수정"> &nbsp;&nbsp; <a href="/ex/restful/board">목록보기</a> &nbsp;&nbsp; <a href="${pageContext.request.contextPath}/restful/rest/board/${content_view.bId}">답변</a></td>
         </tr>
      </form>
   </table>
   </div>
</body>
</html>