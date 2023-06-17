package br.com.alura.mvc.mudiatualizado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudiatualizado.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mudiatualizado.model.Pedido;
import br.com.alura.mvc.mudiatualizado.repository.PedidoRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicao) {
		return "pedido/formulario";
	}
	//Usando o valid para o spring validar, e colocando BindingResult para que tendo erro no preenchimento do 
	//formulario volte para a página de pedido/formulario.
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
		
		if(result.hasErrors()) {
			return "pedido/formulario";
		}
		Pedido pedido = requisicao.toPedido();
		
		pedidoRepository.save(pedido);
		return "redirect:/home";
	}
}
