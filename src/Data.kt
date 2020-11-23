import java.io.*
import java.io.File
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

fun main() {
    var ok  = AllTasks()
    print(ok.currentActiveTasks)

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


class Testing() {
    fun runTest(item: TaskKotlin) {
        File("test.txt").appendText("${item.id},${item.name},${item.team},${item.predecessor},${item.duration}\n")
    }
}