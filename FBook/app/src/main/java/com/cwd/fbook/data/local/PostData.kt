package com.cwd.fbook.data.local

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by tykud on 24/06/2018.
 */
class Example {

    @SerializedName("result")
    @Expose
    var result: Result? = null
    @SerializedName("code")
    @Expose
    var code: Int? = null
    @SerializedName("message")
    @Expose
    var message: String? = null

}