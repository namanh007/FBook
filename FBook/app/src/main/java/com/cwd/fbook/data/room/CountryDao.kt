package com.cwd.fbook.data.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-24
 *  @Description: ...
 *  All Right Reserved.
 */
@Dao
interface CountryDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(country: CountryEntity)

    @Query("SELECT * FROM country")
    fun get(): Single<CountryEntity>
}