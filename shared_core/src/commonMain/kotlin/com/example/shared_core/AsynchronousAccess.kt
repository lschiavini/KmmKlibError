package com.example.shared_core

//import kotlin.native.concurrent.ThreadLocal
//import kotlin.native.concurrent.SharedImmutable
//
//
//@SharedImmutable
//@ThreadLocal
open class AsynchronousAccess(var size: Int) {
    var array: IntArray = IntArray(size)
    var posCurrent = 0


    fun getResult() : Int {
        var total = 0
        for ( i in array) {
            total =+ i
        }
        return total
    }

    fun getData() : IntArray {
        return this.array
    }


    fun setData(value: Int) {
        this.array.set(this.posCurrent, value)
        this.posCurrent++
    }

    override fun toString() : String {
        return "Total: "+this.getResult()
    }

    companion object  {
        fun getTotal() : String {
            return "teste de método estático"
        }
    }

}