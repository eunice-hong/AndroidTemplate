package com.eunicehong.template

import androidx.lifecycle.ViewModel
import com.eunicehong.template.core.data.repository.note.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * 노트 목록을 가져오는 ViewModel
 */
@HiltViewModel
class NoteViewModel
    @Inject
    constructor(
        private val noteRepository: NoteRepository,
    ) : ViewModel() {
        /**
         * 노트 목록을 가져오는 Flow
         */
        val noteList =
            flow {
                emit(noteRepository.getNotes())
            }
    }
