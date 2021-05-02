package org.ybk.videoapp.ui.detailvideo

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import org.ybk.videoapp.R
import org.ybk.videoapp.data.BaseRepository
import org.ybk.videoapp.databinding.ActDetailVideoBinding
import org.ybk.videoapp.databinding.ActMainBinding
import org.ybk.videoapp.ui.main.MainViewModel

class DetailVideoActivity : AppCompatActivity() {

    private lateinit var binding: ActDetailVideoBinding
    private var id: Long = 0
    private val repository: BaseRepository by inject()
    private val detailVideoViewModel: DetailVideoViewModel by viewModel {
        parametersOf(id, repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent.let {
            id = it.getLongExtra("videoId", 0)
            Toast.makeText(this, "$id", Toast.LENGTH_SHORT).show()
        }

        binding = DataBindingUtil.setContentView<ActDetailVideoBinding>(
                this, R.layout.act_detail_video).apply {
            lifecycleOwner = this@DetailVideoActivity
            activity = this@DetailVideoActivity
            viewmodel = detailVideoViewModel
        }

        detailVideoViewModel.videoList.observe(this, Observer {
            val selector = DefaultTrackSelector(this)
            val simpleExoPlayer = SimpleExoPlayer.Builder(this).build()
            binding.videoPlayer.player = simpleExoPlayer
            val uri = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"
            val mediaItem = MediaItem.fromUri(Uri.parse(uri))
            val userAgent = Util.getUserAgent(this, applicationInfo.name)
            val factory = DefaultDataSourceFactory(this, userAgent)
            val progressiveMediaSource = ProgressiveMediaSource.Factory(factory).createMediaSource(mediaItem)
            simpleExoPlayer.setMediaSource(progressiveMediaSource)
            simpleExoPlayer.prepare()
            //simpleExoPlayer.playWhenReady = true
        })
    }
}