package com.cwd.fbook.data.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
@Database(
        entities = [
            CountryEntity::class,
            CityEntity::class,
            UserEntity::class
        ],
        version = 1,
        exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {

    abstract val countryDao: CountryEntity
    abstract val provinceDao: CityEntity
    abstract val userDao: UserEntity
}
