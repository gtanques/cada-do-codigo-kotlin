package casadocodigo.br.com

import io.micronaut.runtime.Micronaut.build

fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("casadocodigo.br.com")
		.start()
}

