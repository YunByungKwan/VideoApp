package org.ybk.videoapp.data

import org.ybk.videoapp.data.dto.Video
import org.ybk.videoapp.data.local.LocalDataSource

class VideoRepository(
    private val localDataSource: LocalDataSource
): BaseRepository {

    override fun getVideoList(): List<Video> {
        return localDataSource.getVideoList()
    }

    override fun getVideo(id: Long): Video {
        return localDataSource.getVideo(id)
    }

}