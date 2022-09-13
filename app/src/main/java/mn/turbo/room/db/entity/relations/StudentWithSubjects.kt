package mn.turbo.room.db.entity.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import mn.turbo.room.db.entity.Student
import mn.turbo.room.db.entity.Subject

data class StudentWithSubjects(
    @Embedded
    val student: Student,

    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    var subjects: List<Subject>
)
