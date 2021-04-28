package org.ybk.videoapp.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.ybk.videoapp.data.BaseRepository
import org.ybk.videoapp.data.dto.Video

class MainViewModel(
    private val repository: BaseRepository
): ViewModel() {

    private val _videoList = MutableLiveData<List<Video>>()
    val videoList: LiveData<List<Video>> get() = _videoList

    init {
        getVideoList()
    }

    fun getVideoList() {
        _videoList.postValue(repository.getVideoList())
    }
}