package br.com.ronaldo.onlineBook.converter;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=Calendar.class)
public class CalendarConverter implements Converter{

	
	private DateTimeConverter converter = new DateTimeConverter();
	
	public CalendarConverter() {
		converter.setPattern("dd/MM/yyyy");
		converter.setTimeZone(TimeZone.getTimeZone("IRL"));
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String dateText) {
		Date date = (Date) converter.getAsObject(context, component, dateText);
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(date);
		return  calendar;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object dateObject) {
	
		if(dateObject == null)
			return null;
		
		Calendar calendar = (Calendar) dateObject;
		return converter.getAsString(context, component, calendar.getTime());
		
	}

	
}
