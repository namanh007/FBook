package com.cwd.fbook.data.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-24
 *  @Description: ...
 *  All Right Reserved.
 */
data class UserApi constructor(

        @SerializedName("userId") @Expose
        val userId: String? = null,
        @SerializedName("firstName") @Expose
        val firstName: String? = null,
        @SerializedName("lastName") @Expose
        val lastName: String? = null,
        @SerializedName("sex") @Expose
        val sex: Int = 4,
        @SerializedName("birth") @Expose
        val birth: Int = 0,
        @SerializedName("country") @Expose
        var country: String? = null,
        @SerializedName("city") @Expose
        var city: String? = null,
        @SerializedName("status") @Expose
        var status: String? = null,
        @SerializedName("photoDisplay") @Expose
        val photoDisplay: String? = null
)

