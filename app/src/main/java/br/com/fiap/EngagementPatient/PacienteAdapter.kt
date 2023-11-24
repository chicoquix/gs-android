package br.com.fiap.EngagementPatient

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.EngagementPatient.data.PacienteModel
import br.com.fiap.EngagementPatient.databinding.PacienteItemBinding
import java.text.FieldPosition

class PacienteAdapter : RecyclerView.Adapter<PacienteAdapter.CharacterItemViewHolder>() {

    private var pacienteList: MutableList<PacienteModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterItemViewHolder {
        val binding = PacienteItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.paciente_item,
                parent,
                false
            )
        )
        return CharacterItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterItemViewHolder, position: Int) {
        holder.bindView(pacienteList[position], position)
    }

    override fun getItemCount(): Int {
        return pacienteList.size
    }

    fun setData(list: List<PacienteModel>) {
        with(pacienteList) {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }

    inner class CharacterItemViewHolder(
        private val view: PacienteItemBinding
    ) : RecyclerView.ViewHolder(view.root) {
        fun bindView(pacienteModel: PacienteModel, itemPosition: Int){
            view.textNome.text = pacienteModel.nome
            view.textTelefone.text = pacienteModel.telefone
            view.textDataNascimento.text = pacienteModel.dataNascimento
            view.textDoenca.text = pacienteModel.doenca
        }
    }
}