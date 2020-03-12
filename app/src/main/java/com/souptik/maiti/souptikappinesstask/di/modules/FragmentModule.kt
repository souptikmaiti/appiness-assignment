package com.souptik.maiti.souptikappinesstask.di.modules

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.souptik.maiti.souptikappinesstask.data.repository.ItemRepository
import com.souptik.maiti.souptikappinesstask.ui.base.BaseFragment
import com.souptik.maiti.souptikappinesstask.ui.home.HomeViewModel
import com.souptik.maiti.souptikappinesstask.ui.home.ItemAdapter
import com.souptik.maiti.souptikappinesstask.utils.RxSchedulerProviders
import com.souptik.maiti.souptikappinesstask.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class FragmentModule(private val fragment: BaseFragment<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(fragment.context)

    @Provides
    fun provideHomeViewModel(
        schedulerProvider: RxSchedulerProviders,
        compositeDisposable: CompositeDisposable,
        itemRepository: ItemRepository
    ): HomeViewModel =
        ViewModelProviders.of(fragment,
            ViewModelProviderFactory(HomeViewModel::class) {
                HomeViewModel(schedulerProvider, compositeDisposable, itemRepository)
            }
        ).get(HomeViewModel::class.java)

    @Provides
    fun provideItemAdapter() = ItemAdapter(ArrayList())

}