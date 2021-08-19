package casadocodigo.br.com.autores

import casadocodigo.br.com.enderecos.Endereco
import casadocodigo.br.com.enderecos.EnderecoResponse
import casadocodigo.br.com.validacoes.EmailUnico
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.*

@Introspected
data class NovoAutorRequest(@field:NotNull @field:NotBlank val nome: String,
                            @field:EmailUnico @field:NotNull @field:NotBlank @field:Email val email: String,
                            @field:Positive val idade: Int,
                            @field:NotNull @field:NotBlank @field:Size(max = 400) val descricao: String,
                            @field:NotNull @field:NotBlank val cep : String,
                            @field:NotNull @field:NotBlank val numero: String){
    fun paraAutor(enderecoResponse : EnderecoResponse) : Autor{
        val endereco = Endereco(enderecoResponse, numero)
        return Autor(nome, email, idade, descricao, endereco)
    }
}
