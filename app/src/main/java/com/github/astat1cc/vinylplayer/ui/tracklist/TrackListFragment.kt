package com.github.astat1cc.vinylplayer.ui.tracklist

import android.net.Uri
import android.os.Bundle
import android.provider.DocumentsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.documentfile.provider.DocumentFile
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.astat1cc.vinylplayer.databinding.FragmentPlayerBinding
import com.github.astat1cc.vinylplayer.ui.tracklist.models.AlbumUi
import com.github.astat1cc.vinylplayer.ui.tracklist.models.AudioTrackUi
import com.github.astat1cc.vinylplayer.ui.utils.Const

class TrackListFragment : Fragment() {

    private val binding: FragmentPlayerBinding by viewBinding(createMethod = CreateMethod.INFLATE)

    private val getDirLauncher =
        registerForActivityResult(ActivityResultContracts.OpenDocumentTree()) { uri ->
            getFilesFromDirUri(uri)
        }

    private fun getFilesFromDirUri(uri: Uri?) {
        if (uri == null) return
        val childrenUri =
            DocumentsContract.buildChildDocumentsUriUsingTree(
                uri,
                DocumentsContract.getTreeDocumentId(uri)
            )
        val tree = DocumentFile.fromTreeUri(requireContext(), childrenUri) ?: return
        val trackList: List<AudioTrackUi> =
            tree.listFiles().mapNotNull { file -> // todo check if file is another dir
                if (file.type != null && isAudioType(file.type!!)) {
                    AudioTrackUi(file.uri, file.name)
                } else {
                    null
                }
            }
        AlbumUi(tree.name, trackList) // todo save in db
    }

    private fun isAudioType(type: String) =
        type.startsWith(Const.AUDIO_FILE_TYPE_PREFIX) // todo maybe move to some utils

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.choose.setOnClickListener { getDirLauncher.launch(null) }
    }
}