package com.emedinaa.kotlinapp.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.emedinaa.kotlinapp.databinding.FragmentEditBinding
import com.emedinaa.kotlinapp.di.Injector
import com.emedinaa.kotlinapp.domain.model.Product
import com.emedinaa.kotlinapp.domain.usecase.UpdateProductUseCase
import com.emedinaa.kotlinapp.presentation.viewmodel.EditProductViewModel
import com.emedinaa.kotlinapp.presentation.viewmodel.EditProductViewModelFactory

class EditFragment : Fragment() {

    private val viewModel by viewModels<EditProductViewModel>{
        EditProductViewModelFactory(UpdateProductUseCase(Injector.provideProductRepository()))
    }

    private var _binding: FragmentEditBinding? = null
    private val binding get() = _binding!!

    private var product: Product? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        product = arguments?.getSerializable("PRODUCT") as? Product
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEditBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        render()

        binding.btnEditProduct.setOnClickListener {
            var title = binding.etTitleEdit.text.toString()
            var cost = binding.etCostEdit.text.toString().toDoubleOrNull()?:0.0

            if(isValidate(title, cost)) {
                product?.let {
                    viewModel.editProduct(title, cost, it)
                    findNavController().popBackStack()
                }
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

    private fun render() {
        product?.let {
            binding.etTitleEdit.setText(it.name)
            binding.etCostEdit.setText(it.cost.toString())
        }

    }
}