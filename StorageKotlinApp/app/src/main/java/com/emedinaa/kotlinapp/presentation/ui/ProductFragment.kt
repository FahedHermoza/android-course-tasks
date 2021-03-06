package com.emedinaa.kotlinapp.presentation.ui

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.emedinaa.kotlinapp.R
import com.emedinaa.kotlinapp.databinding.FragmentProductBinding
import com.emedinaa.kotlinapp.di.Injector
import com.emedinaa.kotlinapp.domain.model.Product
import com.emedinaa.kotlinapp.domain.usecase.AddProductUseCase
import com.emedinaa.kotlinapp.domain.usecase.ClearProductUseCase
import com.emedinaa.kotlinapp.domain.usecase.FetchProductUseCase
import com.emedinaa.kotlinapp.domain.usecase.UpdateProductUseCase
import com.emedinaa.kotlinapp.presentation.viewmodel.ProductViewModel
import com.emedinaa.kotlinapp.presentation.viewmodel.ProductViewModelFactory


class ProductFragment : Fragment() {

    private val viewModel by viewModels<ProductViewModel>{
        ProductViewModelFactory(
            FetchProductUseCase(Injector.provideProductRepository()),
            ClearProductUseCase(Injector.provideProductRepository()),
            AddProductUseCase(Injector.provideProductRepository()),
            UpdateProductUseCase(Injector.provideProductRepository())
        )
    }

    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        _binding = FragmentProductBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fabProduct.setOnClickListener {
            goToAddProduct()
        }

        setupView()
        setObservers()
    }

    private fun setObservers() {
        viewModel.loadProducts().observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.update(it)
            }
        })
    }

    private fun goToAddProduct() {
        findNavController().navigate(R.id.action_productFragment_to_addProductFragment)
    }

    private fun setupView() {
        adapter = ProductsAdapter(emptyList(), onItemAction())
        binding.rvProduct.adapter = adapter
    }

    private fun onItemAction(): (item: Product) -> Unit {
        return {
            goToEditProduct(it)
        }
    }

    private fun goToEditProduct(product: Product) {
        findNavController().navigate(R.id.action_productFragment_to_editFragment, Bundle().apply {
            putSerializable("PRODUCT", product)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        return inflater.inflate(R.menu.menu_product, menu);
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_all_delete){
            viewModel.deleteAllProducts()
            showToast("Productos eliminados")
        }
        return false
    }

    private fun showToast(string: String) {
        Toast.makeText(context, string, Toast.LENGTH_LONG).show()
    }
}