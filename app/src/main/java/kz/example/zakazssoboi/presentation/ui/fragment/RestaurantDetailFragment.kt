package kz.example.zakazssoboi.presentation.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kz.example.zakazssoboi.R
import kz.example.zakazssoboi.databinding.FragmentRestaurantDetailBinding
import kz.example.zakazssoboi.presentation.view_model.RestaurantDetailViewModel

class RestaurantDetailFragment : Fragment(R.layout.fragment_restaurant_detail) {
    private lateinit var viewModel: RestaurantDetailViewModel
    private var _binding: FragmentRestaurantDetailBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRestaurantDetailBinding.bind(view)
        viewModel = ViewModelProvider(this)[RestaurantDetailViewModel::class.java]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}