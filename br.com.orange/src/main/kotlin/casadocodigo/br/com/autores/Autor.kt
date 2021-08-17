package casadocodigo.br.com.autores

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Autor(val nome: String?,
            val email: String?,
            val idade: Int?,
            var descricao: String?){
    @Id
    @GeneratedValue
    var id : Long? = null

    val criadoEm: LocalDateTime = LocalDateTime.now()
}
