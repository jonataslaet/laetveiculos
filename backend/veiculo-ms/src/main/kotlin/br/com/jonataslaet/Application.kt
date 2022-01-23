package br.com.jonataslaet

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("br.com.jonataslaet")
		.start()
}

