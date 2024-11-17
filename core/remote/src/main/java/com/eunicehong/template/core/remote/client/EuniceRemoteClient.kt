package com.eunicehong.template.core.remote.client

import com.eunicehong.template.core.model.note.Note

/**
 * 원격 저장소에서 데이터를 가져오거나 저장하는 클라이언트
 */
interface EuniceRemoteClient {
    /**
     * 노트 목록을 가져옵니다.
     */
    suspend fun getNoteList(): List<Note>

    /**
     * 노트를 생성합니다.
     *
     * @param userName 사용자 이름
     *
     * @param content 내용
     */
    suspend fun createNote(
        userName: String,
        content: String,
    )
}
