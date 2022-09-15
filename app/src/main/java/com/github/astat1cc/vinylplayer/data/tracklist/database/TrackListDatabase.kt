package com.github.astat1cc.vinylplayer.data.tracklist.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.astat1cc.vinylplayer.data.tracklist.database.models.AlbumDb

@Database(
    entities = [AlbumDb::class],
    version = 1
)
abstract class TrackListDatabase : RoomDatabase() {

    abstract fun albumDao(): AlbumDao
}