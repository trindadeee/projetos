package br.com.alura.mvc.mudiatualizado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudiatualizado.model.Pedido;
import br.com.alura.mvc.mudiatualizado.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	List<Pedido> findByStatus(StatusPedido aguardando);
	
}

			
	

