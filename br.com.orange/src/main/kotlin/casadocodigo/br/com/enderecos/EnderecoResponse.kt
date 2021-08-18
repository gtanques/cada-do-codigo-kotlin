package casadocodigo.br.com.enderecos

import io.micronaut.core.annotation.Introspected

@Introspected
data class EnderecoResponse(
    val logradouro: String,
    val localidade: String,
    val uf: String
)


