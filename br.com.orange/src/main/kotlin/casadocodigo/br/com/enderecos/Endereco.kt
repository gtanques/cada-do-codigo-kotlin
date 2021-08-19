package casadocodigo.br.com.enderecos

import javax.persistence.Embeddable

@Embeddable
data class Endereco(
    var numero: String,
    val rua: String,
    val cidade: String,
    val estado: String
) {

    constructor(enderecoResponse: EnderecoResponse, numero: String) : this(
        rua = enderecoResponse.logradouro,
        cidade = enderecoResponse.localidade,
        estado = enderecoResponse.uf,
        numero = numero
    )

}
