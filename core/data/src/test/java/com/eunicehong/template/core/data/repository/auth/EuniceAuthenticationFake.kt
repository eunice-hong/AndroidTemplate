package com.eunicehong.template.core.data.repository.auth

import com.eunicehong.template.core.auth.EuniceAuthentication

/**
 * 인증 관련 데이터 처리 테스트용 클래스
 */
internal class EuniceAuthenticationFake : EuniceAuthentication {
    override suspend fun signInAnonymously(): String {
        return "fakeUid"
    }

    override fun signOut() {
        // do nothing
    }
}
