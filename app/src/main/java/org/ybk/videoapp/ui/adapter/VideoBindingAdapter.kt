package org.ybk.videoapp.ui.adapter

import android.app.Activity
import android.provider.SyncStateContract
import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.ExoPlayer
import org.ybk.videoapp.data.dto.Video

object VideoBindingAdapter {

    @JvmStatic
    @BindingAdapter("activity", "listData")
    fun setVideoList(
        recyclerView: RecyclerView, activity: Activity, items: List<Video>?
    ) {
        Log.d("TAG", "items size: ${items?.size}")
        if(recyclerView.adapter == null) {
            recyclerView.adapter = VideoListAdapter(activity)
        }
        val videoListAdapter = recyclerView.adapter as VideoListAdapter
        items?.let {
            videoListAdapter.updateItems(it)
            videoListAdapter.notifyDataSetChanged()
        }
    }

    @JvmStatic
    @BindingAdapter("activity", "detailListData")
    fun setDetailVideoList(
            recyclerView: RecyclerView, activity: Activity, items: List<Video>?
    ) {
        Log.d("TAG", "items size: ${items?.size}")
        if(recyclerView.adapter == null) {
            recyclerView.adapter = DetailVideoListAdapter(activity)
        }
        val videoListAdapter = recyclerView.adapter as DetailVideoListAdapter
        items?.let {
            videoListAdapter.updateItems(it)
            videoListAdapter.notifyDataSetChanged()
        }
    }

}