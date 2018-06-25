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
@Entity(tableName = "country")
data class CountryEntity constructor(

        @PrimaryKey
        @ColumnInfo(name = "country_id")
        val id: String,

        @ColumnInfo(name = "country_name")
        val name: String
)