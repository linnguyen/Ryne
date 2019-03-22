package com.example.ryne.ryne.di.module

import android.app.Application
import com.example.ryne.ryne.BaseApp
import com.example.ryne.ryne.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return baseApp
    }
}