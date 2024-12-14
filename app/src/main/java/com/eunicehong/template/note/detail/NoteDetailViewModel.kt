package com.eunicehong.template.note.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.eunicehong.template.core.data.repository.note.NoteRepository
import com.eunicehong.template.core.model.note.Note
import com.eunicehong.template.core.model.result.Result
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

/**
 * 노트 상세 정보를 가져오는 ViewModel
 */
class NoteDetailViewModel
    @AssistedInject
    constructor(
        @Assisted("id") id: Long,
        noteRepository: NoteRepository,
    ) : ViewModel() {
        /**
         * 노트 상세정보를 가져오는 Flow
         */
        val note: StateFlow<Result<Note>> =
            noteRepository
                .getNote(id)
                .stateIn(
                    scope = viewModelScope,
                    started = SharingStarted.WhileSubscribed(5_000),
                    initialValue = Result.Loading,
                )

        @AssistedFactory
        interface Factory {
            fun create(
                @Assisted("id") id: Long,
            ): NoteDetailViewModel
        }

        companion object {
            fun provideFactory(
                assistedFactory: Factory,
                id: Long,
            ): ViewModelProvider.Factory =
                object : ViewModelProvider.Factory {
                    @Suppress("UNCHECKED_CAST")
                    override fun <T : ViewModel> create(modelClass: Class<T>): T = assistedFactory.create(id) as T
                }
        }
    }
