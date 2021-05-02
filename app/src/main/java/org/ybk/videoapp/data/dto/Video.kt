package org.ybk.videoapp.data.dto

data class Video(
    val id: Long,
    val title: String,
    val publisher_name: String,
    val url: String,
    val views: Int,
    val good: Int,
    val bad: Int,
    val update_date: String,
    val register_date: String
)