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
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(user: UserEntity)

    @Query("SELECT * FROM user")
    fun get(): Single<UserEntity>
}