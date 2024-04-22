import kotlin.concurrent.thread

class LotoExpress {
    private val sorteos = mutableListOf<Sorteo>()
    private val oficinas = mutableListOf<OficinaLoteria>()

    // Inicia los sorteos de forma periódica
    fun iniciarSorteos() {
        thread {
            while (true) {
                realizarSorteo()
                Thread.sleep(300000) // Sorteo cada 5 minutos
            }
        }
    }

    // Agrega una nueva oficina a la LotoExpress
    fun agregarOficina(oficina: OficinaLoteria) {
        oficinas.add(oficina)
    }

    // Realiza un sorteo, valida las apuestas de las oficinas y calcula los premios
     fun realizarSorteo() {
        val sorteo = Sorteo()
        sorteo.realizarSorteo()
        sorteos.add(sorteo)
        val apuestasGanadoras = validarApuestas(sorteo)
        calcularPremios(apuestasGanadoras)
    }

    // Valida las apuestas de todas las oficinas contra el sorteo actual
    private fun validarApuestas(sorteo: Sorteo): Map<List<Int>, Int> {
        val apuestasGanadoras = mutableMapOf<List<Int>, Int>()
        oficinas.forEach { oficina ->
            val apuesta = oficina.generarApuestaAleatoria()
            val categoria = sorteo.validarApuesta(apuesta)
            if (categoria <= 5) { // Solo se consideran premiadas las apuestas con categoría de 1 a 5
                apuestasGanadoras[apuesta] = categoria
            }
        }
        return apuestasGanadoras
    }

    // Calcula los premios y muestra los resultados
    private fun calcularPremios(apuestasGanadoras: Map<List<Int>, Int>) {
        val recaudacionTotal = oficinas.sumBy { it.recaptacionTotal }
        val premios = mutableMapOf<Int, Int>()
        premios[1] = maxOf((recaudacionTotal * 0.4).toInt(), 1000)
        premios[2] = maxOf((recaudacionTotal * 0.2).toInt(), 100)
        premios[3] = (recaudacionTotal * 0.1).toInt()
        premios[4] = (recaudacionTotal * 0.05).toInt()
        premios[5] = (recaudacionTotal * 0.01).toInt()

        println("Resultados del último sorteo:")
        apuestasGanadoras.forEach { (apuesta, categoria) ->
            val premio = premios[categoria] ?: 0
            println("Apuesta ganadora: $apuesta, Categoría: $categoria, Premio: $premio €")
        }

        // Mostrar escrutinio del último sorteo
        println("Escrutinio del último sorteo:")
        for (categoria in 1..5) {
            val cantidadGanadores = apuestasGanadoras.count { it.value == categoria }
            println("Categoría $categoria: $cantidadGanadores acertantes")
        }

        // Identificar oficinas con la apuesta ganadora de mayor categoría
        val mayorCategoria = apuestasGanadoras.values.maxOrNull() ?: 0
        val oficinasGanadoras = apuestasGanadoras.filter { it.value == mayorCategoria }
        println("Oficinas con la apuesta ganadora de mayor categoría:")
        oficinasGanadoras.keys.forEach { apuesta ->
            val nombreOficina = oficinas.find { it.generarApuestaAleatoria() == apuesta }?.nombre ?: "Desconocida"
            println("Oficina: $nombreOficina")
        }

        // Mostrar recaudación total y total de premios repartidos
        println("Recaudación total: $recaudacionTotal €")
        println("Total de premios repartidos: ${premios.values.sum()} €")
    }
}