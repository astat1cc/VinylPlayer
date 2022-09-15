package com.github.astat1cc.vinylplayer.data.tracklist.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.github.astat1cc.vinylplayer.data.tracklist.database.models.AlbumDb.Companion.TABLE_NAME
import com.github.astat1cc.vinylplayer.domain.tracklist.models.AppAlbum

@Entity(tableName = TABLE_NAME)
@TypeConverters(TypeConverter::class)
data class AlbumDb(
    val name: String,
    val trackList: List<AudioTrackDb>
) {
    fun toDomain() = AppAlbum(name, trackList.map { trackDb -> trackDb.toDomain() })

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null

    companion object {

        const val TABLE_NAME = "albums"
    }
}