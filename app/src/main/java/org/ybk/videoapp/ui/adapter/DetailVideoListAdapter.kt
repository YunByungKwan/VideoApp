package org.ybk.videoapp.ui.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import org.ybk.videoapp.R
import org.ybk.videoapp.data.dto.Video
import org.ybk.videoapp.databinding.VideoListItemBinding
import org.ybk.videoapp.ui.detailvideo.DetailVideoActivity

class DetailVideoListAdapter(
        private val context: Context
): RecyclerView.Adapter<DetailVideoListAdapter.ViewHolder>() {

    private val videoList = ArrayList<Video>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<VideoListItemBinding>(
                inflater, R.layout.video_list_item, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = videoList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(videoList[position])
    }

    fun updateItems(items: List<Video>) {
        videoList.clear()
        videoList.addAll(items)
        notifyDataSetChanged()
    }

    inner class ViewHolder(
            private val binding: VideoListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(video: Video) {
            binding.videoItem = video
            val simpleExoPlayer = SimpleExoPlayer.Builder(context).build()
            binding.videoPlayer.player = simpleExoPlayer
            val uri = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"
            val mediaItem = MediaItem.fromUri(Uri.parse(uri))
            val userAgent = Util.getUserAgent(context, context.applicationInfo.name)
            val factory = DefaultDataSourceFactory(context, userAgent)
            val progressiveMediaSource = ProgressiveMediaSource.Factory(factory).createMediaSource(mediaItem)
            simpleExoPlayer.setMediaSource(progressiveMediaSource)
            simpleExoPlayer.prepare()
            simpleExoPlayer.play()

            binding.executePendingBindings()
        }
    }
}