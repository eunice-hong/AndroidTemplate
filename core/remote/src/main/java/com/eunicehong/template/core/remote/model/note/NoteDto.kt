package com.eunicehong.template.core.remote.model.note

import com.eunicehong.template.core.model.note.Note
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.text.SimpleDateFormat
import java.util.Locale

/**
 * [Note] DTO
 */
@Serializable
internal data class NoteDto(
    @SerialName("id")
    val id: Long,
    @SerialName("creator_uid")
    val creatorUid: String,
    @SerialName("user_name")
    val userName: String,
    val content: String,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String,
)

internal fun NoteDto.toEntity(): Note {
    val timeMillis = convertToLongUsingSimpleDateFormat(createdAt)
    return Note(
        id = id,
        userName = userName,
        content = content,
        createdAt = timeMillis,
    )
}

/**
 * Convert date string to long using [SimpleDateFormat]
 */
private fun convertToLongUsingSimpleDateFormat(dateString: String): Long {
    val formattedDateString = dateString.replace("Z", "+00:00").replace(":", "")
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HHmmss.SSSSZ", Locale.getDefault())
    return dateFormat.parse(formattedDateString)?.time ?: 0L
}
