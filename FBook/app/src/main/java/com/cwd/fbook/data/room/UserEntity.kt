package com.cwd.fbook.data.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-24
 *  @Description: ...
 *  All Right Reserved.
 */
@Entity(tableName = "user")
data class UserEntity constructor(

        @PrimaryKey
        @ColumnInfo(name = "user_id") val userId: String? = null,
        @ColumnInfo(name = "first_name") val firstName: String? = null,
        @ColumnInfo(name = "last_name") val lastName: String? = null,
        @ColumnInfo(name = "photo") val photoDisplay: String? = null,
        @ColumnInfo(name = "last_message") val lastMessage: String? = null,
        @ColumnInfo(name = "in_contact") val inContact: Boolean = false,
        @ColumnInfo(name = "in_recent") val inRecent: Boolean = false,
        @ColumnInfo(name = "sync_time") val syncDate: Long = 0
)


