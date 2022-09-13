package mn.turbo.room.db.entity.relations

import androidx.room.Embedded
import androidx.room.Relation
import mn.turbo.room.db.entity.School
import mn.turbo.room.db.entity.Student

data class SchoolWithStudents(
    @Embedded
    val school: School,
    @Relation(
        parentColumn = "name",
        entityColumn = "studentName"
    )
    val students: List<Student>
)
