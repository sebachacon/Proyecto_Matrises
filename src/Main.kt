class Examen(var nombres: Array<String> = Array(4) {""}) {
    val plantillas: Array<Char> = arrayOf('a', 'c', 'b', 'a', 'd', 'b', 'b', 'c', 'a', 'a', 'b', 'd')
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
            calculaNotas(respuestas, plantillas, notas)
            val estados = estadoNotas(notas)
            println("Estudiante: ${nombres[i]} Respuestas: ${respuestas[i].joinToString(" ")} " +
                    "Notas: ${notas[i]} ${estados[i]}")
        }
        val promedio = promedioGrupoo()
        println()
        println("Promedio del grupo es: $promedio")
        val mejor = mayorNota()
        println("El estudiante con mayor nota es $mejor")
    }

    fun calculaNotas(respuestas: Array<CharArray>, plantilla: Array<Char>, notas: FloatArray) {
        for (fila in respuestas.indices) {
            var puntos = 0
            for (columna in respuestas[fila].indices) {
                if (respuestas[fila][columna] == plantilla[columna]) {
                    puntos++
                }
            }
            notas[fila] = (puntos*100/12.0f)
        }
    }

    fun promedioGrupoo():Float {
        val suma = notas.sum()
        return if (contador > 0) suma / contador else 0f
    }

    fun mayorNota(): String {
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

    fun estadoNotas(notas: FloatArray): Array<String> {
        val estados = Array(notas.size) { "" }
        for (i in notas.indices) {
            estados[i] = when {
                notas[i] >= 70.0f -> "Aprobado"
                notas[i] < 70.0f && notas[i] >= 60.0f -> "Aplazado"
                else -> "Reprobo"
            }
        }
        return estados
    }
}
fun main() {
    val Examen = Examen(arrayOf("Marta", "Pedro", "Juan ", "María"))
    Examen.leerRespuestas(charArrayOf('a', 'c', 'b', 'a', 'd', 'b', 'b', 'c', 'a', 'a', 'b', 'd'))
    Examen.leerRespuestas(charArrayOf('b', 'c', 'b', 'd', 'd', 'b', 'b', 'a', 'b', 'd', 'b', 'd'))
    Examen.leerRespuestas(charArrayOf('c', 'c', 'b', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'b', 'c'))
    Examen.leerRespuestas(charArrayOf('c', 'c', 'b', 'a', 'd', 'b', 'b', 'c', 'a', 'a', 'b', 'c'))
    Examen.ToString()
}




