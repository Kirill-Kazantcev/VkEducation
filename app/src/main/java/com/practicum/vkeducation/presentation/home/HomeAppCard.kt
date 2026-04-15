package com.practicum.vkeducation.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.practicum.vkeducation.domain.appdetails.Category
import com.practicum.vkeducation.presentation.appdetails.getCategoryText
import com.practicum.vkeducation.presentation.theme.VkEducationTheme

@Composable
internal fun HomeAppCard(
    icon: String,
    title: String,
    description: String,
    category: Category,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = icon,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .size(56.dp)
                .clip(RoundedCornerShape(16.dp)),
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = description,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 12.sp,
            )
            Text(
                text = getCategoryText(category),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 12.sp
            )
        }
    }
}

@Preview(showBackground = true, name = "HomeAppCard Preview")
@Composable
private fun HomeAppCardPreview() {
    VkEducationTheme {
        HomeAppCard(
            icon = "https://static.rustore.ru/imgproxy/qriFjN8OV6VBF4CCbWcxPm7SL0Y0YtMfxTeJSzWZ1Rc/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png@webp",
            title = "Сбербанк Онлайн - с Салютом",
            description = "Больше чем банк",
            category = Category.FINANCE,
            onClick = {}
        )
    }
}