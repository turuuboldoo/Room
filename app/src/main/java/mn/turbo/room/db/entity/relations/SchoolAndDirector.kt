package mn.turbo.room.db.entity.relations

import androidx.room.Embedded
import androidx.room.Relation
import mn.turbo.room.db.entity.Director
import mn.turbo.room.db.entity.School

data class SchoolAndDirector(
    @Embedded
    val school: School,

    @Relation(
        parentColumn = "name",
        entityColumn = "schoolName"
    )
    val director: Director
)
