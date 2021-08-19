package casadocodigo.br.com.validacoes

import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.transaction.Transactional
import javax.validation.Constraint
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import javax.validation.Payload
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.CONSTRUCTOR
import kotlin.annotation.AnnotationTarget.FIELD
import kotlin.reflect.KClass

@MustBeDocumented
@Target(FIELD, CONSTRUCTOR)
@Retention(RUNTIME)
@Constraint(validatedBy = [EmailUnicoValidator::class])
annotation class EmailUnico(
    val message: String = "Email já utilizado.",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = []
)

@Singleton
open class EmailUnicoValidator(private val entityManager: EntityManager) : ConstraintValidator<EmailUnico, String> {

    @Transactional
    override fun isValid(
        value: String?,
        context: ConstraintValidatorContext?
    ): Boolean {
        val criaQuery = entityManager.createQuery("select 1 from Autor a where a.email=:email")
        criaQuery.setParameter("email", value)
        val existeEmail = criaQuery.resultList
        return existeEmail.isEmpty()
    }

}