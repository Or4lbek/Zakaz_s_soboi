package kz.example.zakazssoboi.presentation.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import kz.example.zakazssoboi.R
import kz.example.zakazssoboi.databinding.FragmentBasketBinding
import kz.example.zakazssoboi.presentation.view_model.BasketViewModel

class BasketFragment : Fragment(R.layout.fragment_basket) {

    private lateinit var viewModel: BasketViewModel
    private var _binding: FragmentBasketBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentBasketBinding.bind(view)
        viewModel = ViewModelProvider(this)[BasketViewModel::class.java]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}