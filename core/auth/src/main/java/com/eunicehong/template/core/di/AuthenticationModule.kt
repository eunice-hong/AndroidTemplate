package com.eunicehong.template.core.di

import com.eunicehong.template.core.auth.EuniceAuthentication
import com.eunicehong.template.core.auth.EuniceAuthenticationImpl
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * 인증 관련 Dagger 모듈
 */
@Module
@InstallIn(SingletonComponent::class)
internal object AuthenticationModule {
    @Singleton
    @Provides
    fun provideEuniceRemoteClient(auth: FirebaseAuth): EuniceAuthentication = EuniceAuthenticationImpl(auth)

    @Singleton
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = Firebase.auth
}
