package br.com.caelum.garbage.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.caelum.garbage.models.Transacao;

@Controller
@RequestMapping("/transacoes")
public class TransacoesController {

	private static final String PAGINA_TRANSACOES = "transacoes";

	@GetMapping
	public String form() {
		return PAGINA_TRANSACOES;
	}
	
	@PostMapping
	public String upload(MultipartFile arquivo, Model model) throws Exception {
		XStream xs = new XStream(new DomDriver());
		xs.alias("transacao", Transacao.class);

		List<Transacao> transacoes = (List<Transacao>) xs.fromXML(arquivo.getInputStream());
		model.addAttribute("qtdTransacoes", transacoes.size());
		
		return PAGINA_TRANSACOES;
	}
	
}
