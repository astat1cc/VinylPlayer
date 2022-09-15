package com.github.astat1cc.vinylplayer.data.tracklist

import com.github.astat1cc.vinylplayer.data.tracklist.database.AlbumDao
import com.github.astat1cc.vinylplayer.domain.tracklist.TrackListRepository
import com.github.astat1cc.vinylplayer.domain.tracklist.models.AppAlbum
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TrackListRepositoryImpl(
    private val dao: AlbumDao
) : TrackListRepository {

    override fun fetchTracks(): Flow<List<AppAlbum>> = dao.fetchAlbums().map { albumList ->
        albumList.map { albumDb ->
            albumDb.toDomain()
        }
    }
}