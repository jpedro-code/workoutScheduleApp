//package com.devandroid.workoutschedule.ui.adapter
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.devandroid.workoutschedule.databinding.ItemAdapterTreinoBinding
//import com.devandroid.workoutschedule.model.Exercicio
//import com.google.firebase.database.core.Context
//
//class ExercicioAdapter(
//    private val ExercicioList: List<Exercicio>,
//    val exercicioSelecionado : (Exercicio,Int) -> Unit
//
//): RecyclerView.Adapter<TreinoAdapter.MyViewHolder>() {
//    inner class MyViewHolder(val binding: ItemAdapterTreinoBinding): RecyclerView.ViewHolder(binding.root)
//
////    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) {
//////        return MyViewHolder(
//////            ItemAdapterTreinoBinding.inflate(
//////                LayoutInflater.from(parent.context),parent,false
//////            )
//////        )
////    }
//
//    override fun getItemCount(): Int {
//        return ExercicioList.size
//    }
//
//    override fun onBindViewHolder(holder: TreinoAdapter.MyViewHolder, position: Int) {
//        val treino = ExercicioList[position]
//        holder.binding.txtNomeTreino.text = treino.nome
//        holder.binding.txtDescTreino.text = treino.descricao
//        holder.binding.txtDataTreino.text = treino.totalCalorias
//
//        holder.binding.txtRemover.setOnClickListener { exercicioSelecionado(treino,
//            TreinoAdapter.REMOVE
//        ) }
//        holder.binding.txtEditar.setOnClickListener { exercicioSelecionado(treino, TreinoAdapter.EDIT) }
//        holder.binding.txtEditar.setOnClickListener { exercicioSelecionado(treino,
//            TreinoAdapter.DETAILS
//        ) }
//    }
//
//}