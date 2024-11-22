package com.eunicehong.template.core.data.repository.startup

import android.content.Context
import com.eunicehong.template.core.auth.firebase.initializeFirebase

/**
 * 앱 초기화 관련 데이터 처리
 */
internal class StartupRepositoryImpl : StartupRepository {
    override fun initialize(context: Context) {
        initializeFirebase(context)
    }
}
