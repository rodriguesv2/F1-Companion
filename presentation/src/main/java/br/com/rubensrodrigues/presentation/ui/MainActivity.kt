package br.com.rubensrodrigues.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import br.com.rubensrodrigues.presentation.navigation.BottomNavigationHolder
import br.com.rubensrodrigues.presentation.ui.theme.F1CompanionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            F1CompanionTheme {
                BottomNavigationHolder()
            }
        }
    }
}