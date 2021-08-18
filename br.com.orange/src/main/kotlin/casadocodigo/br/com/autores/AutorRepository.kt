package casadocodigo.br.com.autores

import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface AutorRepository : JpaRepository<Autor, Long> {
    fun findByEmail(email: String): Optional<Autor>

    @Query("select a from Autor a where a.email=:email")
    fun buscarPorEmail(email: String) : Optional<Autor>
}