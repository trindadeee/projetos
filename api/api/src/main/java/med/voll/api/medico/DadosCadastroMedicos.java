package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedicos(
		
		
		@NotBlank // esta anotacao o campo nao pode estar vazio. Só pro campo string.
		String nome, 
		
		@NotBlank
		@Email // como o email é um campo especifico esta anotacao serve para que a validacao seja feito pro email
		String email, 
		
		@NotBlank
		String telefone,
		
		@NotBlank
		@Pattern(regexp = "\\d{4,6}") // o d é pra dizer que sao digitos e os numeros pra dizer que é entre 4 a 6.
		String crm, // o patern significa que ele segue um padrão.
		
		@NotNull
		Especialidade especialidade, // como é enum o proprio spring valida por isso nao precisa validar.
		
		@NotNull
		@Valid
		DadosEndereco endereco) {

	
}
