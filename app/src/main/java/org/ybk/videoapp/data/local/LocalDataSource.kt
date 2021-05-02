package org.ybk.videoapp.data.local

import org.ybk.videoapp.data.dto.Video

interface LocalDataSource {
    fun getVideoList(): List<Video>
    fun getVideo(id: Long): Video
}