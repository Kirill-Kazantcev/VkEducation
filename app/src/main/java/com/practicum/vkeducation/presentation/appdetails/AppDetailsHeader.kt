package com.practicum.vkeducation.presentation.appdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.practicum.vkeducation.R
import com.practicum.vkeducation.domain.appdetails.AppDetails
import com.practicum.vkeducation.domain.appdetails.Category
import com.practicum.vkeducation.presentation.theme.VkEducationTheme
import kotlin.math.roundToInt

@Composable
internal fun getCategoryText(category: Category): String = when (category) {
    Category.APP -> stringResource(R.string.category_app)
    Category.GAME -> stringResource(R.string.category_game)
    Category.PRODUCTIVITY -> stringResource(R.string.category_productivity)
    Category.SOCIAL -> stringResource(R.string.category_social)
    Category.EDUCATION -> stringResource(R.string.category_education)
    Category.ENTERTAINMENT -> stringResource(R.string.category_entertainment)
    Category.MUSIC -> stringResource(R.string.category_music)
    Category.VIDEO -> stringResource(R.string.category_video)
    Category.PHOTOGRAPHY -> stringResource(R.string.category_photography)
    Category.HEALTH -> stringResource(R.string.category_health)
    Category.SPORTS -> stringResource(R.string.category_sports)
    Category.NEWS -> stringResource(R.string.category_news)
    Category.BOOKS -> stringResource(R.string.category_books)
    Category.BUSINESS -> stringResource(R.string.category_business)
    Category.FINANCE -> stringResource(R.string.category_finance)
    Category.TRAVEL -> stringResource(R.string.category_travel)
    Category.MAPS -> stringResource(R.string.category_maps)
    Category.FOOD -> stringResource(R.string.category_food)
    Category.SHOPPING -> stringResource(R.string.category_shopping)
    Category.UTILITIES -> stringResource(R.string.category_utilities)
}

@Composable
internal fun AppDetailsHeader(
    appDetails: AppDetails,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            model = appDetails.iconUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(128.dp)
                .clip(RoundedCornerShape(16.dp)),
        )
        Spacer(Modifier.width(16.dp))
        Column {
            Text(
                text = getCategoryText(appDetails.category),
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 12.sp,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = appDetails.name,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = appDetails.developer,
                fontSize = 12.sp,
            )
            Spacer(Modifier.height(4.dp))
            Row {
                Column(Modifier.width(IntrinsicSize.Max)) {
                    Text(
                        text = "${appDetails.ageRating}+",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(text = stringResource(R.string.app_details_age))
                }
                Spacer(Modifier.width(12.dp))
                Column {
                    Text(text = "${appDetails.size.roundToInt()} MB")
                    Spacer(Modifier.height(4.dp))
                    Text(text = stringResource(R.string.app_details_size))
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "AppDetailsHeaderPreview")
@Composable
private fun AppDetailsHeaderPreview() {
    val app = AppDetails(
        id = "preview_id",
        name = "Гильдия Героев: Экшен ММО РПГ",
        developer = "VK Play",
        category = Category.GAME,
        ageRating = 12,
        size = 223.7f,
        screenshotUrlList = listOf(
            "https://static.rustore.ru/imgproxy/-y8kd-4B6MQ-1OKbAbnoAIMZAzvoMMG9dSiHMpFaTBc/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/dfd33017-e90d-4990-aa8c-6f159d546788.jpg@webp",
        ),
        iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
        description = "Легендарный рейд героев в Фэнтези РПГ."
    )
    VkEducationTheme {
        AppDetailsHeader(appDetails = app, modifier = Modifier.fillMaxWidth())
    }
}