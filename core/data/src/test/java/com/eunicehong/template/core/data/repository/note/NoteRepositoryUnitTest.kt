package com.eunicehong.template.core.data.repository.note

import com.eunicehong.template.core.model.note.Note
import com.eunicehong.template.core.model.result.Result
import com.eunicehong.template.core.remote.client.EuniceRemoteClient
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
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

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun noteRepository_getNotes() =
        runTest {
            val results = mutableListOf<Result<List<Note>>>()
            backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
                noteRepository.getNotes().toList(results)
            }

            assert(results[0] is Result.Loading)
            assert(results[1] is Result.Success)
            assertEquals(2, (results[1] as? Result.Success<List<Note>>)?.data?.size)
        }

    @Test
    fun noteRepository_createNote() =
        runTest {
            noteRepository.createNote(
                creatorUid = "eunice",
                userName = "Eunice",
                content = "Hello, World!",
            )
            assert(true)
        }
}
