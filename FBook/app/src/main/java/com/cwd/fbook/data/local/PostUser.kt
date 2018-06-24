package com.cwd.fbook.data.local

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by tykud on 24/06/2018.
 */
class Result {

    @SerializedName("userId")
    @Expose
    var userId: String? = null
    @SerializedName("firstName")
    @Expose
    var firstName: String? = null
    @SerializedName("lastName")
    @Expose
    var lastName: String? = null
    @SerializedName("sex")
    @Expose
    var sex: String? = null
    @SerializedName("birth")
    @Expose
    var birth: String? = null
    @SerializedName("country")
    @Expose
    var country: String? = null
    @SerializedName("city")
    @Expose
    var city: String? = null

}