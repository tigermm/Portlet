<%--
  Created by IntelliJ IDEA.
  User: softaria
  Date: 14.01.16
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<portlet:actionURL var="actionMethodURL" name="actionOne"/>

<form:form name="userName" method="post" modelAttribute="userName" action="<%= actionMethodURL.toString() %>"  >
    <form:input path="name"></form:input>
    <input type="submit" />
</form:form>

${userName.name}