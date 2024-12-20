package br.com.rubensrodrigues.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.rubensrodrigues.presentation.ui.pages.grandprix.GrandPrixPage
import br.com.rubensrodrigues.presentation.ui.pages.grandprix.GrandPrixViewModel
import org.koin.androidx.compose.koinViewModel

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
                val viewModel = koinViewModel<GrandPrixViewModel>()
                GrandPrixPage(viewModel = viewModel)
            }
            composable<Destination.Standings> {
                Text(text = "Standings")
            }
        }
    }
}