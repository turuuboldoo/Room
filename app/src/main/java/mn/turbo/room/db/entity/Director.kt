package mn.turbo.room.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "directors")
data class Director(
    @PrimaryKey(autoGenerate = false)
    var name: String,

    @ColumnInfo(name = "schoolName")
    var schoolName: String
)
