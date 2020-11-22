import java.io.*
import java.io.File
import java.io.InputStream

fun main() {
    var ok  = AllTasks()
    var rndnmbr = RandomNumber()
    print(ok.currentActiveTasks)
    println(rndnmbr.randomNumber)
}

class AllTeams {
    var currentActiveTeams = ArrayList<String>()
}


class AllTasks {
    var currentActiveTasks = ArrayList<String>()

}

data class TaskKotlin(var id: Int?, var name: String, var team: String, var predecessor: String, var duration: String) {

}

/*
data class TeamKotlin(var name: String){

}

 */


class RandomNumber {
    val randomNumber = (0..1000).random()
}


class  Testing {


    val inputStream: InputStream = File("/Users/yunisfarah/Downloads/Coursework/src/text.txt").inputStream()
    val inputString = inputStream.bufferedReader().use { it.readText() }
    var someString: String? = null
    fun setsomeString(text: String): String? {
        someString = text
        return someString
    }
    var finalValue = File("/Users/yunisfarah/Downloads/Coursework/src/text.txt").writeText("${someString}")
}