package mn.turbo.room.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = false)
    val email: String,
    val name: String,

    // migrations starts here
    @ColumnInfo(name = "created", defaultValue = "0")
    val createdAt: Long = System.currentTimeMillis() // starts - created and renamed createdAt
)
