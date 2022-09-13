package mn.turbo.room.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class Student(
    @PrimaryKey(autoGenerate = false)
    val studentName: String,
    val semester: String,
    val schoolName: String
)
