package com.eunicehong.template.note.edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.eunicehong.template.core.data.repository.note.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * 신규 방명록 생성 뷰모델
 */
@HiltViewModel
class NoteEditorViewModel
    @Inject
    constructor(
        private val noteRepository: NoteRepository,
    ) : ViewModel() {
        /**
         * 사용자 이름
         */
        var userName by mutableStateOf("")
            private set

        /**
         * 노트 내용
         */
        var content by mutableStateOf("")
            private set

        /**
         * 사용자 이름 업데이트
         */
        fun updateUserName(newUserName: String) {
            userName = newUserName
        }

        /**
         * 노트 내용 업데이트
         */
        fun updateContent(newContent: String) {
            content = newContent
        }

        /**
         * 노트 저장
         *
         * @return 저장 성공 여부
         */
        suspend fun saveNote(): Boolean =
            if (userName.isBlank() || content.isBlank()) {
                false
            } else {
                noteRepository.createNote(
                    userName = userName,
                    content = content,
                )
                true
            }
    }
