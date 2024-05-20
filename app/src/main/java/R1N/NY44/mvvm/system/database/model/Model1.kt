package R1N.NY44.mvvm.system.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "model1")
data class Model1(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    // TODO: Add more fields
)
