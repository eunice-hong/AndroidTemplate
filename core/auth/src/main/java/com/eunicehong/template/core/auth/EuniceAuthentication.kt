package com.eunicehong.template.core.auth

/**
 * Firebase Authentication을 사용하여 익명 로그인을 수행하는 인터페이스입니다.
 */
interface EuniceAuthentication {
    /**
     * 사용자 UID를 가져옵니다.
     */
    suspend fun getUserId(): String

    /**
     * 익명으로 로그인합니다.
     *
     * @return 로그인 성공 시 사용자의 UID를 반환합니다. 실패 시 null을 반환합니다.
     */
    suspend fun signInAnonymously(): String?

    fun signOut()
}
