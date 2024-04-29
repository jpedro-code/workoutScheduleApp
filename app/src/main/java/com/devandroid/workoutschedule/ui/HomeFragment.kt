package com.devandroid.workoutschedule.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.devandroid.workoutschedule.R
import com.devandroid.workoutschedule.databinding.FragmentHomeBinding
import com.devandroid.workoutschedule.ui.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlin.math.log

class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configTabLayout()
        auth = Firebase.auth
        initClicks()
    }

    private fun configTabLayout(){
        val adapter = ViewPagerAdapter(requireActivity())
        binding.viewPager.adapter = adapter

        adapter.addFragment(TreinosCadastradosFragment(), "Treinos Cadastrados")
        adapter.addFragment(ExerciciosCadastradosFragment(), "Exercícios Cadastrados")

        binding.viewPager.offscreenPageLimit = adapter.itemCount
        TabLayoutMediator(
            binding.tabs, binding.viewPager
        ){tab, position ->
            tab.text = adapter.getTitle(position)
        }.attach()

    }

    private fun initClicks(){
        binding.imgbLogout.setOnClickListener{
            logoutUser()
        }

    }

    private fun logoutUser(){
        auth.signOut()
        findNavController().navigate(R.id.action_homeFragment_to_splashFragment2)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}