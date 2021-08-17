package casadocodigo.br.com.autores

class DetalheAutorResponse(autor : Autor){
    val nome = autor.nome
    val email = autor.email
    val descricao = autor.descricao
    val idade = autor.idade
}
