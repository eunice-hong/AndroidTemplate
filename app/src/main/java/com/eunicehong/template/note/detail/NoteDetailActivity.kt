package com.eunicehong.template.note.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.eunicehong.template.R
import com.eunicehong.template.core.ui.note.NoteDetail
import com.eunicehong.template.core.ui.theme.AndroidTemplateTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * 방명록 상세 화면입니다.
 */
@AndroidEntryPoint
class NoteDetailActivity : ComponentActivity() {
    @Inject
    lateinit var noteDetailViewModelFactory: NoteDetailViewModel.Factory

    /**
     * 방명록 상세 화면 뷰 모델입니다.
     */
    private val noteDetailViewModel by viewModels<NoteDetailViewModel> {
        NoteDetailViewModel.provideFactory(
            noteDetailViewModelFactory,
            id = intent.getLongExtra("id", -1),
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val note = noteDetailViewModel.note.collectAsState(null).value
            AndroidTemplateTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background,
                    contentColor = MaterialTheme.colorScheme.onBackground,
                    topBar = {
                        TopAppBar(
                            navigationIcon = {
                                Icon(
                                    Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Back",
                                    modifier = Modifier.padding(16.dp),
                                )
                            },
                            title = {
                                Text(
                                    text = stringResource(R.string.note_detail_title).format(note?.userName ?: ""),
                                )
                            },
                            modifier = Modifier.fillMaxWidth(),
                        )
                    },
                ) { innerPadding ->
                    NoteDetail(
                        note = note ?: return@Scaffold,
                        innerPadding = innerPadding,
                    )
                }
            }
        }
    }
}
