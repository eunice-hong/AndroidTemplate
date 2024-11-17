package com.eunicehong.template.core.remote.client

import android.util.Log
import com.eunicehong.template.core.model.note.Note
import com.eunicehong.template.core.remote.BuildConfig
import com.eunicehong.template.core.remote.model.note.NoteDto
import com.eunicehong.template.core.remote.model.note.toEntity
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import kotlin.time.Duration.Companion.seconds

/**
 * 서버와 통신하는 클라이언트
 */
class EuniceRemoteClientImpl : EuniceRemoteClient {
    /**
     * Supabase client.
     *
     * TODO(@eunice-hong): 생성자 주입으로 변경.
     */
    private val supabase by lazy {
        createSupabaseClient(
            supabaseUrl = BuildConfig.supabase_url,
            supabaseKey = BuildConfig.supabase_key,
        ) {
            requestTimeout = 20.seconds
            install(Postgrest)
        }
    }

    override suspend fun getNoteList(): List<Note> =
        supabase.postgrest
            .from("notes")
            .select()
            .decodeList<NoteDto>()
            .map { it.toEntity() }

    override suspend fun createNote(
        userName: String,
        content: String,
    ) {
        val now = System.currentTimeMillis()
        val result =
            supabase.postgrest
                .from("notes")
                .insert(
                    value =
                        listOf(
                            "user_id" to "1",
                            "user_name" to userName,
                            "content" to content,
                        ),
                )
        Log.d("EuniceRemoteClientImpl", "createNote: $result")
    }
}
