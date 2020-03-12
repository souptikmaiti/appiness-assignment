package com.souptik.maiti.souptikappinesstask.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.souptik.maiti.souptikappinesstask.data.remote.NetworkService
import com.souptik.maiti.souptikappinesstask.utils.RxSchedulerProviders
import io.reactivex.disposables.CompositeDisposable
import javax.net.ssl.HttpsURLConnection

abstract class BaseViewModel (
    protected val schedulerProvider: RxSchedulerProviders,
    protected val compositeDisposable: CompositeDisposable
) : ViewModel() {

    val messageString: MutableLiveData<String> = MutableLiveData()

    abstract fun onCreate()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}