package com.souptik.maiti.souptikappinesstask.data.repository

import com.souptik.maiti.souptikappinesstask.data.remote.NetworkService
import com.souptik.maiti.souptikappinesstask.data.remote.response.ItemResponse
import io.reactivex.Single
import javax.inject.Inject

class ItemRepository @Inject constructor(private val networkService: NetworkService) {

    fun getData(): Single<List<ItemResponse>>{
        return networkService.getItemList()
    }

}