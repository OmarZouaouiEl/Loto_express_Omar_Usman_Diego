import kotlin.random.Random

fun main() {
    // Crear instancia de Sorteo
    val sorteo = Sorteo()

    // Crear instancia de Escrutinio
    val escrutinio = Escrutinio()

    // Crear instancia de RepartoPremios
    val repartoPremios = RepartoPremios()

    // Crear instancias de oficinas de lotería
    val oficina1 = OficinaLoteria("Oficina 1")
    val oficina2 = OficinaLoteria("Oficina 2")
    val oficina3 = OficinaLoteria("Oficina 3")

    // Generar apuestas en las oficinas de lotería
    oficina1.generarApuestas()
    oficina2.generarApuestas()
    oficina3.generarApuestas()

    // Simular múltiples sorteos
    sorteo.realizarSorteos(5)

    // Obtener números sorteados y complementario
    val numerosSorteados = sorteo.obtenerNumerosSorteados()
    val complementario = sorteo.obtenerComplementario()

    // Calcular aciertos y categorías por oficina
    val apuestasCategorias = mapOf(
        oficina1 to Random.nextInt(1, 7),
        oficina2 to Random.nextInt(1, 7),
        oficina3 to Random.nextInt(1, 7)
    )

    // Calcular recaudación total
    val recaudacionTotal = apuestasCategorias.values.sum()

    // Mostrar escrutinio
    escrutinio.calcularEscrutinio(apuestasCategorias, recaudacionTotal)

    // Calcular premios
    val premios = repartoPremios.calcularPremios(sorteo, recaudacionTotal)

    // Repartir premios
    repartoPremios.repartirPremios(premios)
}
