package com.eunicehong.template.core.ui.note

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.eunicehong.template.core.ui.R

/**
 * 방문자의 이름을 입력하는 에디터
 */
@Composable
fun UserNameEditor(
    userName: String,
    onUserNameUpdated: (String) -> Unit,
) {
    Row(
        modifier =
            Modifier
                .fillMaxWidth(),
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
        TextField(
            value = userName,
            label = {
                Text(
                    text = stringResource(R.string.note_editor_creator_name_input_label),
                )
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.note_editor_creator_name_input_hint),
                )
            },
            onValueChange = onUserNameUpdated,
            modifier =
                Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth(),
            maxLines = 1,
            colors =
                TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
        )
    }
}

/**
 * 방명록 내용을 입력하는 에디터
 */
@Composable
fun ContentEditor(
    content: String,
    onContentUpdated: (String) -> Unit,
    modifier: Modifier,
) {
    TextField(
        value = content,
        onValueChange = onContentUpdated,
        label = {
            Text(
                text = stringResource(R.string.note_editor_content_input_label),
            )
        },
        placeholder = {
            Text(
                text = stringResource(R.string.note_editor_content_input_hint),
            )
        },
        modifier =
            modifier
                .fillMaxWidth(),
        colors =
            TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
    )
}
