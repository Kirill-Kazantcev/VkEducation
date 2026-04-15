package com.practicum.vkeducation.presentation.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.practicum.vkeducation.R
import com.practicum.vkeducation.presentation.theme.VkEducationTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onAppClick: (String) -> Unit
) {
    val viewModel = hiltViewModel<HomeViewModel>()
    val state by viewModel.state.collectAsState()
    val events = viewModel.events

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    val underDevelopmentText = stringResource(R.string.under_development)

    LaunchedEffect(Unit) {
        events.collect { event ->
            when (event) {
                is HomeEvent.OnLogoClick -> {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(underDevelopmentText)
                    }
                }
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(padding)
                .background(MaterialTheme.colorScheme.primary)
        ) {
            HomeHeader(onLogoClick = { viewModel.showOnLogoClickMessage() })
            when (val currentState = state) {
                is HomeState.Content -> HomeAppList(
                    apps = currentState.appDetails,
                    onAppClick = onAppClick
                )
                is HomeState.Error -> HomeError(
                    onRefreshClick = { viewModel.getShortAppDetails() },
                )
                is HomeState.Loading -> HomeLoading()
            }
        }
    }
}

@Preview(showSystemUi = true, name = "HomeScreen Light")
@Composable
private fun HomeScreenLightPreview() {
    VkEducationTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            HomeHeader(onLogoClick = {})
            HomeAppList(
                apps = HomeData.previewApps,
                onAppClick = {}
            )
        }
    }
}

@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "HomeScreen Dark")
@Composable
private fun HomeScreenDarkPreview() {
    VkEducationTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            HomeHeader(onLogoClick = {})
            HomeAppList(
                apps = HomeData.previewApps,
                onAppClick = {}
            )
        }
    }
}