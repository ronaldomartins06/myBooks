package br.com.ronaldo.onlineBook.config;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

public class FacesContextProduces {

	@RequestScoped
	@Produces
	public FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}
}
