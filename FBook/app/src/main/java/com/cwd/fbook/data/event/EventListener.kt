package com.devfun.libs.events

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-23
 *  @Description: ...
 *  All Right Reserved.
 */
interface EventListener {
    fun onEvent(id: Int, vararg args: Any?)
}