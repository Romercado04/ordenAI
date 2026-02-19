package com.romercado.ordenai

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform