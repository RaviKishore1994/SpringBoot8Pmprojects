<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<br>
<br>

<table border="1" background="yellow">
  <tr>
     <th>PHONENO</th>
     <th>CALLEDTO</th>
     <th>CALLEDON</th>
     <th>DURATION</th>
  </tr>
  
  <c:if  test="${!empty callDetailsDtoList }">
     <c:forEach  items="${callDetailsDtoList}"   var="callDetailsDto">
        <tr>
           <td> <c:out  value="${callDetailsDto.calledBy }"/> </td>
           <td> <c:out  value="${callDetailsDto.calledTo }"/> </td>
           <td> <c:out  value="${callDetailsDto.calledOn }"/> </td>
           <td> <c:out  value="${callDetailsDto.durationInSeconds }"/> </td>
        </tr>
     </c:forEach>
  </c:if>
</table>