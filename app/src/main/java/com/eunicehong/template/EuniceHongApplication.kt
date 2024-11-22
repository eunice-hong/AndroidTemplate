package com.eunicehong.template

import android.app.Application
import com.eunicehong.template.core.data.repository.startup.StartupRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class EuniceHongApplication : Application() {
    @Inject
    lateinit var startupRepository: StartupRepository

    override fun onCreate() {
        super.onCreate()
        startupRepository.initialize(applicationContext)
    }
}
