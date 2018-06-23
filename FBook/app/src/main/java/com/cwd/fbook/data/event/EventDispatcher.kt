package com.devfun.libs.events

import android.util.SparseArray




/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-23
 *  @Description: ...
 *  All Right Reserved.
 */
class EventDispatcher private constructor() {

    private val observers = SparseArray<MutableSet<EventListener>>()
    private val sync = Any()

    companion object {
        private var sInstance: EventDispatcher? = null
        @Synchronized
        fun getInstance(): EventDispatcher {
            var tmp = sInstance
            if (tmp == null) {
                synchronized(EventDispatcher::class.java) {
                    tmp = sInstance
                    if (tmp == null) {
                        tmp = EventDispatcher()
                        sInstance = tmp
                    }
                }
            }
            return tmp!!
        }
    }

    fun addListener(eventId: Int, listener: EventListener?) {
        if (listener == null)
            return

        synchronized(sync) {
            var listeners = observers[eventId]
            if (listeners == null) {
                listeners = mutableSetOf()
            }
            listeners.add(listener)
            observers.put(eventId, listeners)
        }
    }

    fun removeListener(eventId: Int, listener: EventListener?) {
        if (listener == null) {
            return
        }
        synchronized(sync) {
            val listeners = observers.get(eventId)
            if (listeners != null && !listeners.isEmpty()) {
                listeners.remove(listener)
            }
        }
    }

    fun post(eventId: Int, vararg args: Any?) {
        var listeners: Set<EventListener>? = null
        synchronized(sync) {
            listeners = observers.get(eventId)
            if (listeners != null && !listeners!!.isEmpty()) {
                for (listener in listeners!!) {
                    listener.onEvent(eventId, *args)
                }
            }
        }
    }
}