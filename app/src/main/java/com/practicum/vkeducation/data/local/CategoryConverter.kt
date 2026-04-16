package com.practicum.vkeducation.data.local

import androidx.room.TypeConverter
import com.practicum.vkeducation.domain.appdetails.Category

class CategoryConverter {
    @TypeConverter
    fun fromCategory(category: Category): String = category.name

    @TypeConverter
    fun toCategory(categoryName: String): Category = Category.valueOf(categoryName)
}