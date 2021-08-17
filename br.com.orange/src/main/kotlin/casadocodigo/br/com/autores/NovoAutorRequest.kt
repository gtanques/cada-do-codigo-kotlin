package casadocodigo.br.com.autores

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.*

@Introspected
data class NovoAutorRequest(@field:NotNull @field:NotBlank val nome: String,
                            @field:NotNull @field:NotBlank @field:Email val email: String,
                            @field:Positive @field:NotBlank val idade: Int,
                            @field:NotNull @field:NotBlank @field:Size(max = 400) val descricao: String){
    fun paraAutor() : Autor{
        return Autor(nome, email, idade, descricao)
    }
}
