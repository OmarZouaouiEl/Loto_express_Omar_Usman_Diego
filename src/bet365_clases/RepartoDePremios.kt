class RepartoPremios {
    // Métodos para calcular y repartir premios
    fun calcularPremios(sorteo: Sorteo, recaudacionTotal: Int): Map<Int, Int> {
        // Lógica para calcular los premios para cada categoría
        val premios = mutableMapOf<Int, Int>()
        premios[1] = maxOf((recaudacionTotal * 0.4).toInt(), 1000)
        premios[2] = maxOf((recaudacionTotal * 0.2).toInt(), 100)
        premios[3] = (recaudacionTotal * 0.1).toInt()
        premios[4] = (recaudacionTotal * 0.05).toInt()
        premios[5] = (recaudacionTotal * 0.01).toInt()
        return premios
    }

    fun repartirPremios(premios: Map<Int, Int>) {
        // Lógica para repartir los premios
        println("Repartiendo premios:")
        premios.forEach { (categoria, monto) ->
            println("Categoría $categoria: $monto €")
            // Aquí se puede implementar la lógica para entregar los premios
        }
    }
}
