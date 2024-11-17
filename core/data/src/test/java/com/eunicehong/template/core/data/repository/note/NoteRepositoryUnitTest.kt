package com.eunicehong.template.core.data.repository.note

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * 방명록 관련 데이터 처리 테스트
 */
class NoteRepositoryUnitTest {
    private lateinit var noteRepository: NoteRepository

    @Before
    fun setUp() {
        noteRepository = NoteRepositoryImpl()
    }

    @Test
    fun noteRepository_getNotes() {
        noteRepository.getNotes().forEachIndexed { index, note ->
            assertEquals("User $index", note.userName)
        }
    }
}
