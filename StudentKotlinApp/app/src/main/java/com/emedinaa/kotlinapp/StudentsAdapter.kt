package com.emedinaa.kotlinapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emedinaa.kotlinapp.databinding.ItemStudentBinding
import com.emedinaa.kotlinapp.model.Student

/***
 * https://medium.com/swlh/how-to-use-view-binding-in-recyclerview-adapter-f818b96c678a
 */
class StudentsAdapter(private var students:List<Student>,
                      val itemAction: (item: Student) -> Unit)
    :RecyclerView.Adapter<StudentsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        var itemBinding: ItemStudentBinding = ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false);
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //render
        with(holder){
            with(students[position]) {
                binding.tvName.text = name
                binding.ivPhoto.setImageResource(photo)

                binding.root.setOnClickListener {
                    itemAction(this)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return students.size
    }

    fun update(data:List<Student>){
        students = data
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemStudentBinding)
        :RecyclerView.ViewHolder(binding.root)
}