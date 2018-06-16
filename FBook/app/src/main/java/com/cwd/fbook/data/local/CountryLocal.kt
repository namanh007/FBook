package com.cwd.fbook.data.local

import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single

/**
 **************************************************************************************************
 * 
 *  @Project: FBook
 *  @CreatedBy: Huy AgilSun Quoc Vu 2018-06-15
 *  @LastEditor: Huy AgilSun Quoc Vu 2018-06-15
 *  @Description: ...
 *
 *                                      All Right Reserved.
 *
 **************************************************************************************************
 */
@Dao
interface CountryDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(country: CountryEntity)

    @Query("SELECT * FROM country")
    fun get(): Single<CountryEntity>
}

@Entity(tableName = "country")
data class CountryEntity constructor(

        @PrimaryKey
        @ColumnInfo(name = "country_id")
        val id: String,

        @ColumnInfo(name = "country_name")
        val name: String
)

