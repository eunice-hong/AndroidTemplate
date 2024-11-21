package com.eunicehong.template.core.data.repository.auth

import com.eunicehong.template.core.auth.EuniceAuthentication
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * 방명록 관련 데이터 처리 테스트
 */
class AuthRepositoryUnitTest {
    /**
     * 테스트용 인증 객체
     */
    private val auth: EuniceAuthentication by lazy { EuniceAuthenticationFake() }

    private lateinit var authRepository: AuthRepository

    @Before
    fun setUp() {
        authRepository = AuthRepositoryImpl(auth)
    }

    @Test
    fun authRepository_signInAnonymously() = runTest {
        val uid = authRepository.signInAnonymously()
        assertEquals(true, uid != null)
    }

    @Test
    fun authRepository_signOut() = runTest {
        authRepository.signOut()
        assert(true)
    }
}
