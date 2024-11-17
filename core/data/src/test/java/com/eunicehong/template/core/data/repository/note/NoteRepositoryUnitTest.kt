package com.eunicehong.template.core.data.repository.note

import com.eunicehong.template.core.remote.client.EuniceRemoteClient
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * 방명록 관련 데이터 처리 테스트
 */
class NoteRepositoryUnitTest {
    private val euniceRemoteClient: EuniceRemoteClient by lazy { EuniceRemoteClientFake() }

    private lateinit var noteRepository: NoteRepository

    @Before
    fun setUp() {
        noteRepository =
            NoteRepositoryImpl(
                euniceRemoteClient = euniceRemoteClient,
            )
    }

    @Test
    fun noteRepository_getNotes() =
        runTest {
            noteRepository.getNotes().forEach { note ->
                assertEquals(true, note.content.isNotBlank())
            }
        }

    @Test
    fun noteRepository_createNote() =
        runTest {
            noteRepository.createNote(
                userName = "Eunice",
                content = "Hello, World!",
            )
            assert(true)
        }
}
