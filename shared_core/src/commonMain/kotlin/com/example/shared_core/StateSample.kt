package com.example.shared_core

import co.touchlab.stately.isolate.IsolateState

object StateSample {
    val cacheMap = IsolateState { mutableMapOf<String, SomeData>() }
}

data class SomeData(val s: String)

