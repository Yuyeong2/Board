<%@ page import="com.koreait.board2.model.BoardVO" %>
<%@ page import="com.koreait.board2.model.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BoardVO vo = (BoardVO) request.getAttribute("data");
    UserVO loginUser = (UserVO)session.getAttribute("loginUser");
    int prev = (int) request.getAttribute("prev");
    int next = (int) request.getAttribute("next");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상세 정보</title>
</head>
<body>
    <h1><%= vo.getTitle()%></h1>
    <div>
        <a href="/board/list"><input type="button" value="목록"></a>
        <% if (loginUser != null && vo.getWriter() == loginUser.getIuser()) { %>
            <a href="/board/mod?iboard=${requestScope.data.iboard}"><input type="button" value="수정"></a>
            <a href="/board/del?iboard=${requestScope.data.iboard}"><input type="button" value="삭제"></a>
        <% } %>
        <% if ( prev != 0) { %>
        <a href="/board/detail?iboard=<%=prev%>"><input type="button" value="이전글"></a>
        <% } %>
        <% if ( next != 0) { %>
        <a href="/board/detail?iboard=<%=next%>"><input type="button" value="다음글"></a>
        <% } %>
    </div>
    <div>${requestScope.err}</div>
<div>번호 : <%= vo.getIboard()%></div>
<div>제목 : <%= vo.getTitle()%></div>
<div>작성자 : <%= vo.getWriterNm()%></div>
<div>작성일시 : <%= vo.getRdt()%></div>
<div>내용 : <%= vo.getCtnt()%></div>

</body>
</html>
