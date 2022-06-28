package my.study.visitcard.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import my.study.visitcard.App
import my.study.visitcard.R
import my.study.visitcard.data.VisitCard
import my.study.visitcard.databinding.ActivityAddVisitCardBinding


class AddVisitCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddVisitCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.ibClose.setOnClickListener {
            finish()
        }
        binding.mbConfirm.setOnClickListener {
            val visitCard = VisitCard(
                nome = binding.tilName.editText?.text.toString(),
                empresa = binding.tilEmp.editText?.text.toString(),
                telefone = binding.tilTel.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tilColor.editText?.text.toString()
            )
            mainViewModel.insert(visitCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}