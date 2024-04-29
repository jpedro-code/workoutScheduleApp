package com.devandroid.workoutschedule.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.devandroid.workoutschedule.R
import com.devandroid.workoutschedule.databinding.FragmentTreinosCadastradosBinding
import com.devandroid.workoutschedule.helper.FirebaseHelper
import com.devandroid.workoutschedule.model.Treino
import com.devandroid.workoutschedule.ui.adapter.TreinoAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class TreinosCadastradosFragment : Fragment() {

    private var _binding : FragmentTreinosCadastradosBinding? = null
    private val binding get() = _binding!!

    private val treinoList = mutableListOf<Treino>()

    private lateinit var adapterTreinoBinding : TreinoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTreinosCadastradosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicks()
        getTreinos()
    }
    private fun initClicks(){
        binding.addTreino.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_formFragment)
        }
    }

    fun getTreinos(){
        FirebaseHelper
            .getDatabase()
            .child("treino")
            .child(FirebaseHelper.getIdUser()?: "")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if(snapshot.exists()){
                        for(snap in snapshot.children){
                            val treino = snap.getValue(Treino::class.java) as Treino
                            treinoList.add(treino)
                        }
                        binding.progressBar.isVisible = false
                        binding.txtInfo.text = ""
                        initAdapter()
                    }else{
                        binding.txtInfo.text = "Nenhuma Tarefa Cadastrada!"
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(requireContext(), "Erro ao tentar recuperar treinos", Toast.LENGTH_SHORT).show()
                }

            })
    }

    private fun initAdapter() {
        binding.rvTreinosCadastrados.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTreinosCadastrados.setHasFixedSize(true)
        adapterTreinoBinding = TreinoAdapter(requireContext(), treinoList) { task, select ->
            optionSelect(task, select)
        }
        binding.rvTreinosCadastrados.adapter = adapterTreinoBinding
    }

    private fun optionSelect(treino: Treino, select: Int) {
        when (select) {
            TreinoAdapter.REMOVE -> {
                deleteTreino(treino)
            }
            TreinoAdapter.EDIT -> {
                Toast.makeText(requireContext(), "Não Implementado", Toast.LENGTH_SHORT).show()
            }
            TreinoAdapter.DETAILS -> {

            }
        }
    }
    private fun deleteTreino(treino: Treino) {

        FirebaseHelper
            .getDatabase()
            .child("task")
            .child(FirebaseHelper.getIdUser() ?: "")
            .child(treino.id)
            .removeValue()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(
                        requireContext(),
                        "Atualizada com sucesso",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {

                }
            }.addOnFailureListener {
                binding.progressBar.isVisible = false
                Toast.makeText(requireContext(), "Erro ao tentar Deletar Treino", Toast.LENGTH_SHORT).show()
            }

        treinoList.remove(treino)
        adapterTreinoBinding.notifyDataSetChanged()

        Toast.makeText(requireContext(), "Deletada com sucesso", Toast.LENGTH_SHORT).show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}