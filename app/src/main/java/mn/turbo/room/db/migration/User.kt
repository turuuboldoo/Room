package mn.turbo.room.db.migration

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    val name: String,
    val password: String,
    val email: String,

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
)
