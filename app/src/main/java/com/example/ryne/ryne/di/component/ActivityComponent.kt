package com.example.ryne.ryne.di.component

import com.example.ryne.ryne.di.module.ActivityModule
import com.example.ryne.ryne.ui.main.MainActivity
import dagger.Component

@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}