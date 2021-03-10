package com.emedinaa.kotlinapp

import android.app.Application
import com.emedinaa.kotlinapp.di.Injector

/**
 * @author Eduardo Medina
 */
class ProductApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.setup(this)
    }
}