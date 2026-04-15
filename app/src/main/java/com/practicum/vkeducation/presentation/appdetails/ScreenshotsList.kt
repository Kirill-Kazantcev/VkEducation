package com.practicum.vkeducation.presentation.appdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.practicum.vkeducation.R
import com.practicum.vkeducation.presentation.theme.VkEducationTheme

@Composable
internal fun ScreenshotsList(
    screenshotUrlList: List<String>,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        Text(
            text = stringResource(R.string.app_details_screenshots),
            modifier = Modifier.padding(contentPadding),
        )
        Spacer(Modifier.height(8.dp))
        HorizontalPager(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = contentPadding,
            pageSpacing = 8.dp,
            state = rememberPagerState { screenshotUrlList.size },
        ) { index ->
            AsyncImage(
                model = screenshotUrlList[index],
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    VkEducationTheme {
        ScreenshotsList(
            screenshotUrlList = listOf(
                "https://static.rustore.ru/imgproxy/-y8kd-4B6MQ-1OKbAbnoAIMZAzvoMMG9dSiHMpFaTBc/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/dfd33017-e90d-4990-aa8c-6f159d546788.jpg@webp",
            ),
            contentPadding = PaddingValues(horizontal = 16.dp),
        )
    }
}