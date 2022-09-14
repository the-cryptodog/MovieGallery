package com.app.moviegallery.models

import android.os.Parcel
import android.os.Parcelable

data class MovieModel(
    //Model class for movie model
    val title:String?,
    val poster_path :String?,
    val release_date:String?,
    val movie_id:Int,
    val vote_average:Float,
    val movie_overview:String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readFloat(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(poster_path)
        parcel.writeString(release_date)
        parcel.writeInt(movie_id)
        parcel.writeFloat(vote_average)
        parcel.writeString(movie_overview)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieModel> {
        override fun createFromParcel(parcel: Parcel): MovieModel {
            return MovieModel(parcel)
        }

        override fun newArray(size: Int): Array<MovieModel?> {
            return arrayOfNulls(size)
        }
    }
}
