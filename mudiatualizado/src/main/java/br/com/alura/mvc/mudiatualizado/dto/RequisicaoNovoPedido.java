package br.com.alura.mvc.mudiatualizado.dto;

import br.com.alura.mvc.mudiatualizado.model.Pedido;
import br.com.alura.mvc.mudiatualizado.model.StatusPedido;
import jakarta.validation.constraints.NotBlank;

public class RequisicaoNovoPedido {

	@NotBlank(message = "O campo nome é obrigatório") // nao permite campo null e nao considera espaço em branco.
	private String nomeProduto;
	
	@NotBlank(message = "O campo url do produto é obrigatório")
	private String urlProduto;
	
	@NotBlank(message = "O campo url da imagem é obrigatório")
	private String urlImagem;
	
	private String descricao;

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getUrlProduto() {
		return urlProduto;
	}

	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setDescricao(descricao);
		pedido.setNomeProduto(nomeProduto);
		pedido.setUrlImagem(urlImagem);
		pedido.setUrlProduto(urlProduto);
		//pedido.setStatus(StatusPedido.AGUARDANDO);
		return pedido;
	}
}
