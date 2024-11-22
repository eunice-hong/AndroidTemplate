package com.eunicehong.template.core.ui.note

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.eunicehong.template.core.model.note.Note
import com.eunicehong.template.core.ui.R
import com.eunicehong.template.core.ui.param.note.NoteParameterProvider

/**
 * 방명록 리스트입니다.
 *
 * @param notes 방명록 리스트
 *
 * @param innerPadding 내부 패딩
 *
 * @param onClickNote 방명록 클릭 시 호출되는 콜백
 */
@Composable
fun NoteList(
    notes: List<Note>,
    innerPadding: PaddingValues = PaddingValues(16.dp),
    onClickNote: (Note) -> Unit,
) {
    LazyColumn(
        modifier =
            Modifier
                .padding(innerPadding)
                .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        items(notes.size) { index ->
            NoteListItem(notes[index], onClickNote)
        }
    }
}

@Composable
private fun NoteListItem(
    note: Note,
    onClickNote: (Note) -> Unit,
) {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable { onClickNote.invoke(note) },
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
                text = note.userName,
                style = MaterialTheme.typography.titleSmall,
            )
            Text(
                text = note.content,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview
@Composable
internal fun NoteListPreview(
    @PreviewParameter(NoteParameterProvider::class)
    note: Note,
) {
    NoteListItem(note = note, onClickNote = {})
}
