package com.cwd.fbook.data.api.response

import com.google.gson.JsonObject

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-24
 *  @Description: ...
 *  All Right Reserved.
 */
interface RequestListener {

    fun onSuccess(data: JsonObject)
}