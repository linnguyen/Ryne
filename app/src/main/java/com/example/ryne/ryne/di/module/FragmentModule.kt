package com.example.ryne.ryne.di.module

import com.example.ryne.ryne.ui.list.ListContract
import com.example.ryne.ryne.ui.list.ListPresenter
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {
    @Provides
    fun provideListPresenter(): ListContract.Prensenter {
        return ListPresenter()
    }
}