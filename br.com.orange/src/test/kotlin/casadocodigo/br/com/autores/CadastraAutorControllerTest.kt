package casadocodigo.br.com.autores


import casadocodigo.br.com.enderecos.EnderecoClient
import casadocodigo.br.com.enderecos.EnderecoResponse

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import javax.inject.Inject

@MicronautTest
internal class CadastraAutorControllerTest {

    @field:Inject
    lateinit var enderecoClient: EnderecoClient

    @field:Inject
    lateinit var autorRepository: AutorRepository

    @field:Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @Test
    fun `deve cadastrar um novo autor`() {

        val novoAutorRequest = NovoAutorRequest(
            "naruto",
            "naruto2@gmail.com",
            18,
            "Ninja do time 7",
            "89600000",
            "100"
        )

        val enderecoResponse = EnderecoResponse("Av. XV de novembro", "Joaçaba", "SC")
        Mockito.`when`(enderecoClient.consulta(novoAutorRequest.cep)).thenReturn(HttpResponse.ok(enderecoResponse))

        val request = HttpRequest.POST("/autores", novoAutorRequest)
        val response = client.toBlocking().exchange(request, Any::class.java)

        assertEquals(HttpStatus.CREATED, response.status)
        assertTrue(response.headers.contains("Location"))
    }

    @MockBean(EnderecoClient::class)
    fun enderecoMock() : EnderecoClient {
        return Mockito.mock(EnderecoClient::class.java)
    }

//    @AfterEach
//    internal fun tearDown() {
//        autorRepository.deleteAll()
//    }
}