package com.ricven.richinsights.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val RichInsightsLightColorScheme = lightColorScheme(
    primary = RichInsightsBlue,
    onPrimary = RichInsightsSurface,
    primaryContainer = RichInsightsDeepNavy,
    onPrimaryContainer = RichInsightsSurface,
    secondary = RichInsightsCyan,
    onSecondary = RichInsightsPrimaryText,
    secondaryContainer = RichInsightsBackground,
    onSecondaryContainer = RichInsightsPrimaryText,
    tertiary = RichInsightsGold,
    onTertiary = RichInsightsPrimaryText,
    background = RichInsightsBackground,
    onBackground = RichInsightsPrimaryText,
    surface = RichInsightsSurface,
    onSurface = RichInsightsPrimaryText,
    surfaceVariant = RichInsightsBackground,
    onSurfaceVariant = RichInsightsSecondaryText,
    error = RichInsightsError,
    onError = RichInsightsSurface,
)

private val RichInsightsShapes = androidx.compose.material3.Shapes()

@Composable
fun RichInsightsTheme(
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = RichInsightsLightColorScheme,
        typography = RichInsightsTypography,
        shapes = RichInsightsShapes,
        content = content,
    )
}
