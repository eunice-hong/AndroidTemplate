package com.eunicehong.template.core.auth

import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.tasks.await

/**
 * Firebase Authentication을 사용하여 로그인/로그아웃을 수행하는 구현체입니다.
 *
 * @param auth Firebase Authentication 인스턴스
 */
internal class EuniceAuthenticationImpl(
    private val auth: FirebaseAuth = Firebase.auth,
) : EuniceAuthentication {
    override suspend fun getUserId(): String = auth.currentUser?.uid ?: signInAnonymously() ?: ""

    override suspend fun signInAnonymously(): String? {
        val result = auth.signInAnonymously().await()
        return when (val user = result.user) {
            null -> {
                Log.d(TAG, "signInAnonymously:failure")
                null
            }

            else -> {
                Log.d(TAG, "signInAnonymously:success")
                user.uid
            }
        }
    }

    override fun signOut() {
        auth.signOut()
    }

    companion object {
        private const val TAG = "EuniceAuthentication"
    }
}
