package mn.turbo.room.db.entity.relations

import androidx.room.Entity

@Entity(
    tableName = "students_subjects",
    primaryKeys = ["studentName", "subjectName"]
)
data class StudentSubjectCrossRef(
    val studentName: String,
    val subjectName: String
)
