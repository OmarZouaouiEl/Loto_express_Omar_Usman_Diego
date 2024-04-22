fun main() {
    val lotoExpress = LotoExpress()

    val oficina1 = OficinaLoteria("Oficina 1")
    val oficina2 = OficinaLoteria("Oficina 2")

    lotoExpress.agregarOficina(oficina1)
    lotoExpress.agregarOficina(oficina2)

    lotoExpress.iniciarSorteos()
    oficina1.abrirNuevaOficina()
    oficina2.abrirNuevaOficina()

    // Mantener el programa en ejecución
    Thread.sleep(Long.MAX_VALUE)
}