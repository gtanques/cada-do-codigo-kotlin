package casadocodigo.br.com.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import javax.transaction.Transactional

@Controller("/autores")
class BuscarDetalheAutorController(val autorRepository: AutorRepository) {

    @Get
    @Transactional
    fun listarAutores(@QueryValue(defaultValue = "") email: String): HttpResponse<Any> {
        if(email.isBlank()){
            val autores = autorRepository.findAll()
            val resposta = autores.map { autor -> DetalheAutorResponse(autor) }

            return HttpResponse.ok(resposta)
        }

        val possivelAutor = autorRepository.buscarPorEmail(email)

        if (possivelAutor.isEmpty){
            return HttpResponse.notFound()
        }

        val autor = possivelAutor.get()

        return HttpResponse.ok(DetalheAutorResponse(autor))
    }


}