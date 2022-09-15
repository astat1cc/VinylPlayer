package com.github.astat1cc.vinylplayer.data.tracklist.database.converters

import androidx.room.TypeConverter
import com.github.astat1cc.vinylplayer.data.tracklist.database.models.AudioTrackDb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object TypeConverter {

    @TypeConverter
    fun fromJson(json: String): List<AudioTrackDb> {
        val type = object : TypeToken<List<AudioTrackDb>>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toJson(list: List<AudioTrackDb>): String {
        val type = object : TypeToken<List<AudioTrackDb>>() {}.type
        return Gson().toJson(list, type)
    }
}