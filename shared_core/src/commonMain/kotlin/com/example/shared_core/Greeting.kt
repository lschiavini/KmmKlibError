package com.example.shared_core

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}