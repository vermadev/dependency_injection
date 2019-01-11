package com.triarc.tutorial.android.dependencyinjection.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Devanshu Verma on 11/1/19
 */
@Module
class ApplicationContextModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application

    @Provides
    @Singleton
    fun provideApplicationApplication(): Application = application
}
