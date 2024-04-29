package com.devandroid.workoutschedule.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.devandroid.workoutschedule.R
import com.devandroid.workoutschedule.databinding.FragmentRecoverAccountBinding
import com.devandroid.workoutschedule.helper.FirebaseHelper
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class RecoverAccountFragment : Fragment() {
    private var _binding: FragmentRecoverAccountBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecoverAccountBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth

        initClicks()
    }

    private fun initClicks(){
        binding.btnEnviar.setOnClickListener{ validateData() }
    }

    private fun validateData(){
        val email = binding.editEmail.text.toString().trim()

        if(email.isNotEmpty()){
            resetPasswordViaEmail(email)
        }else{
            Toast.makeText(requireContext(), "Informe seu Email", Toast.LENGTH_SHORT).show()
        }
    }

    private fun resetPasswordViaEmail(email : String){
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(requireContext(), "Verifique seu email!Um link de recuperação de senha foi enviado", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(requireContext(), FirebaseHelper.erroValidation(task.exception?.message?:"Erro Ao logar"), Toast.LENGTH_SHORT).show()
                    binding.progressBar.isVisible = false
                }
            }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}