package com.example.ryne.ryne.di.component

import com.example.ryne.ryne.di.module.FragmentModule
import com.example.ryne.ryne.ui.list.ListFragment
import dagger.Component

@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

    fun inject(listFragment: ListFragment)
}