package com.eunicehong.template.core.data.repository.note

import com.eunicehong.template.core.model.note.Note
import com.eunicehong.template.core.remote.client.EuniceRemoteClient

class EuniceRemoteClientFake : EuniceRemoteClient {
    private val noteList =
        mutableListOf(
            Note(
                id = 1,
                userName = "eunice-hong",
                content = "안녕하세요. 홍은이입니다.",
                createdAt = 1632960000000,
            ),
            Note(
                id = 2,
                userName = "eunice-hong",
                content = "방명록을 남겨주세요.",
                createdAt = 1632960000000,
            ),
        )

    override suspend fun getNoteList(): List<Note> = noteList

    override suspend fun getNoteDetail(id: Long): Note =
        noteList.find { it.id == id } ?: throw IllegalArgumentException("Not found")

    override suspend fun createNote(
        userName: String,
        content: String,
    ) {
        noteList.add(
            Note(
                id = noteList.size + 1L,
                userName = userName,
                content = content,
                createdAt = System.currentTimeMillis(),
            ),
        )
    }
}
