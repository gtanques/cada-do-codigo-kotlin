package casadocodigo.br.com.autores

import casadocodigo.br.com.enderecos.Endereco
import casadocodigo.br.com.enderecos.EnderecoResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
internal class BuscarDetalheAutorControllerTest {

    @field:Inject
    lateinit var autorRepository: AutorRepository

    @field:Inject
    @field:Client("/")
    lateinit var client: HttpClient

    private lateinit var autor : Autor

    @BeforeEach
    internal fun setUp() {
        val enderecoResponse = EnderecoResponse("AV. XV de Novembro", "joaçaba", "SC")
        val endereco = Endereco(enderecoResponse = enderecoResponse, numero = "100")
        autor = Autor(nome = "Hinata Hyuga", email = "hinata@gmail.com", descricao = "Ninja da Folha", idade = 18, endereco = endereco)
        autorRepository.save(autor)
    }

    @Test
    internal fun `deve retornar os detalhes de um autor`() {
        val response = client.toBlocking().exchange("/autores?email=${autor.email}", DetalheAutorResponse::class.java)

        assertEquals(HttpStatus.OK, response.status())
        assertNotNull(response.body())
        assertEquals(autor.nome, response.body()!!.nome)
        assertEquals(autor.email, response.body()!!.email)
        assertEquals(autor.descricao, response.body()!!.descricao)
        assertEquals(autor.idade, response.body()!!.idade)
    }

    @AfterEach
    internal fun tearDown() {
        autorRepository.deleteAll()
    }
}