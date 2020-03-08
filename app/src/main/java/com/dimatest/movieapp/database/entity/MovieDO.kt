package com.dimatest.movieapp.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieDO(
        var popularity: Double? = null,
        var voteCount: Int? = null,
        var video: Boolean? = null,
        var posterPath: String? = null,
        var id: Long? = null,
        var adult: Boolean? = null,
        var backdropPath: String? = null,
        var originalLanguage: String? = null,
        var originalTitle: String? = null,
        var genreIds: String? = null,
        var title: String? = null,
        var voteAverage: Double? = null,
        var overview: String? = null,
        var releaseDate: String? = null,
        @PrimaryKey(autoGenerate = true)
        var inAppId: Long = 0
)