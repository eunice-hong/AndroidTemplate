package com.eunicehong.template.core.auth.firebase

import android.content.Context
import com.google.firebase.FirebaseApp

/**
 * Firebase 초기화
 */
fun initializeFirebase(context: Context) {
    FirebaseApp.initializeApp(context)
}
