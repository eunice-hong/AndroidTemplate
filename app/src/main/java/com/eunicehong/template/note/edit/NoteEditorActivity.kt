package com.eunicehong.template.note.edit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.eunicehong.template.R
import com.eunicehong.template.core.ui.note.ContentEditor
import com.eunicehong.template.core.ui.note.UserNameEditor
import com.eunicehong.template.core.ui.theme.AndroidTemplateTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * 방명록 편집 화면입니다.
 */
@AndroidEntryPoint
class NoteEditorActivity : ComponentActivity() {
    private val noteEditorViewModel: NoteEditorViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
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
                                    modifier =
                                    Modifier
                                        .clickable { finish() }
                                        .padding(16.dp),
                                )
                            },
                            title = {
                                Text(
                                    text = stringResource(R.string.note_editor_title),
                                )
                            },
                            actions = {
                                Text(
                                    text = stringResource(R.string.note_editor_save_button),
                                    style = MaterialTheme.typography.labelLarge,
                                    modifier =
                                        Modifier
                                            .clickable {
                                                lifecycleScope.launch {
                                                    val saved = noteEditorViewModel.saveNote()
                                                    if (saved) {
                                                        finish()
                                                    }
                                                }
                                            }.padding(16.dp),
                                )
                            },
                            modifier = Modifier.fillMaxWidth(),
                        )
                    },
                ) { innerPadding ->
                    Column(
                        modifier =
                        Modifier
                            .padding(innerPadding)
                            .padding(start = 16.dp, end = 16.dp, bottom = 32.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        UserNameEditor(
                            userName = noteEditorViewModel.userName,
                            onUserNameUpdated = noteEditorViewModel::updateUserName,
                        )
                        ContentEditor(
                            content = noteEditorViewModel.content,
                            onContentUpdated = noteEditorViewModel::updateContent,
                            modifier = Modifier.fillMaxSize(),
                        )
                    }
                }
            }
        }
    }
}
