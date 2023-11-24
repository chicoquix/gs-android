package br.com.fiap.EngagementPatient

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.EngagementPatient.data.AppDatabase
import br.com.fiap.EngagementPatient.databinding.FragmentPacienteListBinding

class PacienteFragment : Fragment() {
    lateinit var binding: FragmentPacienteListBinding
    private val appDb: AppDatabase? by lazy {
        view?.context?.let {
            AppDatabase.getDatabase(it)
        }
    }

    private val pacienteAdapter by lazy {
        PacienteAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPacienteListBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun getDataFromDatabase() {
        appDb?.pacienteDAO()?.select()?.let {
            pacienteAdapter.setData(it)
        }
    }

    private fun setupViews() {
        binding.buttonAddPaciente.setOnClickListener {
            findNavController().navigate(R.id.action_pacienteFragment_to_registerPacienteFragment)
        }
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = pacienteAdapter

        getDataFromDatabase()

    }

}