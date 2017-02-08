<%@page import="com.digitalEmpleo.entidades.Persona" %>
<%@page language="java" contentType ="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<% Persona persona = (Persona)request.getAttribute("p"); %>

<p>La persona es : <%=persona %></p>

<portlet:renderURL var="volver"/>
<a href="${volver}">Volver</a>

<portlet:renderURL var="volver2">
	<portlet:param name="mvcPath" value="/edit.jsp"/>
</portlet:renderURL>
<a href="${volver2}">Volver a EDIT</a>
