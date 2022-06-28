package my.study.visitcard.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface VisitCardDao {

    @Query("SELECT * FROM VisitCard")
    fun getAll(): LiveData<List<VisitCard>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(visitCard: VisitCard)
}