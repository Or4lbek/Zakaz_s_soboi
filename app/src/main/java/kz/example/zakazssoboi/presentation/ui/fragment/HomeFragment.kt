package kz.example.zakazssoboi.presentation.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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
    private val viewModel: RestaurantListViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        init()
        setObserver()
    }

    private fun init() = with(binding) {
        restaurantListAdapter = RestaurantsListAdapter(::onNoteClick)
        recyclerViewRestaurants.adapter = restaurantListAdapter
        progressBarHome.isVisible = restaurantListAdapter.currentList.isEmpty()
    }

    private fun setObserver() = with(viewModel) {
        liveDataRestaurantList.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.progressBarHome.visibility = View.GONE
                if (restaurantListAdapter.currentList.isEmpty()) {
                    restaurantListAdapter.submitList(it)
                }
            } else {
                Toast.makeText(requireContext(), "Error in getting list...", Toast.LENGTH_SHORT)
                    .show()
            }
        }
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