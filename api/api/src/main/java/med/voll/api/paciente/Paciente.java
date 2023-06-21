package med.voll.api.paciente;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "Pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;

	@Embedded
	private Endereco endereco;

	public Paciente(DadosCadastroPacientes dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.cpf = dados.cpf();
		this.endereco = new Endereco(dados.endereco());
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void atualizarInformacoes(@Valid  atualizarDadosPaciente dados) {
		
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}

		if (dados.telefone() != null) {
			this.telefone = dados.telefone();
		}

		if (dados.endereco() != null) {
			this.endereco.atualizarInformacoes(dados.endereco());
		}
	
	}

}
