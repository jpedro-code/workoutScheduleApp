package com.devandroid.workoutschedule.ui.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devandroid.workoutschedule.databinding.ItemAdapterTreinoBinding
import com.devandroid.workoutschedule.model.Treino

class TreinoAdapter(
    private val context: Context,
    private val treinoList : List<Treino>,
    val treinoSelecionado : (Treino,Int) -> Unit
) : RecyclerView.Adapter<TreinoAdapter.MyViewHolder>() {

    companion object {
        val REMOVE = 0
        val EDIT = 1
        val DETAILS = 2
    }

    inner class MyViewHolder(val binding: ItemAdapterTreinoBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemAdapterTreinoBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    override fun getItemCount(): Int {
        return treinoList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val treino = treinoList[position]
        holder.binding.txtNomeTreino.text = treino.nome
        holder.binding.txtDescTreino.text = treino.descricao
        holder.binding.txtDataTreino.text = treino.data

        holder.binding.txtRemover.setOnClickListener { treinoSelecionado(treino, REMOVE) }
        holder.binding.txtEditar.setOnClickListener { treinoSelecionado(treino, EDIT) }
        holder.binding.txtEditar.setOnClickListener { treinoSelecionado(treino, DETAILS) }
    }
}