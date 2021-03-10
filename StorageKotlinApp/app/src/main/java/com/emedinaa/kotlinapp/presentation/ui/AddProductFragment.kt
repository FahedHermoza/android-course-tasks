package com.emedinaa.kotlinapp.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.emedinaa.kotlinapp.databinding.FragmentAddProductBinding
import com.emedinaa.kotlinapp.di.Injector
import com.emedinaa.kotlinapp.domain.usecase.AddProductUseCase
import com.emedinaa.kotlinapp.presentation.viewmodel.AddProductViewModel
import com.emedinaa.kotlinapp.presentation.viewmodel.AddProductViewModelFactory

class AddProductFragment : Fragment() {

    private val viewModel by viewModels<AddProductViewModel>{
        AddProductViewModelFactory(AddProductUseCase(Injector.provideProductRepository()))
    }

    private var _binding: FragmentAddProductBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddProductBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()

        binding.btnAddProduct.setOnClickListener {
            var title = binding.etTitle.text.toString()
            var cost = binding.etCost.text.toString().toDoubleOrNull()?:0.0

            if(isValidate(title, cost)) {
                viewModel.addNewProduct(title, cost, "LoremImpsun")
                findNavController().popBackStack()
            }
        }
    }

    private fun isValidate(title: String, cost: Double): Boolean {
        if(title.isNullOrEmpty())
            return false

        if(cost<0.0)
            return false

        return true
    }

    private fun setObservers() {
    }

    private fun showMessageError(error: String?) {
        Toast.makeText(context, error, Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}