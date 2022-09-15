package com.github.astat1cc.vinylplayer.domain.tracklist

import com.github.astat1cc.vinylplayer.domain.tracklist.models.AppAlbum
import kotlinx.coroutines.flow.Flow

interface TrackListInteractor {

    fun fetchTracks(): Flow<List<AppAlbum>>

    class Impl(private val repository: TrackListRepository) : TrackListInteractor {

        override fun fetchTracks(): Flow<List<AppAlbum>> = repository.fetchTracks()
    }
}