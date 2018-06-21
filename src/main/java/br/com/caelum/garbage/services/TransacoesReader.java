package br.com.caelum.garbage.services;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.caelum.garbage.models.Transacao;

@Service
public class TransacoesReader {

	@SuppressWarnings("unchecked")
	public List<Transacao> readFrom(InputStream source) {
		XStream xs = new XStream(new DomDriver());
		XStream.setupDefaultSecurity(xs);
		xs.allowTypes(new Class[] {Transacao.class});
		xs.alias("transacao", Transacao.class);

		return (List<Transacao>) xs.fromXML(source);
	}
	
}
