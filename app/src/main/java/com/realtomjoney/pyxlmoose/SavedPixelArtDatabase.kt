package com.realtomjoney.pyxlmoose

object SavedPixelArtDatabase {
    private val database = mutableListOf<SavedPixelArt>()

    fun addBitmap(param: SavedPixelArt) {
        database.add(param)
    }

    fun remove(index: Int) {
        database.removeAt(index)
    }

    fun toList() = database.toList()
}