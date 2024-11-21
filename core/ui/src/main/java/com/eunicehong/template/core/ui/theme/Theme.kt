package com.eunicehong.template.core.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme =
    lightColorScheme(
        primary = Color(0xFF4F5B92),
        surfaceTint = Color(0xFF4F5B92),
        onPrimary = Color(0xFFFFFFFF),
        primaryContainer = Color(0xFFDDE1FF),
        onPrimaryContainer = Color(0xFF07164B),
        secondary = Color(0xFF5A5D72),
        onSecondary = Color(0xFFFFFFFF),
        secondaryContainer = Color(0xFFDFE1F9),
        onSecondaryContainer = Color(0xFF171B2C),
        tertiary = Color(0xFF75546E),
        onTertiary = Color(0xFFFFFFFF),
        tertiaryContainer = Color(0xFFFFD7F4),
        onTertiaryContainer = Color(0xFF2C1229),
        error = Color(0xFFBA1A1A),
        onError = Color(0xFFFFFFFF),
        errorContainer = Color(0xFFFFDAD6),
        onErrorContainer = Color(0xFF410002),
        background = Color(0xFFFBF8FF),
        onBackground = Color(0xFF1B1B21),
        surface = Color(0xFFF5FAFC),
        onSurface = Color(0xFF171D1E),
        surfaceVariant = Color(0xFFE2E1EC),
        onSurfaceVariant = Color(0xFF45464F),
        outline = Color(0xFF767680),
        outlineVariant = Color(0xFFC6C5D0),
        scrim = Color(0xFF000000),
        inverseSurface = Color(0xFF2B3133),
        inverseOnSurface = Color(0xFFECF2F3),
        inversePrimary = Color(0xFFB8C4FF),
        surfaceDim = Color(0xFFD5DBDD),
        surfaceBright = Color(0xFFF5FAFC),
        surfaceContainerLowest = Color(0xFFFFFFFF),
        surfaceContainerLow = Color(0xFFEFF5F6),
        surfaceContainer = Color(0xFFE9EFF0),
        surfaceContainerHigh = Color(0xFFE3E9EB),
        surfaceContainerHighest = Color(0xFFDEE3E5),
    )

private val DarkColorScheme =
    darkColorScheme(
        primary = Color(0xFFB8C4FF),
        surfaceTint = Color(0xFFB8C4FF),
        onPrimary = Color(0xFF07164B),
        primaryContainer = Color(0xFF374379),
        onPrimaryContainer = Color(0xFFDDE1FF),
        secondary = Color(0xFFC2C5DD),
        onSecondary = Color(0xFF171B2C),
        secondaryContainer = Color(0xFF424659),
        onSecondaryContainer = Color(0xFFDFE1F9),
        tertiary = Color(0xFFE4BAD9),
        onTertiary = Color(0xFF2C1229),
        tertiaryContainer = Color(0xFF5C3D56),
        onTertiaryContainer = Color(0xFFFFD7F4),
        error = Color(0xFFFFB4AB),
        onError = Color(0xFF690005),
        errorContainer = Color(0xFF93000A),
        onErrorContainer = Color(0xFFFFDAD6),
        background = Color(0xFF1B1B21),
        onBackground = Color(0xFFE6E1E5),
        surface = Color(0xFF171D1E),
        onSurface = Color(0xFFE1E2E5),
        surfaceVariant = Color(0xFF45464F),
        onSurfaceVariant = Color(0xFFC6C5D0),
        outline = Color(0xFF90909A),
        outlineVariant = Color(0xFF767680),
        scrim = Color(0xFF000000),
        inverseSurface = Color(0xFFE6E1E5),
        inverseOnSurface = Color(0xFF2B3133),
        inversePrimary = Color(0xFF4F5B92),
        surfaceDim = Color(0xFF2C3133),
        surfaceBright = Color(0xFF3B4145),
        surfaceContainerLowest = Color(0xFF1A1A1A),
        surfaceContainerLow = Color(0xFF24272A),
        surfaceContainer = Color(0xFF2C3133),
        surfaceContainerHigh = Color(0xFF363C3F),
        surfaceContainerHighest = Color(0xFF40474A),
    )

@Composable
fun AndroidTemplateTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme =
        when {
            dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                val context = LocalContext.current
                if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            }

            darkTheme -> DarkColorScheme
            else -> LightColorScheme
        }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}
