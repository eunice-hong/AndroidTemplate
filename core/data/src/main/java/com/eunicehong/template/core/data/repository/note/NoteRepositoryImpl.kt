package com.eunicehong.template.core.data.repository.note

import com.eunicehong.template.core.model.note.Note
import com.eunicehong.template.core.model.result.Result
import com.eunicehong.template.core.model.result.asResult
import com.eunicehong.template.core.remote.client.EuniceRemoteClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * 방명록 관련 데이터 처리
 */
internal class NoteRepositoryImpl(
    private val euniceRemoteClient: EuniceRemoteClient,
) : NoteRepository {
    override fun getNotes(): Flow<Result<List<Note>>> =
        flow {
            emit(euniceRemoteClient.getNoteList())
        }.asResult()

    override fun getNote(id: Long): Flow<Result<Note>> =
        flow {
            emit(euniceRemoteClient.getNoteDetail(id))
        }.asResult()

    override fun createNote(
        creatorUid: String,
        userName: String,
        content: String,
    ): Flow<Result<Note>> =
        flow {
            euniceRemoteClient.createNote(
                creatorUid = creatorUid,
                userName = userName,
                content = content,
            )
            emit(euniceRemoteClient.getNoteList().last())
        }.asResult()
}
