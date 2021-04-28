package org.ybk.videoapp.data

import org.ybk.videoapp.data.dto.Video

interface BaseRepository {
    fun getVideoList(): List<Video>
}