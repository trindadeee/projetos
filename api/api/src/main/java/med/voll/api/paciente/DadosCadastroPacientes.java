package med.voll.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroPacientes(
		
		@NotBlank
		String nome, 
		
		@Email
		String email, 
		
		@NotBlank
		String telefone, 
		
		@NotBlank
		@Pattern(regexp = "\\d{11,15}")
		String cpf, 
		
		@NotNull
		@Valid
		DadosEndereco endereco) {

}
