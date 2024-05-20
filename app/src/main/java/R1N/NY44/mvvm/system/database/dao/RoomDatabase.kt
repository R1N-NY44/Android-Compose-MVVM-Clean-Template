package R1N.NY44.mvvm.system.database.dao

import R1N.NY44.mvvm.system.database.model.Model1
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

interface RoomDatabase {
    // TODO: Implement RoomDatabase

    @Insert
    suspend fun insert(user: Model1)

    @Update
    suspend fun update(user: Model1)

    @Query("SELECT * FROM model1 ORDER BY name DESC")
    fun getModel1(): Flow<List<Model1>>

    @Query("SELECT * FROM model1 WHERE id = :id")
    suspend fun getModel1ById(id: Long): Model1?
}