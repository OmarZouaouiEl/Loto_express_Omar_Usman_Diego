package bet365_clases

data class Apuesta(val numerosApostados: List<Int>, val oficina: String, var esGanadora: Boolean = false, var premio: Int = 0)
