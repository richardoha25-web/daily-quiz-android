package com.ricven.richinsights

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ricven.richinsights.ui.theme.RichInsightsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RichInsightsTheme {
                RichInsightsApp()
            }
        }
    }
}

@Composable
private fun RichInsightsApp() {
    Text(text = "RichInsights")
}

@Preview(showBackground = true)
@Composable
private fun RichInsightsPreview() {
    RichInsightsTheme {
        RichInsightsApp()
    }
}
