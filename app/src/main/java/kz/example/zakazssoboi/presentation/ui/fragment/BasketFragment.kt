package kz.example.zakazssoboi.presentation.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kz.example.zakazssoboi.R
import kz.example.zakazssoboi.common.MarginItemDecoration
import kz.example.zakazssoboi.databinding.FragmentBasketBinding
import kz.example.zakazssoboi.domain.entity.Product
import kz.example.zakazssoboi.presentation.ui.adapter.ChildMenuAdapter
import kz.example.zakazssoboi.presentation.view_model.BasketViewModel

class BasketFragment : Fragment(R.layout.fragment_basket),
    ChildMenuAdapter.ChildMenuAdapterListener {

    private var _binding: FragmentBasketBinding? = null
    private val binding get() = _binding!!
    private val viewModel: BasketViewModel by viewModels()
    private var basketsMenuAdapter: ChildMenuAdapter = ChildMenuAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentBasketBinding.bind(view)
        init()
    }

    private fun init() = with(binding) {
        textViewRestaurantName.text = viewModel.restaurantName.toString()
        textViewRestaurantAddress.text = viewModel.restaurantAddress.toString()
        textViewBasketOrderPrice.text = viewModel.totalPrice.toString()
        basketsMenuAdapter.submitList(viewModel.products.toMutableList())
        recyclerViewOrder.adapter = basketsMenuAdapter
        recyclerViewOrder.addItemDecoration(
            MarginItemDecoration(
                binding.root.context,
                LinearLayoutManager.VERTICAL,
                20
            )
        )
    }

    override fun onClickPlus(product: Product) = with(binding) {
        viewModel.addProduct(product)
    }

    override fun onClickMinus(product: Product) = with(binding) {
        viewModel.removeProduct(product)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}