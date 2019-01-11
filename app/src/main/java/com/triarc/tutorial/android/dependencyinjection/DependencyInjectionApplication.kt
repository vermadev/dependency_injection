package com.triarc.tutorial.android.dependencyinjection

import android.app.Application
import com.triarc.tutorial.android.dependencyinjection.di.ApplicationComponent
import com.triarc.tutorial.android.dependencyinjection.di.ApplicationContextModule
import com.triarc.tutorial.android.dependencyinjection.di.DaggerApplicationComponent

/**
 * Created by Devanshu Verma on 11/1/19
 */
class DependencyInjectionApplication: Application() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationContextModule(ApplicationContextModule(this))
            .build()
    }

    fun getApplicationComponent() = applicationComponent
}
