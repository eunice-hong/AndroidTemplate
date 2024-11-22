package com.eunicehong.template.core.data.repository.startup

import android.content.Context

interface StartupRepository {
    fun initialize(context: Context)
}
