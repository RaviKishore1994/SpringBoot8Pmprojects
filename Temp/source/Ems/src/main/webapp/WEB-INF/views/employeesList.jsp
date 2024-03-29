<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"  prefix="security" %>


<a  href="addEmployee"> add more employee </a> 
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
<a href="logoutMe">SignOut</a>
<br>
<table border=1>

  <tr>
    <th>empno</th>
    <th>ename</th>
    <th>sal</th>
    <th>deptno</th>
    <th>actions</th>
  </tr>    

  <c:if test="${!empty empModelList}">
     <c:forEach  items="${empModelList}"  var="emp">
        <tr>
          <td> <c:out value="${emp.empno}"/> </td>
          <td> <c:out value="${emp.ename}"/> </td>
          <td> <c:out value="${emp.sal}"/> </td>
          <td> <c:out value="${emp.deptno}"/> </td>
          <td> 
             <a href="editEmployee?id=${emp.empno}"> <img src="imgs/edit_image.png"  width="40" height="40"> </a>
              &nbsp; &nbsp; &nbsp; &nbsp;
              <security:authorize access="hasRole('ROLE_ADMIN')">
             <a href="deleteEmployee?id=${emp.empno}"> <img src="imgs/delete_image.jpg" width="40" height="40"> </a>
             </security:authorize>
          </td>             
        </tr>
     </c:forEach>
  </c:if>

</table>