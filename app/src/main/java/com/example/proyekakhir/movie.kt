package com.example.proyekakhir

import android.os.Parcel
import android.os.Parcelable

class movie() : Parcelable {
    val poster = 0

    constructor(parcel: Parcel) : this() {
    }


    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("Not yet implemented")
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<movie> {
        override fun createFromParcel(parcel: Parcel): movie {
            return movie(parcel)
        }

        override fun newArray(size: Int): Array<movie?> {
            return arrayOfNulls(size)
        }
    }
}