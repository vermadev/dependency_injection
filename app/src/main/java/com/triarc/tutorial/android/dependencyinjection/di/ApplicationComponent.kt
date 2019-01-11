package com.triarc.tutorial.android.dependencyinjection.di

import com.triarc.tutorial.android.dependencyinjection.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Devanshu Verma on 11/1/19
 */
@Singleton
@Component(modules = [ApplicationContextModule::class])
interface ApplicationComponent {

    fun inject(target: MainActivity)
}
