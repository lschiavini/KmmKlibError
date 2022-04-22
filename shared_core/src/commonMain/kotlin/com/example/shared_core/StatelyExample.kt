package com.example.shared_core

import co.touchlab.stately.isolate.IsolateState


class StatelyExample {

    companion object {
        fun doStuff() {
            StateSample.cacheMap.access {map ->
                map.put("Hello", SomeData("World"))
            }
        }

        fun readStuff() {
            val sd = StateSample.cacheMap.access { it.get("Hello") }
//        println("sd: $sd, isFrozen: ${sd.isFrozen()}")
            println("sd: $sd, isFrozen: ${sd}")
        }


        fun atomicOperations() {
            var state = StateSample.cacheMap
            state.access { map ->
                map.put("i ${map.size}", SomeData("data ${map.size}"))
            }
        }
    }
}