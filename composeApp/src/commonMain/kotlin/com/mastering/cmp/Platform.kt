package com.mastering.cmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform