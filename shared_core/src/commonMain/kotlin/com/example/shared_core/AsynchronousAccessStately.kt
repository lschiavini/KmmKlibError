package com.example.shared_core

import co.touchlab.stately.collections.IsoMutableList
import co.touchlab.stately.isolate.IsolateState


data class AppContainerState(
    var array: IntArray = IntArray(10000),
)



open class AsynchronousAccessStately : IsolateState<AppContainerState>(producer = { AppContainerState() }){

    var index : Int = 0

    fun setData(position: Int) {
        if (index < 1000) {
            val ac = access { it.array.set(index, position) }
        }
        index ++
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