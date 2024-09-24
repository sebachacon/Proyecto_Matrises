class Examen(var nombres: String) {
    val plantilla: CharArray = charArrayOf('a', 'c', 'b', 'a', 'd', 'b', 'b', 'c', 'a', 'a', 'b', 'd')
    val notas: FloatArray = FloatArray(4)
    val respuestas: Array<CharArray> = Array(4) { CharArray(12) }
    var contador: Int = 0

    fun leerRespuestas(respuestasEstudiante: CharArray) {
        if (contador < 4)
            respuestas[contador] = respuestasEstudiante
        contador++
    }

    fun ToString() {
        for (i in 0 until contador) {
            calculaNota(respuestas, plantilla, notas)
            val estados = estadoNota(notas)
            println("Estudiante: ${nombres[i]} Respuestas: ${respuestas[i].joinToString("")} Notas: ${notas[i]} ${estados[i]}")
        }
        val promedio = promedioGrupoo()
        println()
        println("Promedio del grupo: $promedio")
        val mejor = mayorNota()
        println("El estudiante con mayor nota es $mejor,")
    }

    fun calculaNota(respuestas: Array<CharArray>, plantilla: Array<Char>, notas: FloatArray){
        for (fila in respuestas.indices){
            var puntos = 0
            for (columna in respuestas[fila].indices){
                if (respuestas[fila][columna] == plantilla[columna]){
                    puntos++
                }
            }
            notas[fila] = (puntos/12.0f) * 100
        }
    }

    fun promedioGrupoo(): Float {
        val sumas = 0.0f
        for (i in notas.indices) {
            sumas += notas[i]
        }
        return sumas/notas.size
    }

    fun mayorNota() {
        var mayor = notas[0]
        var nombre = 0
        for (i in notas.indices) {
            if (notas[i] > mayor) {
                mayor = notas[i]
                nombre = i
            }
        }
        return nombres[nombre]
    }

    fun estadoNota() {

    }
}

fun main() {

}





