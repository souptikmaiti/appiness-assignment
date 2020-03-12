package com.souptik.maiti.souptikappinesstask.data.remote

import com.souptik.maiti.souptikappinesstask.data.remote.response.ItemResponse
import io.reactivex.Single
import retrofit2.http.GET

interface NetworkService {

    @GET(EndPoints.ITEMS)
    fun getItemList(): Single<List<ItemResponse>>
}