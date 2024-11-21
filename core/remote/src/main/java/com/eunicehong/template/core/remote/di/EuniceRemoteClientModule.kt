package com.eunicehong.template.core.remote.di

import com.eunicehong.template.core.remote.BuildConfig
import com.eunicehong.template.core.remote.client.EuniceRemoteClient
import com.eunicehong.template.core.remote.client.EuniceRemoteClientImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import javax.inject.Singleton

/**
 * 서버와 통신하는 클라이언트를 제공하는 Dagger 모듈
 */
@Module
@InstallIn(SingletonComponent::class)
internal object EuniceRemoteClientModule {
    @Singleton
    @Provides
    fun provideEuniceRemoteClient(supabaseClient: SupabaseClient): EuniceRemoteClient = EuniceRemoteClientImpl(supabaseClient)

    @Singleton
    @Provides
    fun provideSupabaseClient(): SupabaseClient =
        createSupabaseClient(
            supabaseUrl = BuildConfig.supabase_url,
            supabaseKey = BuildConfig.supabase_key,
        ) {
            install(Postgrest)
        }
}
