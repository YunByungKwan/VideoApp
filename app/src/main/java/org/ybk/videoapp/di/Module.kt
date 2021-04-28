package org.ybk.videoapp.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import org.ybk.videoapp.data.BaseRepository
import org.ybk.videoapp.data.VideoRepository
import org.ybk.videoapp.data.local.VideoLocalDataSource
import org.ybk.videoapp.ui.main.MainViewModel

val appModules: Module = module {
    single<BaseRepository> { VideoRepository(VideoLocalDataSource()) }
}

val mainViewModelModule: Module = module {
    viewModel {(repository: BaseRepository) ->
        MainViewModel(repository)
    }
}