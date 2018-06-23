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
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
@Dao
interface ProvinceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(provice: ProvinceEntity)

    @Query("SELECT * FROM province")
    fun get(): Single<ProvinceEntity>
}

@Entity(tableName = "province")
data class ProvinceEntity constructor(

        @PrimaryKey
        @ColumnInfo(name = "province_id")
        val id: String,

        @ColumnInfo(name = "province_name")
        val name: String,

        @ColumnInfo(name = "province_country")
        val country: String

)

