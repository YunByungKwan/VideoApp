package org.ybk.videoapp.ui.detailvideo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.ybk.videoapp.data.BaseRepository
import org.ybk.videoapp.data.dto.Video

class DetailVideoViewModel(
        private val id: Long,
        private val repository: BaseRepository
): ViewModel() {

    private val _videoList = MutableLiveData<List<Video>>()
    val videoList: LiveData<List<Video>> get() = _videoList

    private val _video = MutableLiveData<Video>()
    val video: LiveData<Video> get() = _video

    init {
        getVideoList()
        getVideo()
    }

    fun getVideo() {
        _video.postValue(repository.getVideo(id))
    }

    fun getVideoList() {
        _videoList.postValue(repository.getVideoList())
    }
}