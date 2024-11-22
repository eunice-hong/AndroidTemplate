package com.eunicehong.template.core.ui.note

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.eunicehong.template.core.model.note.Note
import com.eunicehong.template.core.ui.R
import com.eunicehong.template.core.ui.param.note.NoteParameterProvider
import java.text.SimpleDateFormat
import java.util.Locale

/**
 * 방명록 상세보기 화면입니다.
 *
 * @param note 방명록 리스트
 *
 * @param innerPadding 내부 패딩
 *
 */
@Preview
@Composable
fun NoteDetail(
    @PreviewParameter(NoteParameterProvider::class) note: Note,
    innerPadding: PaddingValues = PaddingValues(16.dp),
) {
    val scrollState = rememberScrollState()
    Column(
        modifier =
            Modifier
                .verticalScroll(scrollState)
                .padding(innerPadding)
                .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        NoteMetaInfo(note = note)
        Text(
            text = note.content,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 32.dp),
        )
    }
}

@Composable
private fun NoteMetaInfo(note: Note) {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            Modifier.background(MaterialTheme.colorScheme.tertiary, MaterialTheme.shapes.medium),
        ) {
            Image(
                painter = painterResource(R.drawable.ic_message),
                contentDescription = "Note icon",
                modifier = Modifier.padding(16.dp),
            )
        }
        Column(
            modifier =
                Modifier
                    .padding(start = 16.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text =
                    SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                        .format(note.createdAt),
                style = MaterialTheme.typography.titleSmall,
            )
            Text(
                text = stringResource(R.string.note_detail_creator_name).format(note.userName),
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}
