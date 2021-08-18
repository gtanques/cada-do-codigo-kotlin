package casadocodigo.br.com.autores

import casadocodigo.br.com.enderecos.Endereco
import java.time.LocalDateTime
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Autor(
    val nome: String,
    val email: String,
    val idade: Int,
    var descricao: String,
    @field:Embedded val endereco: Endereco
){
    @Id
    @GeneratedValue
    var id : Long? = null

    private val criadoEm: LocalDateTime = LocalDateTime.now()
}




