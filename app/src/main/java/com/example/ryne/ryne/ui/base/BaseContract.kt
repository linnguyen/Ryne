package com.example.ryne.ryne.ui.base

class BaseContract {
    interface Prensenter<in T> {
        fun subscribe()
        fun unsubscribe()
        fun attach(view: T)
    }

    interface View {

    }
}