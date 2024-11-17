package com.eunicehong.template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.eunicehong.template.core.data.repository.note.NoteRepositoryImpl
import com.eunicehong.template.core.model.note.Note
import com.eunicehong.template.core.remote.client.EuniceRemoteClient
import com.eunicehong.template.core.ui.theme.AndroidTemplateTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    /**
     * TODO(@eunice-hong): Remove this placeholder note.
     */
    @Inject
    lateinit var remoteClient: EuniceRemoteClient

    /**
     * TODO(@eunice-hong): Remove this placeholder note.
     */
    private val noteRepository by lazy {
        NoteRepositoryImpl(
            euniceRemoteClient = remoteClient,
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidTemplateTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var notes by remember { mutableStateOf<List<Note>>(listOf()) }

                    LaunchedEffect(this@MainActivity) {
                        withContext(Dispatchers.Main) {
                            notes = noteRepository.getNotes().shuffled()
                        }
                    }

                    Column(
                        modifier =
                        Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Greeting(
                            name = notes.firstOrNull()?.userName ?: "No name",
                            modifier =
                                Modifier
                                    .padding(innerPadding),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidTemplateTheme {
        Greeting("Android")
    }
}
