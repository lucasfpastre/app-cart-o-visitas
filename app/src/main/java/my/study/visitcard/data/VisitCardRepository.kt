package my.study.visitcard.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class VisitCardRepository(private val dao: VisitCardDao) {

    fun insert(visitCard: VisitCard) = runBlocking {
        launch(Dispatchers.IO) {
            dao.insert(visitCard)
        }
    }

    fun getAll() = dao.getAll()
}