package com.example.ryne.ryne.di.module

import android.app.Activity
import com.example.ryne.ryne.ui.main.MainContract
import com.example.ryne.ryne.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): MainContract.Prensenter {
        return MainPresenter()
    }
}