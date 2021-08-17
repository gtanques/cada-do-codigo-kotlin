package casadocodigo.br.com.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/autores")
class BuscarDetalheAutorController(val autorRepository: AutorRepository) {

    @Get
    fun listarAutores(): HttpResponse<List<DetalheAutorResponse>> {
        val autores = autorRepository.findAll()
        val resposta = autores.map { autor -> DetalheAutorResponse(autor) }

        return HttpResponse.ok(resposta)
    }

}