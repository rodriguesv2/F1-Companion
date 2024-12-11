package br.com.rubensrodrigues.f1companion.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import br.com.rubensrodrigues.f1companion.R
import br.com.rubensrodrigues.f1companion.ui.theme.F1CompanionTheme

@Composable
fun BottomNavigationHolder() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            BottomAppBar {
                Destination.items.forEach { destination ->
                    val currentRoute = navBackStackEntry?.destination?.route
                        ?: Destination.Racings::class.qualifiedName.orEmpty()

                    NavigationBarItem(
                        selected = currentRoute == destination::class.qualifiedName,
                        onClick = {
                            navController.navigate(destination::class.qualifiedName.orEmpty())
                        },
                        label = {
                            Text(text = stringResource(destination.title))
                        },
                        icon = {
                            Icon(
                                painter = painterResource(destination.icon),
                                null
                            )
                        },
                        colors = NavigationBarItemColors()
                    )
                }
            }
        }
    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = Destination.Racings,
        ) {
            composable<Destination.Racings> {
                Text(text = "Racing")
            }
            composable<Destination.Standings> {
                Text(text = "Standings")
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    F1CompanionTheme {
        BottomNavigationHolder()
    }
}