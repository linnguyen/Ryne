package com.example.ryne.ryne.di.component

import android.app.Application
import com.example.ryne.ryne.di.module.ApplicationModule
import dagger.Component

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: Application)

}