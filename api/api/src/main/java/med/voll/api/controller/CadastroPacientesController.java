package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.paciente.DadosCadastroPacientes;
import med.voll.api.paciente.DadosListagemPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.atualizarDadosPaciente;
import med.voll.api.repository.pacienteRepository;

@RestController
@RequestMapping("pacientes")
public class CadastroPacientesController {

	@Autowired
	private pacienteRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastroPacientes(@RequestBody @Valid DadosCadastroPacientes dados) {
		repository.save(new Paciente(dados));
	}
	
	@GetMapping
	public Page<DadosListagemPaciente> listarPacientes(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemPaciente :: new);
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid atualizarDadosPaciente dados) {
		
		var paciente = repository.getReferenceById(dados.id());
		paciente.atualizarInformacoes(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluirPaciente(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
