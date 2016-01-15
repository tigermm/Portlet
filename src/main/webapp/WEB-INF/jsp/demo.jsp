<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<portlet:renderURL var="editURL">
    <portlet:param name="action" value="goSmt"/>
</portlet:renderURL>

<portlet:resourceURL escapeXml="false" id="doSomeAjax" var="doSomeAjax" />

This is our test portlet.<br/>
Message: ${message1}
${someData}
<div id="<portlet:namespace />main" ng-controller="MainCtrl">
    <label>Milk: {{milk}}</label>
    <label>Sugar: {{sugar}}</label>
    <label>{{sum}}</label>
    <input type="button" value="sum" ng-click="doSum('${findState}')">
</div>
<aui:script>
    bootstrap('<portlet:namespace />main', '<portlet:namespace />');
</aui:script>

<a href="${editURL}">Go to</a>
