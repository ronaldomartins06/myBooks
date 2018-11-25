package br.com.ronaldo.onlineBook.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.ronaldo.onlineBook.models.Author;

@FacesConverter("authorConverter")
public class AuthorConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String id) {
		
		if(id == null || id.trim().isEmpty() )
		return null;
		
		Author author = new Author();
		author.setId(Integer.valueOf(id));
		
		return author;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object authorObject) {
		
		if( authorObject == null )
			return null;
		
		Author author = (Author) authorObject;
		return author.getId().toString();
	}

}
