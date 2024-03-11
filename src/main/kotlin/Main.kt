package org.example
fun main() {
    val someStation = SomeStation()
    val stationUser1 = StationUsers("Levon")
    val stationUser2 = StationUsers("Eduard")
    someStation.addStatioUser(stationUser1)
    someStation.addStatioUser(stationUser2)
    someStation.updateAlert("its urgent")
}
class SomeStation {
    private var userList: MutableList<StationUsers> = mutableListOf()
    private var alert = "its moderate"
    fun addStatioUser(stationUsers: StationUsers) {
        userList.add(stationUsers)
    }

    fun updateAlert(alert: String)
    {
        this.alert = alert
        for (o in userList){
            o.update(alert)
        }
    }
}

class StationUsers(
    private val name: String
) : Observer {
    override fun update(o: Any) {
        println("$name $o")
    }
}

interface Observer {
    fun update(o: Any)
}