package br.com.fiap.EngagementPatient

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import br.com.fiap.EngagementPatient.SnackBarUtil.showSnackBar
import br.com.fiap.EngagementPatient.data.AppDatabase
import br.com.fiap.EngagementPatient.data.PACIENTE_MODEL_TABLE_NAME
import br.com.fiap.EngagementPatient.data.PacienteModel
import br.com.fiap.EngagementPatient.databinding.FragmentRegisterPacienteBinding

class RegisterPacienteFragment : Fragment() {

    private lateinit var binding: FragmentRegisterPacienteBinding



    private val pacienteInfoArgument by lazy {
       // arguments?.getParcelable(PACIENTE_MODEL_BUNDLE_KEY)
    }
    private val appDb: AppDatabase? by lazy {
        view?.context?.let {
            AppDatabase.getDatabase(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterPacienteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews(){
        binding.registerButton.setOnClickListener{
            insertData()
        }
        clearForm()
    }

    private fun insertData() {
        binding.run {
            val pacienteModel = PacienteModel(
                nome = editTextUser.text.toString(),
                telefone = editTextTelefone.text.toString(),
                dataNascimento = editTextDataNasc.text.toString(),
                doenca = editTextOcorrencia.text.toString(),
            )

            appDb?.pacienteDAO()?.insert(pacienteModel)
            showSnackBar(
                binding.registerButton,
                getString(R.string.register_paciente_success_registered_message,
                    pacienteModel.nome
                    )
            )

        }
        findNavController().popBackStack()
    }

    private fun clearForm() {
        binding.run {
            editTextUser.text?.clear()
            editTextTelefone.text?.clear()
            editTextDataNasc.text?.clear()
            editTextOcorrencia.text?.clear()
        }

    }


}
