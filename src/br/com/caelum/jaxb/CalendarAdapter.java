package br.com.caelum.jaxb;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CalendarAdapter extends XmlAdapter<String, Calendar> {

	private DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

	public String marshal(Calendar valor) throws Exception {
		String result = formatador.format(valor.getTime());
		return result;
	}

	public Calendar unmarshal(String valor) throws Exception {
		Date data = formatador.parse(valor);
		Calendar result = Calendar.getInstance();
		result.setTime(data);
		return result;
	}

}
