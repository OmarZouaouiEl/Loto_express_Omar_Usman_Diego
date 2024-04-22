import kotlin.concurrent.thread

class OficinaLoteria(val nombre: String) {
    private var recaptacionTotal = 0

    // Método para generar apuestas y llevar registro de la recaptación
    fun generarApuestas() {
        thread {
            while (true) {
                val tiempoAleatorio = (200..2000).random().toLong()
                Thread.sleep(tiempoAleatorio)
                recaptacionTotal += 1
            }
        }
    }

    // Método para obtener la recaptación total
    fun obtenerRecaptacionTotal(): Int {
        return recaptacionTotal
    }
}
