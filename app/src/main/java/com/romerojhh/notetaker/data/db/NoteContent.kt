package com.romerojhh.notetaker.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteContent(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val content: String,
    val timestamp: Long
)
