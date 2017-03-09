package br.com.caelum.jaxb;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class TesteMarshal {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {

		Livro livro = new Livro();
		livro.setCodigo("ARQ");
		livro.setTitulo("Arquitetura Java");
		livro.setNomeAutor("Paulo Silveira");
		livro.setValor(new BigDecimal("29.90"));

		Categoria categoria = new Categoria();
		categoria.setNome("TI");
		livro.setCategoria(categoria);

		livro.setDataLancamento(Calendar.getInstance());

		JAXBContext context = JAXBContext.newInstance(Livro.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(livro, new FileOutputStream("livro.xml"));

	}
}
