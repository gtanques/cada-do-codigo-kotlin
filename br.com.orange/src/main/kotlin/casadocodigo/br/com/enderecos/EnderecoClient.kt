package casadocodigo.br.com.enderecos

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.client.annotation.Client

@Client(value = "https://viacep.com.br/ws")
interface EnderecoClient {
    @Get(value = "/{cep}/json")
    fun consulta(@PathVariable cep: String): HttpResponse<EnderecoResponse>
}