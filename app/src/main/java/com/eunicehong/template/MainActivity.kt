package com.eunicehong.template

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.eunicehong.template.core.ui.note.NoteList
import com.eunicehong.template.core.ui.theme.AndroidTemplateTheme
import com.eunicehong.template.note.detail.NoteDetailActivity
import com.eunicehong.template.note.edit.NoteEditorActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val noteViewModel by viewModels<NoteViewModel>()

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
                            title = { Text(text = stringResource(R.string.main_title)) },
                            modifier = Modifier.fillMaxWidth(),
                        )
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                                val editorIntent = Intent(baseContext, NoteEditorActivity::class.java)
                                startActivity(editorIntent)
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add New Note",
                            )
                        }
                    },
                ) { innerPadding ->
                    val noteList = noteViewModel.noteList.collectAsState(initial = emptyList())
                    NoteList(
                        notes = noteList.value,
                        innerPadding = innerPadding,
                        onClickNote = { note ->
                            val detailIntent = Intent(baseContext, NoteDetailActivity::class.java)
                            detailIntent.putExtra("id", note.id)
                            startActivity(detailIntent)
                        },
                    )
                }
            }
        }
    }
}
