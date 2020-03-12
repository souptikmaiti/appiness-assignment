package com.souptik.maiti.souptikappinesstask.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ItemResponse(
    @Expose
    @SerializedName("amt.pledged")
    var amt_pledged: Int,

    @Expose
    @SerializedName("blurb")
    var blurb: String,

    @Expose
    @SerializedName("by")
    var by: String,

    @Expose
    @SerializedName("country")
    var country: String,

    @Expose
    @SerializedName("currency")
    var currency: String,

    @Expose
    @SerializedName("end.time")
    var end_time: String,

    @Expose
    @SerializedName("location")
    var location: String,

    @Expose
    @SerializedName("num.backers")
    var num_backers: String,

    @Expose
    @SerializedName("percentage.funded")
    var percentage_funded: Int,

    @Expose
    @SerializedName("s.no")
    var s_no: Int,

    @Expose
    @SerializedName("state")
    var state: String,

    @Expose
    @SerializedName("title")
    var title: String,

    @Expose
    @SerializedName("type")
    var type: String,

    @Expose
    @SerializedName("url")
    var url: String
)