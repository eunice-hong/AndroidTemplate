package com.eunicehong.template

import android.os.Bundle
import android.util.Log
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
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.eunicehong.template.core.ui.note.NoteList
import com.eunicehong.template.core.ui.theme.AndroidTemplateTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val noteViewModel by viewModels<NoteViewModel>()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val snackBarHostState = remember { SnackbarHostState() }
            val coroutineScope = rememberCoroutineScope()
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
                                coroutineScope.launch {
                                    // TODO(@eunice-hong): Open new note screen
                                    val result =
                                        snackBarHostState.showSnackbar(
                                            "새로운 메모",
                                            "확인",
                                            withDismissAction = true, // 스낵바의 확인 버튼을 보여줄지 여부
                                            SnackbarDuration.Short, // 스낵바 보여주는 시간
                                        )

                                    when (result) {
                                        SnackbarResult.Dismissed -> {
                                            Log.d("snackBar", "snackBar: 스낵바 닫아짐")
                                        }

                                        SnackbarResult.ActionPerformed -> {
                                            Log.d("snackBar", "snackBar: 확인 버튼 눌러짐")
                                        }
                                    }
                                }
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add New Note",
                            )
                        }
                    },
                    snackbarHost = {
                        // 스낵바가 보여지는 부분은 따로 지정해 주어야 함
                        SnackbarHost(
                            hostState = snackBarHostState,
                        )
                    },
                ) { innerPadding ->
                    val noteList = noteViewModel.noteList.collectAsState(initial = emptyList())
                    NoteList(
                        notes = noteList.value,
                        innerPadding = innerPadding,
                        onClickNote = { note ->
                            coroutineScope.launch {
                                // TODO(@eunice-hong): Open note detail screen
                                val result =
                                    snackBarHostState.showSnackbar(
                                        "${note.userName} 님의 메모",
                                        "확인",
                                        withDismissAction = false, // 스낵바의 확인 버튼을 보여줄지 여부
                                        SnackbarDuration.Short, // 스낵바 보여주는 시간
                                    )

                                when (result) {
                                    SnackbarResult.Dismissed -> {
                                        Log.d("snackBar", "snackBar: 스낵바 닫힘")
                                    }

                                    SnackbarResult.ActionPerformed -> {
                                        Log.d("snackBar", "snackBar: 확인 버튼 눌림")
                                    }
                                }
                            }
                        },
                    )
                }
            }
        }
    }
}
