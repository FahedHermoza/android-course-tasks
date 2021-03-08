package com.emedinaa.kotlinapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.emedinaa.kotlinapp.databinding.FragmentStudentsBinding
import com.emedinaa.kotlinapp.model.Data
import com.emedinaa.kotlinapp.model.Student


class StudentsFragment : Fragment() {
    private var listener: OnStudentListener? = null
    private lateinit var adapter: StudentsAdapter

    private var _binding: FragmentStudentsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStudentsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter.update(Data.getStudent())
        var firstStudent = Data.getStudent()[0]
        listener?.renderFirst(firstStudent)

    }

    private fun setupView() {
        adapter = StudentsAdapter(emptyList(), onItemAction())
        binding.rvStudents.adapter = adapter
    }

    private fun onItemAction(): (item: Student) -> Unit {
        return {
            listener?.selectedItemProduct(it)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnStudentListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnProductListener")
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