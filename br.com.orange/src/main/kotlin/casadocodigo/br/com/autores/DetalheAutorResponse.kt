package casadocodigo.br.com.autores

import casadocodigo.br.com.enderecos.Endereco

data class DetalheAutorResponse(
    val nome: String,
    val email: String,
    val descricao: String,
    val idade: Int,
    val endereco: Endereco
) {
    constructor(autor: Autor) : this(
        nome = autor.nome,
        email = autor.email,
        descricao = autor.descricao,
        idade = autor.idade,
        endereco = autor.endereco
    )
}
