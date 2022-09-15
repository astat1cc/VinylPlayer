package com.github.astat1cc.vinylplayer.domain.tracklist.models

data class AppAlbum(
    val name: String,
    val trackList: List<AppAudioTrack>
)