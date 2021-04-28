package org.ybk.videoapp.data.local

import org.ybk.videoapp.data.dto.Video
import org.ybk.videoapp.util.Constants

class VideoLocalDataSource: LocalDataSource {

    private val videoList = listOf(
        Video("1", "title1", "user1", Constants.url,
            1000, 1000, 1000, "2021-04-27", "2021-04-27"),
        Video("1", "title1", "user1", Constants.url,
            1000, 1000, 1000, "2021-04-27", "2021-04-27"),
        Video("1", "title1", "user1", Constants.url,
            1000, 1000, 1000, "2021-04-27", "2021-04-27"),
        Video("1", "title1", "user1", Constants.url,
            1000, 1000, 1000, "2021-04-27", "2021-04-27"),
        Video("1", "title1", "user1", Constants.url,
            1000, 1000, 1000, "2021-04-27", "2021-04-27"),
        Video("1", "title1", "user1", Constants.url,
            1000, 1000, 1000, "2021-04-27", "2021-04-27"),
        Video("1", "title1", "user1", Constants.url,
            1000, 1000, 1000, "2021-04-27", "2021-04-27"),
        Video("1", "title1", "user1", Constants.url,
            1000, 1000, 1000, "2021-04-27", "2021-04-27"))

    override fun getVideoList(): List<Video> {
        return videoList
    }
}