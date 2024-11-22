package com.eunicehong.template.note.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import com.eunicehong.template.R
import com.eunicehong.template.core.ui.theme.AndroidTemplateTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * 방명록 상세 화면입니다.
 */
@AndroidEntryPoint
class NoteDetailActivity : ComponentActivity() {
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
                                    modifier = Modifier.padding(16.dp),
                                )
                            },
                            title = {
                                Text(
                                    text = stringResource(R.string.note_detail_title).format(""),
                                )
                            },
                            modifier = Modifier.fillMaxWidth(),
                        )
                    },
                ) { innerPadding ->
                    Text(
                        // TODO(@eunice-hong): 상세 화면 구현
                        text = "상세 화면 구현",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier =
                            Modifier
                                .fillMaxSize()
                                .padding(innerPadding),
                    )
                }
            }
        }
    }
}
