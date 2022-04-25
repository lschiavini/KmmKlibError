package com.example.shared_core

import co.touchlab.stately.collections.IsoMutableList
import co.touchlab.stately.isolate.IsolateState


data class AppContainerState(
    var array: IntArray = IntArray(10000),
)



open class AsynchronousAccessStately {

    val cacheMap = IsolateState { mutableMapOf<String, SomeData>() }

    fun doStuff() {
        cacheMap.access {map ->
            map.put("Hello", SomeData("World"))
        }
    }

    fun readStuff() {
        val sd = cacheMap.access { it.get("Hello") }
//        println("sd: $sd, isFrozen: ${sd.isFrozen()}")
        println("sd: $sd, isFrozen: ${sd}")
    }


    fun atomicOperations() {
        var state = cacheMap
        state.access { map ->
            map.put("i ${map.size}", SomeData("data ${map.size}"))
        }
    }



//    var array = IsoMutableList<Int>()


//    IntArray(size)
//    var posCurrent = 0


//    fun getResult() : Int {
//        var total: Int = 0
//        for ( i in (array as IsoMutableList<Int>)) {
//            total =+ i
//        }
//        return total
//    }

//    fun getData(): Int  {
//        return this.array.access { it.first() }
//    }

//
//    fun setData(value: Int) {
//      this.array.access { it.add(value)}
//    }

//    override fun toString() : String {
//        return "Total: "+this.getResult()
//    }
//
//    companion object  {
//        fun getTotal() : String {
//            return "teste de método estático"
//        }
//    }

}
