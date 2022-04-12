package com.example.shared_core

import kotlin.native.concurrent.freeze

//import co.touchlab.stately.freeze

fun AsynchronousAccess.toFreeze(): AsynchronousAccess {
    val previous = this
    return previous.freeze()
}