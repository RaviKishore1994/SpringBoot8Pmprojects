<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:if test="${message ne null}">
<c:out value="${message}"/>
</c:if>
<hr>
<form:form action="save" method="post" modelAttribute="custBean">
<table>
<tr>
<td>FIRST NAME</td> <td><form:input path="firstName"/></td> <td style="color: red; "><form:errors path="firstName"/></td>
</tr>
<tr>
<td>LAST NAME</td> <td><form:input path="lastName"/></td> <td style="color: red; "><form:errors path="lastName"/></td>
</tr>
<tr>
<td>EMAIL</td> <td><form:input path="email"/></td> <td style="color: red;"><form:errors path="email"/></td>
</tr>
<tr>
<td>PASSWORD</td> <td><form:input path="password"/></td> <td style="color: red;"><form:errors path="password"/></td>
</tr>
<tr>
<td>AGE</td> <td><form:input path="age"/></td> <td style="color: red;"><form:errors path="age"/></td>
</tr>
<tr>
<td>GENDER</td> <td><form:radiobutton path="gender" value="MALE" label="M"/>
<form:radiobutton path="gender" value="FEMALE" label="F"/>
<form:radiobutton path="gender" value="OTHER" LABEL="OTH"/>
</td>
<tr>
<td>DOB</td> <td><form:input type="date" path="dob"/></td> <td style="color: red;"><form:errors path="dob"/></td>
</tr>
<tr>
<td>CONTACT NUMBER</td> <td><form:input path="contactNumber"/></td> <td style="color: red;"><form:errors path="contactNumber"/></td>
</tr>
<tr>
<td>COUNTRY</td> 
	<td><form:select path="country">
	<form:option value="">--Select Country</form:option>
	<form:options items="{custBean.countries}"/>
	</form:select>
	</td>
	<td style="color:red;"><form:errors path="country"/></td>
	</tr>
	<tr>
	<td colspan="3" align="center"><input type="submit" value="SUBMIT">
	
	</td>
	</tr>
	
</table>
</form:form>>
