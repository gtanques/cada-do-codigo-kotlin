package casadocodigo.br.com.enderecos

import javax.persistence.Embeddable

@Embeddable
class Endereco(
    enderecoResponse: EnderecoResponse,
    var numero: String
) {
    val rua = enderecoResponse.logradouro
    val cidade = enderecoResponse.localidade
    val estado = enderecoResponse.uf
}
