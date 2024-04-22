import kotlin.random.Random

class Sorteo {
    private val numerosSorteados = mutableListOf<Int>()
    private var complementario = 0

    init {
        realizarSorteo()
    }

    // Método para realizar un sorteo único
    private fun realizarSorteo() {
        numerosSorteados.clear()
        while (numerosSorteados.size < 6) {
            val numeroAleatorio = (1..49).random()
            if (numeroAleatorio !in numerosSorteados) {
                numerosSorteados.add(numeroAleatorio)
            }
        }
        complementario = (1..49).random()
        while (complementario in numerosSorteados) {
            complementario = (1..49).random()
        }
        numerosSorteados.sort()
    }

    // Método para realizar múltiples sorteos
    fun realizarSorteos(numSorteos: Int) {
        for (i in 1..numSorteos) {
            realizarSorteo()
            // Lógica adicional si es necesario
        }
    }

    // Método para reiniciar el estado del sorteo
    fun reiniciarSorteo() {
        numerosSorteados.clear()
        complementario = 0
    }

    // Método para obtener los números sorteados
    fun obtenerNumerosSorteados(): List<Int> {
        return numerosSorteados.toList()
    }

    // Método para obtener el número complementario
    fun obtenerComplementario(): Int {
        return complementario
    }
}
