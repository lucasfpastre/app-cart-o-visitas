package my.study.visitcard.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import my.study.visitcard.App
import my.study.visitcard.databinding.ActivityMainBinding
import my.study.visitcard.util.Image

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    private val adapter by lazy { VisitCardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllVisitCard()
        insertListener()
    }

    private fun insertListener() {
        binding.fabAdd.setOnClickListener {
            val intent = Intent(this, AddVisitCardActivity::class.java)
            startActivity(intent)
        }
        adapter.listenerShare = { card ->
            Image.share(this@MainActivity, card)
        }
    }

    private fun getAllVisitCard() {
        mainViewModel.getAll().observe(this) { visitCards ->
            adapter.submitList(visitCards)
        }
    }
}