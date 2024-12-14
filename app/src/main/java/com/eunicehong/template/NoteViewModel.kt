package com.eunicehong.template

import androidx.lifecycle.ViewModel
import com.eunicehong.template.core.data.repository.note.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * 노트 목록을 가져오는 ViewModel
 */
@HiltViewModel
class NoteViewModel
    @Inject
    constructor(
        noteRepository: NoteRepository,
    ) : ViewModel() {
        /**
         * 노트 목록을 가져오는 Flow
         */
        val noteList = noteRepository.getNotes()
    }
