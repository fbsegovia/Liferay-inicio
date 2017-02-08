package com.digitalEmpleo.portlets;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.digitalEmpleo.entidades.Persona;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class HolaMundoMVCPortlet extends MVCPortlet{

	private static final Log log = LogFactoryUtil.getLog(HolaMundoMVCPortlet.class);
	private static final String SALUDO = "Hola Mundo!!!";
	
	//Este método solo se ejecuta cuando se inicie el portlet.
	@Override
	public void init() throws PortletException {
		super.init();
	}
	
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		log.info("doview -> Entrando");
		System.out.println("doview -> Entrando");

		//Cuando solo es una sentencia la que queremos ejecutar en el if no hace falta abrir y cerra llaves.
		if(renderRequest.getAttribute("saludo") ==null)
			renderRequest.setAttribute("saludo", "");
			
		super.doView(renderRequest, renderResponse);
	}
	
	public void saludar(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String nombre = actionRequest.getParameter("nombre");
		log.info("saludar -> " + nombre);
				//ParamUtil.get(Método de llamada, "nombre del parámetro", "valor por defecto")
		nombre = ParamUtil.get(actionRequest,"nombre","");
		log.info("saludar -> " + nombre);
		actionRequest.setAttribute("saludo", SALUDO);
	}
	
	
	public void altaPersona(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String nombre = ParamUtil.get(actionRequest,"nombre","");
		String sEdad = ParamUtil.get(actionRequest,"edad","");
		int edad = Integer.parseInt(sEdad);
		String dni = ParamUtil.get(actionRequest,"dni","");
		
		Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setEdad(edad);
		persona.setDni(dni);
		actionRequest.setAttribute("p", persona);
		
		//
		actionResponse.setRenderParameter("mvcPath", "/view2.jsp");
	}
	
	
	
}
