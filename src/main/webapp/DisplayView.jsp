<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <c:if test="${requestScope.accList!=null and not empty requestScope.accList}">
     <table border="1">
     <tr>
      <th>Reg No</th>
      <th>Cust Name</th>
      <th>Username</th>
      <th>Acc Bal</th>
     </tr>
      
     <c:forEach items="${requestScope.accList}" var="e">
       <tr>
       <td>${e.regNo }</td>
       <td>${e.custName }</td>
       <td>${e.username }</td>
       <td>${e.accBal }</td>
       </tr>
     </c:forEach>
     </table>
     
     </c:if>
</body>
</html>