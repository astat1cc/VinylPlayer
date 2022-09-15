package com.github.astat1cc.vinylplayer.data.tracklist.database.models

import com.github.astat1cc.vinylplayer.domain.tracklist.models.AppAudioTrack

data class AudioTrackDb(
    val filePath: String,
    val name: String
) {

    fun toDomain() = AppAudioTrack(filePath, name)
}