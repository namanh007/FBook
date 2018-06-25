package com.cwd.fbook.data.api.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-24
 *  @Description: ...
 *  All Right Reserved.
 */
data class ApiMsg(
        @SerializedName("result") @Expose var result: Any,
        @SerializedName("code") @Expose var code: Int,
        @SerializedName("message") @Expose var message: String
) {
    companion object {
        const val SUCCESS = 200
        const val FAILED = 999
    }
}