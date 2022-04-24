package com.smile.tajik_recype.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "main_recype")
data class MainAppTajikRecipe (
        @PrimaryKey(autoGenerate = true) val id: Int = 0,
        @ColumnInfo val mainImage: Int,
        @ColumnInfo val mainTitle: String = "",
        @ColumnInfo val description: String = "",
        @ColumnInfo val type: Int,
        ) : Serializable
