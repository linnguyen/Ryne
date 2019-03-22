package com.example.ryne.ryne.ui.list

import com.example.ryne.ryne.models.DetailsViewModel
import com.example.ryne.ryne.models.Post
import com.example.ryne.ryne.ui.base.BaseContract

class ListContract {
    interface View : BaseContract.View {
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun loadDataSuccess(list: List<Post>)
        fun loadDataAllSuccess(model: DetailsViewModel)
    }

    interface Prensenter : BaseContract.Prensenter<View> {
        fun loadData()
        fun loadDataAll()
        fun deleteItem(item: Post)
    }
}