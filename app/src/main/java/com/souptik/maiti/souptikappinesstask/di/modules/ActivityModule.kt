package com.souptik.maiti.souptikappinesstask.di.modules

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.souptik.maiti.souptikappinesstask.data.repository.ItemRepository
import com.souptik.maiti.souptikappinesstask.ui.base.BaseActivity
import com.souptik.maiti.souptikappinesstask.ui.home.MainViewModel
import com.souptik.maiti.souptikappinesstask.utils.RxSchedulerProviders
import com.souptik.maiti.souptikappinesstask.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)

    @Provides
    fun provideMainViewModel(
        schedulerProvider: RxSchedulerProviders,
        compositeDisposable: CompositeDisposable,
        itemRepository: ItemRepository
    ): MainViewModel =
        ViewModelProviders.of(activity,
            ViewModelProviderFactory(MainViewModel::class) {
                MainViewModel(schedulerProvider, compositeDisposable, itemRepository)
            }
        ).get(MainViewModel::class.java)
}