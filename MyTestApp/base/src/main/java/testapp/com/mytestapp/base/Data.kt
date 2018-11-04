package testapp.com.mytestapp.base

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "data")
class Data(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var property1: String?,
    var property2: String?
) {
    override fun toString(): String {
        return "Data(id=$id, property1=$property1, property2=$property2)"
    }
}