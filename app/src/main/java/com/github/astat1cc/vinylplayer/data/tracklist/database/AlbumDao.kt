package com.github.astat1cc.vinylplayer.data.tracklist.database

import androidx.room.Dao
import androidx.room.Query
import com.github.astat1cc.vinylplayer.data.tracklist.database.models.AlbumDb
import kotlinx.coroutines.flow.Flow

@Dao
interface AlbumDao {

    @Query("SELECT * FROM ${AlbumDb.TABLE_NAME}")
    fun fetchAlbums(): Flow<List<AlbumDb>>
}