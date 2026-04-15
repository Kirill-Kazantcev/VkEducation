package com.practicum.vkeducation.presentation.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.practicum.vkeducation.domain.home.ShortAppDetails
import com.practicum.vkeducation.presentation.theme.VkEducationTheme

@Composable
internal fun HomeAppList(
    apps: List<ShortAppDetails>,
    modifier: Modifier = Modifier,
    onAppClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(
                RoundedCornerShape(
                    topStart = 28.dp,
                    topEnd = 28.dp,
                )
            )
            .background(MaterialTheme.colorScheme.surface),
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(apps) { app ->
                HomeAppCard(
                    icon = app.iconUrl,
                    title = app.name,
                    description = app.shortDescription,
                    category = app.category,
                    onClick = onAppClick
                )
                HorizontalDivider()
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, name = "HomeAppList Light")
@Composable
private fun HomeAppListLightPreview() {
    VkEducationTheme {
        HomeAppList(
            apps = HomeData.previewApps,
            onAppClick = {}
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, name = "HomeAppList Dark")
@Composable
private fun HomeAppListDarkPreview() {
    VkEducationTheme {
        HomeAppList(
            apps = HomeData.previewApps,
            onAppClick = {}
        )
    }
}