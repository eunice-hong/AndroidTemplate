package com.eunicehong.template.core.data.di

import com.eunicehong.template.core.auth.EuniceAuthentication
import com.eunicehong.template.core.data.repository.auth.AuthRepository
import com.eunicehong.template.core.data.repository.auth.AuthRepositoryImpl
import com.eunicehong.template.core.data.repository.note.NoteRepository
import com.eunicehong.template.core.data.repository.note.NoteRepositoryImpl
import com.eunicehong.template.core.data.repository.startup.StartupRepository
import com.eunicehong.template.core.data.repository.startup.StartupRepositoryImpl
import com.eunicehong.template.core.remote.client.EuniceRemoteClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Repository 모듈
 */
@Module
@InstallIn(SingletonComponent::class)
internal object RepositoryModule {
    @Singleton
    @Provides
    fun provideAuthRepository(auth: EuniceAuthentication): AuthRepository = AuthRepositoryImpl(auth)

    @Singleton
    @Provides
    fun provideNoteRepository(euniceRemoteClient: EuniceRemoteClient): NoteRepository = NoteRepositoryImpl(euniceRemoteClient)

    @Singleton
    @Provides
    fun provideStartupRepository(): StartupRepository = StartupRepositoryImpl()
}
