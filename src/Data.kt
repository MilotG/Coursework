

fun main() {
    var ok  = AllTasks()
    print(ok.currentActiveTasks)
}

class AllTeams {
    var currentActiveTeams = ArrayList<String>()
}


class AllTasks {
    var currentActiveTasks: ArrayList<TaskKotlin>  = ArrayList<TaskKotlin>()
    //var currentActiveTasks = ArrayList<String>()
}

data class TaskKotlin(var name: String, var team: TeamKotlin, var predecessor: String, var duration: String) {

}

data class TeamKotlin(var name: String){

}
