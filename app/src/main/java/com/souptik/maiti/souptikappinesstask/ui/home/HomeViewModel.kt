package com.souptik.maiti.souptikappinesstask.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.souptik.maiti.souptikappinesstask.data.remote.response.ItemResponse
import com.souptik.maiti.souptikappinesstask.data.repository.ItemRepository
import com.souptik.maiti.souptikappinesstask.ui.base.BaseViewModel
import com.souptik.maiti.souptikappinesstask.utils.RxSchedulerProviders
import io.reactivex.disposables.CompositeDisposable

class HomeViewModel(schedulerProvider: RxSchedulerProviders,
                    compositeDisposable: CompositeDisposable,
                    private val itemRepository: ItemRepository)
    :BaseViewModel(schedulerProvider, compositeDisposable){

    val itemList: LiveData<List<ItemResponse>>
        get() = _itemList

    val error: LiveData<String>
        get() = _error

    private val _itemList: MutableLiveData<List<ItemResponse>> = MutableLiveData()
    private val _error: MutableLiveData<String> = MutableLiveData()

    override fun onCreate(){
        compositeDisposable.addAll(
            itemRepository.getData()
            .subscribeOn(schedulerProvider.io())
            .subscribe(
                {
                    _itemList.postValue(it)
                },
                {
                    _error.postValue(it.message.toString())
                }
            )
        )
    }
}