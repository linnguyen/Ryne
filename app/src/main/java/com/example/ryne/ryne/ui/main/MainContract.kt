package com.example.ryne.ryne.ui.main

import com.example.ryne.ryne.ui.base.BaseContract

class MainContract {
    interface View : BaseContract.View {
        fun showAboutFragment()
        fun showListFragment()
    }

    interface Prensenter : BaseContract.Prensenter<View> {
        fun  onDrawerOptionAboutClick()
    }
}