package com.eunicehong.template.core.data.repository.note

import com.eunicehong.template.core.model.note.Note
import com.eunicehong.template.core.remote.client.EuniceRemoteClient

/**
 * 방명록 관련 데이터 처리
 */
internal class NoteRepositoryImpl(
    private val euniceRemoteClient: EuniceRemoteClient,
) : NoteRepository {
    override suspend fun getNotes(): List<Note> = euniceRemoteClient.getNoteList()

    override suspend fun getNote(id: Long): Note = euniceRemoteClient.getNoteDetail(id)

    override suspend fun createNote(
        creatorUid: String,
        userName: String,
        content: String,
    ) = euniceRemoteClient.createNote(
        creatorUid,
        userName,
        content,
    )
}
