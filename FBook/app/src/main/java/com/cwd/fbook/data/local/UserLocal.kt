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
interface UserDao {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun save(user: UserEntity)

        @Query("SELECT * FROM user")
        fun get(): Single<UserEntity>
}

@Entity(tableName = "user")
data class UserEntity constructor(

        @PrimaryKey
        @ColumnInfo(name = "user_id")
        val id: String,

        @ColumnInfo(name = "user_first_name")
        val firstName: String,

        @ColumnInfo(name = "user_last_name")
        val lastName: String,

        @ColumnInfo(name = "user_sex")
        val sex: String,

        @ColumnInfo(name = "user_photo")
        val photo: String?,

        @ColumnInfo(name = "user_contact")
        val contact: Boolean = false,

        @ColumnInfo(name = "user_history")
        val history: Boolean = false,

        @ColumnInfo(name = "user_sync_date")
        val syncDate: Long = 0
)

