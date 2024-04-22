class Escrutinio {
    private val sorteosRealizados = mutableListOf<Sorteo>()

    // Método para calcular aciertos, categorías y mostrar escrutinio
    fun calcularEscrutinio(apuestasCategorias: Map<OficinaLoteria, Int>, recaudacionTotal: Int) {
        // Lógica para calcular el escrutinio
        val categorias = mutableMapOf<Int, Int>()
        val oficinasGanadoras = mutableListOf<String>()

        // Calcular categorías y acumular la recaptación por categoría
        for ((oficina, categoria) in apuestasCategorias) {
            categorias[categoria] = categorias.getOrDefault(categoria, 0) + 1
        }

        // Encontrar las oficinas ganadoras
        val maxCategoria = categorias.maxByOrNull { it.key }?.key ?: -1
        for ((oficina, categoria) in apuestasCategorias) {
            if (categoria == maxCategoria) {
                oficinasGanadoras.add(oficina.nombre)
            }
        }

        // Mostrar resultados
        println("Escrutinio del último sorteo:")
        categorias.forEach { (categoria, cantidad) ->
            println("Categoría $categoria: $cantidad acertantes")
        }
        println("Oficinas ganadoras: $oficinasGanadoras")
        println("Recaptación total: $recaudacionTotal €")
    }

    // Métodos adicionales según sea necesario
}
