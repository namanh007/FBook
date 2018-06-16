package com.cwd.fbook.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

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
@Database(
        entities = [
            CountryEntity::class,
            ProvinceEntity::class,
            UserEntity::class
        ],
        version = 1,
        exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {

    abstract val countryDao: CountryEntity
    abstract val provinceDao: ProvinceEntity
    abstract val userDao: UserEntity
}
