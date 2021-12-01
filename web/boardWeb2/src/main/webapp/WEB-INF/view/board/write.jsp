<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String err = (String)request.getAttribute("err");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Write</title>
</head>
<body>
<h1>글쓰기</h1>
<% if(err != null) { %>
<div><%=err%></div>
<% } %>
<div>
    <form action="/board/write" method="post">
        <div><input type="text" name="title" placeholder="title" value="${requestScope.data.title}"></div>
        <div>
            <textarea name="ctnt" placeholder="content" rows="20">${requestScope.data.ctnt}</textarea>
        </div>
        <div>
            <input type="submit" value="등록">
            <input type="reset" value="초기화">
        </div>
    </form>
</div>
</body>
</html>