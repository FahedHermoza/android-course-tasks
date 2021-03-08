package com.emedinaa.kotlinapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.emedinaa.kotlinapp.databinding.FragmentStudentDetailBinding
import com.emedinaa.kotlinapp.model.Student

class StudentDetailFragment : Fragment() {
    private var listener: OnStudentListener? = null

    private var _binding: FragmentStudentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStudentDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    fun renderStudent(student: Student) {
        binding.tvName.text = student.name
        binding.tvPhone.text = student.phone
        binding.tvEmail.text = student.email
        binding.tvWebsite.text = student.webSite
        binding.ivLogo.setImageResource(student.photo)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnStudentListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnContactListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}