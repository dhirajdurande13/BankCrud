<%@page import="java.util.List"%>
<%@page import="Bank.model.account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="SearchController">
      <table>
      
      <td>
      <tr>reg NO</tr>
      <tr><input name="regNo" type="number"></tr>
      </td>
       <br>
      <br>
      <td>
      
      <tr><input value="search" type="submit"></tr>
      </td>
      <br>
      <br>
      </table>
      </form>
      
      <% account acc=null; 
      List<account> lst=null;
      %>
      <% 
      if(!session.isNew())
      {
      	 lst=(List<account>)session.getAttribute("data");
      	 acc=lst.get(0);
      	 
      	   out.println("&nbsp"+acc.getRegNo()+"&nbsp"+acc.getCustName()+"&nbsp"+acc.getUsername()+"&nbsp"+acc.getAccBal());
      	session.invalidate();
      }
      %>
       
       
        			</body>
</html>