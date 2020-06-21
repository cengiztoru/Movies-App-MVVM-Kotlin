package com.cengiztoru.movies_simplifiedcoding


import com.google.gson.annotations.SerializedName

data class Movie(
    val id: Int,
    val image: String,
    @SerializedName("is_new")
    val isNew: Int,
    val language: String,
    @SerializedName("like_percent")
    val likePercent: Int,
    val rating: String,
    val title: String,
    val type: String,
    @SerializedName("vote_count")
    val voteCount: Int
)
