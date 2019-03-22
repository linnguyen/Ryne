package com.example.ryne.ryne.ui.main

import io.reactivex.disposables.CompositeDisposable

class MainPresenter : MainContract.Prensenter {
    private val subscriptions = CompositeDisposable()
    private lateinit var view: MainContract.View

    override fun onDrawerOptionAboutClick() {
        view.showListFragment()
    }

    override fun subscribe() {
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: MainContract.View) {
        this.view = view
        view.showListFragment()
    }
}