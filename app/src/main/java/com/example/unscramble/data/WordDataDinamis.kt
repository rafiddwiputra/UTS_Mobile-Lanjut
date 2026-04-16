package com.example.unscramble.data

import android.content.Context


class WordDataDinamis(context: Context) {
    private val sharedPref = context.getSharedPreferences("words_pref", Context.MODE_PRIVATE)
    companion object {
        private const val KEY_WORDS = "WORDS_LIST"
    }
    fun getWords(): MutableList<String> {
        val savedWords =sharedPref.getStringSet(KEY_WORDS, emptySet()) ?: emptySet()
        val defaultWords = listOf("android", "kotlin", "compose", "studio")
        return (savedWords + defaultWords).toMutableList()
    }

    fun addWord(newWord: String) {
        val currentWords=getWords().toMutableSet()
        currentWords.add(newWord.lowercase())
        sharedPref.edit().putStringSet(KEY_WORDS, currentWords).apply()
    }
}