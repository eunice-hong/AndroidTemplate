package com.eunicehong.template.core.data.repository.auth

import com.eunicehong.template.core.auth.EuniceAuthentication

/**
 * 인증 관련 데이터 처리
 */
class AuthRepositoryImpl(
    private val auth: EuniceAuthentication,
) : AuthRepository {
    override suspend fun signInAnonymously(): String? {
        return auth.signInAnonymously()
    }

    override fun signOut() {
        auth.signOut()
    }
}