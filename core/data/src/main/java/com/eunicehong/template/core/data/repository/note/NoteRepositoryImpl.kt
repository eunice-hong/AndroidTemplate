package com.eunicehong.template.core.data.repository.note

import com.eunicehong.template.core.model.note.Note

/**
 * 방명록 관련 데이터 처리
 */
class NoteRepositoryImpl : NoteRepository {
    /**
     * TODO(@eunice-hong): 실제 데이터 처리 로직을 구현하세요.
     */
    override fun getNotes(): List<Note> =
        (0..10).map {
            Note(
                id = it.toLong(),
                userName = "User $it",
                content = "Content $it",
                createdAt = System.currentTimeMillis(),
            )
        }
}
