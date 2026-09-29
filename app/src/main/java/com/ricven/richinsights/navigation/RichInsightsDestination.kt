package com.ricven.richinsights.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface RichInsightsDestination : NavKey {
    @Serializable
    data object Home : RichInsightsDestination

    @Serializable
    data object Learn : RichInsightsDestination

    @Serializable
    data object Quiz : RichInsightsDestination

    @Serializable
    data object Bible : RichInsightsDestination

    @Serializable
    data object News : RichInsightsDestination

    @Serializable
    data object Profile : RichInsightsDestination
}
