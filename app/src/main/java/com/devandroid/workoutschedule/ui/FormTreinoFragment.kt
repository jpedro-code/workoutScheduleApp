package com.devandroid.workoutschedule.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.devandroid.workoutschedule.R
import com.devandroid.workoutschedule.databinding.FragmentExerciciosCadastradosBinding
import com.devandroid.workoutschedule.databinding.FragmentFormTreinoBinding
import com.devandroid.workoutschedule.helper.FirebaseHelper
import com.devandroid.workoutschedule.model.Treino
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue

class FormTreinoFragment : Fragment() {
    private var _binding : FragmentFormTreinoBinding? = null
    private val binding get() = _binding!!

    private lateinit var treino : Treino

    private var newTreino : Boolean = true

    private val args : FormTreinoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormTreinoBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        getArgs()
    }

    private fun getArgs(){
        args.treino.let {
            if(it != null){
                treino = it
                configTreino()
            }
        }
    }

    private fun configTreino(){
        newTreino = false
        binding.txtTitle.text = treino.nome
        binding.edtNomeExercicio.setText(treino.nome)
        binding.edtDescricao.setText(treino.descricao)
        binding.edtData.setText(treino.data)
    }
    private fun initListeners(){
        binding.btnSalvar.setOnClickListener{
            validateDatas()
        }
    }

    private fun validateDatas(){

        val descricao = binding.edtDescricao.text.toString().trim()
        val nome = binding.edtNomeExercicio.text.toString().trim()
        val data = binding.edtData.text.toString().trim()

        if(descricao.isNotEmpty() || nome.isNotEmpty()){
            if(newTreino) treino = Treino()
            treino.nome = nome
            treino.descricao = descricao
            treino.data = data
            saveTreino()
        }else {
            Toast.makeText(requireContext(), "Descrição ou Nomes Vazios", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveTreino(){
        FirebaseHelper
            .getDatabase()
            .child("treino")
            .child(FirebaseHelper.getIdUser()?: "")
            .child(treino.id)
            .setValue(treino)
            .addOnCompleteListener{treino->
                if(treino.isSuccessful){
                    if(newTreino){
                        Toast.makeText(requireContext(),"Salvo no Banco",Toast.LENGTH_LONG).show()
                        findNavController().popBackStack()
                    }else{
                        Toast.makeText(requireContext(),"Modificado no Banco",Toast.LENGTH_LONG).show()
                        findNavController().popBackStack()
                    }

                }else{
                    Toast.makeText(requireContext(),"Erro Ao salvar no banco",Toast.LENGTH_LONG).show()
                }
            }.addOnFailureListener{
                Toast.makeText(requireContext(),"Erro Ao salvar no banco",Toast.LENGTH_LONG).show()
            }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}