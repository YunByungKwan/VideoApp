package org.ybk.videoapp.util

import android.app.Application
import org.koin.core.context.startKoin
import org.ybk.videoapp.di.appModules
import org.ybk.videoapp.di.detailVideoViewModelModule
import org.ybk.videoapp.di.mainViewModelModule

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModules)
            modules(mainViewModelModule)
            modules(detailVideoViewModelModule)
        }
    }
}