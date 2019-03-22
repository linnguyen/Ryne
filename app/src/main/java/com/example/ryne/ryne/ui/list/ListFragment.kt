package com.example.ryne.ryne.ui.list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.ryne.ryne.R
import com.example.ryne.ryne.di.component.DaggerFragmentComponent
import com.example.ryne.ryne.di.module.FragmentModule
import com.example.ryne.ryne.models.DetailsViewModel
import com.example.ryne.ryne.models.Post
import com.example.ryne.ryne.util.Utils
import javax.inject.Inject

class ListFragment : Fragment(), ListContract.View {

    @Inject
    lateinit var presenter: ListContract.Prensenter

    private lateinit var rootView: View

    fun newInstance(): ListFragment {
        return ListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater!!.inflate(R.layout.fragment_list, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        presenter.subscribe()
        initView()
    }

    override fun showProgress(show: Boolean) {

    }

    override fun showErrorMessage(error: String) {

    }

    override fun loadDataSuccess(list: List<Post>) {
        Utils.showToast(this.context!!, "Success")
    }

    override fun loadDataAllSuccess(model: DetailsViewModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun injectDependency() {
//        val listComponent = Dagge.builder()
//            .fragmentModule(FragmentModule())
//            .build()
        val listComponent = DaggerFragmentComponent.builder()
            .fragmentModule(FragmentModule())
            .build()

        listComponent.inject(this)
    }

    private fun initView() {
        presenter.loadData()
    }

    companion object {
        val TAG: String = "ListFragment"
    }
}