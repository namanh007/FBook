package com.cwd.fbook.data.api.response

import com.cwd.fbook.data.api.model.ApiMsg

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-24
 *  @Description: ...
 *  All Right Reserved.
 */
interface ApiResponse {

    fun onSuccess(result: ApiMsg)

    fun onFailed()
}