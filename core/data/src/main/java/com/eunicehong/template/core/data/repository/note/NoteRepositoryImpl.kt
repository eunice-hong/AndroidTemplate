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

    override suspend fun createNote(
        userName: String,
        content: String,
    ) = euniceRemoteClient.createNote(userName, content)
}
