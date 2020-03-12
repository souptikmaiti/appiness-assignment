package com.souptik.maiti.souptikappinesstask.ui.home

import com.souptik.maiti.souptikappinesstask.data.repository.ItemRepository
import com.souptik.maiti.souptikappinesstask.ui.base.BaseViewModel
import com.souptik.maiti.souptikappinesstask.utils.RxSchedulerProviders
import io.reactivex.disposables.CompositeDisposable

class MainViewModel (schedulerProvider: RxSchedulerProviders,
                     compositeDisposable: CompositeDisposable,
                     private val itemRepository: ItemRepository)
    :BaseViewModel(schedulerProvider, compositeDisposable) {
    override fun onCreate() {

    }
}