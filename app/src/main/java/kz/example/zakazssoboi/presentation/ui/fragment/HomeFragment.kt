package kz.example.zakazssoboi.presentation.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kz.example.zakazssoboi.R
import kz.example.zakazssoboi.databinding.FragmentHomeBinding
import kz.example.zakazssoboi.domain.entity.Restaurant
import kz.example.zakazssoboi.presentation.ui.adapter.RestaurantsListAdapter
import kz.example.zakazssoboi.presentation.view_model.RestaurantListViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var restaurantListAdapter: RestaurantsListAdapter
    private lateinit var viewModel: RestaurantListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[RestaurantListViewModel::class.java]
        _binding = FragmentHomeBinding.bind(view)

        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        restaurantListAdapter = RestaurantsListAdapter {
            onNoteClick(it)
        }
        binding.recyclerViewRestaurants.adapter = restaurantListAdapter

        if (restaurantListAdapter.currentList.isEmpty()) {
            binding.progressBarHome.visibility = View.VISIBLE
        }
    }

    private fun initViewModel() {
        binding.progressBarHome.visibility = View.GONE
        restaurantListAdapter.submitList(viewModel.restaurantList)
    }

    private fun onNoteClick(restaurant: Restaurant) {
        val action =
            HomeFragmentDirections.actionHomeFragmentToRestaurantDetailFragment(
                restaurant.id,
                restaurant.name
            )
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}