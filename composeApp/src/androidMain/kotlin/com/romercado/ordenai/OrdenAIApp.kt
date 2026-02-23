package com.romercado.ordenai

import android.app.Application
import com.romercado.ordenai.di.initKoin

class OrdenAIApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}