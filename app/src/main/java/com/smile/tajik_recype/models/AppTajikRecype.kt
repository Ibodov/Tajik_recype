package com.smile.tajik_recype.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "first_recipe")
data class AppTajikRecype (
        @PrimaryKey(autoGenerate = true) val id: Int = 0,
        @ColumnInfo val image: Int,
        @ColumnInfo val title: String = "",
        @ColumnInfo val description: String = "",
        @ColumnInfo val ingredients: String = "",
        @ColumnInfo val steps: String = "",
        @ColumnInfo val link: String = "",
        @ColumnInfo val type: Int
        ) : Serializable