import kotlin.random.Random
import java.io.File

fun generar (longitud: Int):MutableMap<Int, Int> {

    var mapa= mutableMapOf<Int, Int> ()
    for (i in 0 until longitud) {
        mapa[i]=Random.nextInt(0, 5)
    }
    return mapa
}

fun main() {
    val file = File("src/mifichero.txt")
    val contenido = file.readText()

    println("1. Jugar")
    println("2. Ver traza de último intento")
    println("3. Salir")
    print("opción:")

    var eleccion= readlnOrNull()

    while (eleccion!=null) {

        //Eleccion 1: Generar Numero aleatorio
        if (eleccion == "1") {
            var intentos=2
            for (i in 0 until intentos) {
                var num = generar(4)
                var vnum1 = num.get(0).toString()
                var vnum2 = num.get(1).toString()
                var vnum3 = num.get(2).toString()
                var vnum4 = num.get(3).toString()
                var numsec = vnum1 + vnum2 + vnum3 + vnum4
                println("teclea un numero de 4 cifras sin numeros repetidos: $numsec")
                var entrada = readln()

                if (entrada.length == 4) {
                    var contador = 0
                    for (i in 0 until 4) {
                        if (entrada[i] == numsec[i]) {
                            contador++
                        } else {
                            continue
                        }
                    }
                    print(entrada)
                    if (contador == 4) { println("SI") }
                    else { println("NO") }


                    contador.toString()
                    file.writeText("Intento $intentos: Numero secreto $numsec, Aciertos: $contador, Coincidencias: ")
                } else {
                    println("La entrada que has introducido es invalida")
                }
            }
            print("opción: ")
            eleccion = readln()
        }

        //Eleccion 2: Generar Lista anterior
        else if (eleccion == "2") {
            val content = File("src/mifichero.txt").readText()
            println()
            print(content)
            println()
            println()
            print("opción: ")
            eleccion= readln()
        }

        //Eleccion 3: Fin
        else if (eleccion == "3") {
            println("Gracias por jugar")
            break
        }

        //Eleccion 4: Repite
        else {
            println("numero invalido, escribe un numero del 1 al 3")
            eleccion= readln()
        }
    }
}