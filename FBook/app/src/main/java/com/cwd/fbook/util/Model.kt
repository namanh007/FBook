package com.cwd.fbook.util

import com.cwd.fbook.data.api.model.UserApi
import com.cwd.fbook.data.room.UserEntity

/**
 *  @Project: FBook
 *  @CreatedBy: Huy AGS 2018-06-25
 *  @Description: ...
 *  All Right Reserved.
 */
/**
 *  @Project: FBook
 *  @CreatedBy: Huy AGS 2018-06-25
 *  @Description: ...
 *  All Right Reserved.
 */
fun UserApi.convert(): UserEntity {
    return UserEntity(userId, firstName, lastName, photoDisplay)
}


//: Parcelable {
//
//        constructor(parcel: Parcel) : this(parcel.readString(), parcel.readString())
//
//        override fun writeToParcel(dest: Parcel?, flags: Int) {
//                dest?.writeString(userId)
//                dest?.writeString(firstName)
//                dest?.writeString(lastName)
//                dest?.writeInt(sex)
//                dest?.writeInt(birth)
//                dest?.writeString(city)
//                dest?.writeString(status)
//                dest?.writeString(photoDisplay)
//        }
//
//        override fun describeContents() = 0
//
//        companion object CREATOR : Parcelable.Creator<User> {
//                override fun createFromParcel(parcel: Parcel): User {
//                        return User(parcel)
//                }
//
//                override fun newArray(size: Int): Array<User?> {
//                        return arrayOfNulls(size)
//                }
//        }
//}