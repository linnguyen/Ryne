package com.example.ryne.ryne.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.ryne.ryne.R
import com.example.ryne.ryne.di.component.DaggerActivityComponent
import com.example.ryne.ryne.di.module.ActivityModule
import com.example.ryne.ryne.ui.list.ListFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Prensenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()

        presenter.attach(this)
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
//        DaggerAc
    }

    override fun showAboutFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showListFragment() {
        supportFragmentManager.beginTransaction()
            .disallowAddToBackStack()
            .setCustomAnimations(AnimType.FADE.getAnimPair().first, AnimType.FADE.getAnimPair().second)
            .replace(R.id.frame, ListFragment().newInstance(), ListFragment.TAG)
            .commit()
    }

    override fun onResume() {
        super.onResume()
    }

    enum class AnimType() {
        SLIDE,
        FADE;

        fun getAnimPair(): Pair<Int, Int> {
            when (this) {
                SLIDE -> return Pair(R.anim.slide_left, R.anim.slide_right)
                FADE -> return Pair(R.anim.fade_in, R.anim.fade_out)
            }
            return Pair(R.anim.slide_left, R.anim.slide_right)
        }
    }
}
