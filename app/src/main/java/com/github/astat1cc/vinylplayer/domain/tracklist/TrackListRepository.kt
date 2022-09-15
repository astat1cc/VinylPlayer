package com.github.astat1cc.vinylplayer.domain.tracklist

import com.github.astat1cc.vinylplayer.domain.tracklist.models.AppAlbum
import kotlinx.coroutines.flow.Flow

interface TrackListRepository {

    fun fetchTracks(): Flow<List<AppAlbum>>
}