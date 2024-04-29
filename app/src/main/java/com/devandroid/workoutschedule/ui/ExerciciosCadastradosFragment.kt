package com.devandroid.workoutschedule.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.devandroid.workoutschedule.R
import com.devandroid.workoutschedule.databinding.FragmentExerciciosCadastradosBinding

class ExerciciosCadastradosFragment : Fragment() {

    private var _binding : FragmentExerciciosCadastradosBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExerciciosCadastradosBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicks()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initClicks(){
        binding.addTreino.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_formExercicioFragment)
        }
    }

}