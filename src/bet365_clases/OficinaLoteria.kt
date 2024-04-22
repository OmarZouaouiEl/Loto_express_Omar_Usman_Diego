import kotlin.concurrent.thread

class OficinaLoteria(val nombre: String) {
    var recaptacionTotal = 0
        private set

    // Genera una apuesta aleatoria y retorna la lista de números
    fun generarApuestaAleatoria(): List<Int> {
        val apuesta = mutableListOf<Int>()
        repeat(6) {
            val numeroAleatorio = (1..49).random()
            apuesta.add(numeroAleatorio)
        }
        return apuesta
    }

    // Genera un intervalo de tiempo aleatorio para simular la realización de una nueva apuesta
    fun generarIntervaloAleatorio(): Long {
        return (200..2000).random().toLong()
    }

    // Simula la apertura continua de la oficina y la realización de apuestas aleatorias
    fun abrirNuevaOficina() {
        thread {
            while (true) {
                val intervalo = generarIntervaloAleatorio()
                Thread.sleep(intervalo)
                val nuevaApuesta = generarApuestaAleatoria()
                recaptacionTotal += 1 // Se cobra 1€ por cada apuesta
                println("Nueva apuesta en $nombre: $nuevaApuesta")
            }
        }
    }
}