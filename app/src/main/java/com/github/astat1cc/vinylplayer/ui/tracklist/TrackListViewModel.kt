package com.github.astat1cc.vinylplayer.ui.tracklist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.astat1cc.vinylplayer.core.DispatchersProvider
import com.github.astat1cc.vinylplayer.domain.tracklist.TrackListInteractor
import com.github.astat1cc.vinylplayer.ui.tracklist.models.AlbumUi
import kotlinx.coroutines.launch

class TrackListViewModel(
    private val dispatchers: DispatchersProvider,
    private val interactor: TrackListInteractor
) : ViewModel() {

    fun saveAlbum(albumUi: AlbumUi) = viewModelScope.launch(dispatchers.io()) {
        interactor.fetchTracks()
    }
}