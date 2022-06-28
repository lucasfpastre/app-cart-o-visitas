package my.study.visitcard

import android.app.Application
import my.study.visitcard.data.AppDatabase
import my.study.visitcard.data.VisitCardRepository

class App: Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { VisitCardRepository(database.visitDao()) }
}