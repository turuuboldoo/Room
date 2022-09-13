package mn.turbo.room.db.entity.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import mn.turbo.room.db.entity.Student
import mn.turbo.room.db.entity.Subject

data class SubjectWithStudents(
    @Embedded
    val subject: Subject,

    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    var students: List<Student>
)