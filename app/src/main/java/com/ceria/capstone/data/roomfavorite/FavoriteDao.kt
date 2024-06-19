package com.ceria.capstone.data.roomfavorite

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoriteDao {
    @Insert
    fun insert(favoriteUser: FavoriteEntity)

    @Query("SELECT * FROM favorite")
    fun getfavoriteuser(): LiveData<List<FavoriteEntity>>

    @Query("SELECT count(*) FROM favorite WHERE favorite.id =:id ")
    fun checkuser(id: Int): Int

    @Query("DELETE FROM favorite WHERE favorite.id=:id")
    suspend fun remove(id: Int): Int

    @Query("SELECT count(*) FROM favorite WHERE favorite.username =:username ")
    fun checkuserfavorite(username: String): Int

    @Query("SELECT count(*) FROM favorite")
    fun getFavoriteCountSync(): Int

}