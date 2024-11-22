package com.eunicehong.template.core.remote.client

import android.util.Log
import com.eunicehong.template.core.model.note.Note
import com.eunicehong.template.core.remote.model.note.NoteDto
import com.eunicehong.template.core.remote.model.note.toEntity
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.FilterOperation
import io.github.jan.supabase.postgrest.query.FilterOperator
import javax.inject.Singleton

/**
 * 서버와 통신하는 클라이언트
 */
@Singleton
internal class EuniceRemoteClientImpl(
    private val supabase: SupabaseClient,
) : EuniceRemoteClient {
    override suspend fun getNoteList(): List<Note> =
        supabase.postgrest
            .from("notes")
            .select()
            .decodeList<NoteDto>()
            .map { it.toEntity() }

    override suspend fun getNoteDetail(id: Long): Note =
        supabase.postgrest
            .from("notes")
            .select {
                filter(
                    FilterOperation("id", FilterOperator.EQ, id.toString()),
                )
            }.decodeSingle<NoteDto>()
            .toEntity()

    override suspend fun createNote(
        userName: String,
        content: String,
    ) {
        val result =
            supabase.postgrest
                .from("notes")
                .insert(
                    value =
                        mapOf(
                            "creator_uid" to "1",
                            "user_name" to userName,
                            "content" to content,
                        ),
                )
        Log.d("EuniceRemoteClientImpl", "createNote: $result")
    }
}
