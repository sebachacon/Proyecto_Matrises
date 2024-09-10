class Examen(var nombre: String){
    val plantilla: CharArray = charArrayOf('a', 'c', 'b', 'a', 'd', 'b', 'b', 'c', 'a', 'a', 'b', 'd')
    val notas: FloatArray = FloatArray(4)
    val respuestas : Array<CharArray> = Array(4) {CharArray(12)}
    val respuestasdelexamen  = CharArray(12)
    val nombres: Array<String>(4){''}
    var contador: Int = 0

    fun examenn(nombre: String, respuestasdelexamen: CharArray, nota:Float){
        if (contador < 4 && respuestasdelexamen.size == 12)
            respuestasdelexamen[contador] =
        respuestas[contador] = respuestasdelexamen
        notas[contador] = nota
        contador++
    }
}