package com.eunicehong.template.core.data.repository.auth

/**
 * 인증 관련 데이터 처리
 */
interface AuthRepository {
    /**
     * 사용자 UID를 가져옵니다.
     */
    suspend fun getUserId(): String

    /**
     * 익명으로 로그인합니다.
     */
    suspend fun signInAnonymously(): String?

    /**
     * 로그아웃합니다.
     */
    fun signOut()
}
