package com.ricven.richinsights

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ricven.richinsights.navigation.RichInsightsNavigation
import com.ricven.richinsights.ui.theme.RichInsightsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RichInsightsTheme {
                RichInsightsNavigation()
            }
        }
    }
}
