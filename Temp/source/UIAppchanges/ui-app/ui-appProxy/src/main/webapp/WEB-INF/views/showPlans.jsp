<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>

<c:set var="count" value="1"/>
<table border="1">
 <tr>
   <th>PLANID</th> <th>PLANNAME</th> <th>VALIDITY</th> <th>DESCRIPTION</th>
 </tr>
 <c:forEach  items="${planDtoList}"  var="pdto">
   <c:if test="${count%2 != 0 }">
    <tr style="background: green; color: white;">
      <td> <c:out  value="${pdto.planId}"/> </td>
      <td> <c:out  value="${pdto.planName}"/> </td>
      <td> <c:out  value="${pdto.validity}"/> </td>
      <td> <c:out  value="${pdto.description}"/> </td>
    </tr>
   </c:if>
   <c:if test="${count%2 == 0 }">
    <tr style="background: blue; color: yellow;">
      <td> <c:out  value="${pdto.planId}"/> </td>
      <td> <c:out  value="${pdto.planName}"/> </td>
      <td> <c:out  value="${pdto.validity}"/> </td>
      <td> <c:out  value="${pdto.description}"/> </td>
    </tr>
   </c:if>
   <c:set var="count"  value="${count+1}"/>       
 </c:forEach>
 </table>