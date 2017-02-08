<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@page import="javax.portlet.ActionRequest"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<portlet:defineObjects />

This is the <b>01_Hola_Mundo</b>.

<a href="<portlet:renderURL portletMode="EDIT"></portlet:renderURL>">Al DoEdit</a>
<!-- Genera una url que ejecutara el método que esta invocando -->

<!-- al darle una value de "saludar" hacemos que desde el process action se llame directamente al metodo "saludar" -->
<portlet:actionURL var="altaPersona">
	<portlet:param name="<%=ActionRequest.ACTION_NAME %>" value="altaPersona"/>
</portlet:actionURL>

<!-- Mejor usar este formulario para mandar parámetros -->
<aui:form action="${altaPersona}" method="post">
	<aui:input type="text" name="nombre" label="Nombre:"></aui:input>
	<aui:input type="number" name="edad" label="Edad:"></aui:input>
	<aui:input type="text" name="dni" label="DNI:"></aui:input>
	<aui:button type="submmit" value="Alta"></aui:button>
</aui:form>







<%= request.getAttribute("saludo") %>

