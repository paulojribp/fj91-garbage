package br.com.caelum.garbage.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import br.com.caelum.garbage.models.Transacao;
import br.com.caelum.garbage.services.TransacoesReader;

@Controller
@RequestMapping("/transacoes")
public class TransacoesController {

	private static final String PAGINA_TRANSACOES = "transacoes";
	
	private final TransacoesReader reader;
	
	public TransacoesController(TransacoesReader reader) {
		this.reader = reader;
	}

	@GetMapping
	public String form() {
		return PAGINA_TRANSACOES;
	}
	
	@PostMapping
	public String upload(MultipartFile arquivo, Model model) throws Exception {
		List<Transacao> transacoes = reader.readFrom(arquivo.getInputStream());
		model.addAttribute("qtdTransacoes", transacoes.size());
		
		return PAGINA_TRANSACOES;
	}
	
}
