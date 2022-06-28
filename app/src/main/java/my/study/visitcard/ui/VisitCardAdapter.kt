package my.study.visitcard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import my.study.visitcard.data.VisitCard
import my.study.visitcard.databinding.ItemVisitCardBinding

class VisitCardAdapter : ListAdapter<VisitCard, VisitCardAdapter.ViewHolder>(DiffCallback()) {

    var listenerShare: (View) -> Unit = {  }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemVisitCardBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemVisitCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind (item: VisitCard) {
            binding.tvNome.text = item.nome
            binding.tvTelefone.text = item.telefone
            binding.tvEmail.text = item.email
            binding.tvEmpresa.text = item.empresa
            binding.mcvCard.setCardBackgroundColor(Color.parseColor(item.fundoPersonalizado))
            binding.mcvCard.setOnClickListener {
                listenerShare(it)
            }
        }
    }
}

class DiffCallback: DiffUtil.ItemCallback<VisitCard>() {
    override fun areItemsTheSame(oldItem: VisitCard, newItem: VisitCard) = oldItem == newItem
    override fun areContentsTheSame(oldItem: VisitCard, newItem: VisitCard) = oldItem.id == newItem.id

}