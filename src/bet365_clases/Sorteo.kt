class Sorteo {
    private val numerosSorteados = mutableListOf<Int>()
    private var complementario = 0

    // Realiza un sorteo generando los números sorteados y el complementario
    fun realizarSorteo() {
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

    // Valida una apuesta y devuelve la categoría de premio
    fun validarApuesta(apuesta: List<Int>): Int {
        var aciertos = 0
        for (numero in apuesta) {
            if (numero in numerosSorteados) {
                aciertos++
            }
        }
        if (aciertos == 5 && complementario in apuesta) {
            aciertos++
        }
        return when (aciertos) {
            6 -> 1
            5 -> if (complementario in apuesta) 2 else 3
            4 -> 4
            3 -> 5
            else -> 6
        }
    }
}
