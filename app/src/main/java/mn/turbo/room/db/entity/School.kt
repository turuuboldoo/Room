package mn.turbo.room.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "schools")
data class School(
    @PrimaryKey(autoGenerate = false)
    var name: String
)
