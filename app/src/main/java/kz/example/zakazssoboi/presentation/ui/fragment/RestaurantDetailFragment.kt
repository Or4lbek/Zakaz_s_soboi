package kz.example.zakazssoboi.presentation.ui.fragment

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import kz.example.zakazssoboi.R
import kz.example.zakazssoboi.common.Constants.BOTTOM_SHEET_FRAGMENT
import kz.example.zakazssoboi.data.network.dto.restaurantDto.toRestaurantDetails
import kz.example.zakazssoboi.databinding.FragmentRestaurantDetailBinding
import kz.example.zakazssoboi.domain.entity.Product
import kz.example.zakazssoboi.domain.entity.RestaurantDetails
import kz.example.zakazssoboi.presentation.ui.adapter.CategoryAdapter
import kz.example.zakazssoboi.presentation.ui.adapter.ChildMenuAdapter
import kz.example.zakazssoboi.presentation.ui.adapter.ParentMenuAdapter
import kz.example.zakazssoboi.presentation.ui.adapter.ViewPagerRestaurantAdapter
import kz.example.zakazssoboi.presentation.view_model.RestaurantDetailViewModel

class RestaurantDetailFragment : Fragment(R.layout.fragment_restaurant_detail),
    ChildMenuAdapter.ChildMenuAdapterListener {

    private var _binding: FragmentRestaurantDetailBinding? = null
    private val binding get() = _binding!!
    private val parentMenuAdapter: ParentMenuAdapter = ParentMenuAdapter(this)
    private val viewPagerRestaurantAdapter = ViewPagerRestaurantAdapter()

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var menuLayoutManager: LinearLayoutManager
    private val viewModel: RestaurantDetailViewModel by viewModels()
    private lateinit var restaurant: RestaurantDetails

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRestaurantDetailBinding.bind(view)
        binding.initUI()
        setObserver()
    }

    private fun FragmentRestaurantDetailBinding.initUI() {
        categoryAdapter = CategoryAdapter(::onClickCategory)
        recyclerViewCategory.adapter = categoryAdapter
        recyclerViewMenu.adapter = parentMenuAdapter
        viewPagerRestaurantImages.adapter = viewPagerRestaurantAdapter

        menuLayoutManager = LinearLayoutManager(requireContext())
        recyclerViewMenu.layoutManager = menuLayoutManager

        buttonBurger.setOnClickListener { onClickBtnBurger() }
        buttonBasket.setOnClickListener { onClickBtnBasket() }
        updateButtonData()
    }

    private fun setObserver() = with(viewModel) {
        binding.progressBarMenu.visibility = View.VISIBLE
        liveDataViewPagerImages.observe(viewLifecycleOwner) {
            binding.progressBarMenu.visibility = View.GONE
            if (viewPagerRestaurantAdapter.currentList.isEmpty()) {
                viewPagerRestaurantAdapter.submitList(it)
            }

        }

        liveDataCategoriesList.observe(viewLifecycleOwner) {
            if (parentMenuAdapter.currentList.isEmpty()) {
                parentMenuAdapter.submitList(it)
            }
            if (categoryAdapter.currentList.isEmpty()) {
                categoryAdapter.submitList(it)
            }
        }
        scrollListener()

        liveDataRestaurant.observe(viewLifecycleOwner) {
            restaurant = it.toRestaurantDetails()
        }
    }

    var categoryScrollingPos = 0
    var isCategoryScrolling = false

    private fun onClickCategory(pos: Int) {
        categoryScrollingPos = pos
        isCategoryScrolling = true
        binding.recyclerViewMenu.smoothSnapToPosition(pos)
    }

    private fun RecyclerView.smoothSnapToPosition(
        position: Int,
        snapMode: Int = LinearSmoothScroller.SNAP_TO_START
    ) {
        val smoothScroller = object : LinearSmoothScroller(this.context) {
            override fun getVerticalSnapPreference(): Int = snapMode
            override fun getHorizontalSnapPreference(): Int = snapMode
            override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics?): Float {
                return 500 / this@smoothSnapToPosition.computeVerticalScrollRange().toFloat()
            }
        }
        smoothScroller.targetPosition = position
        layoutManager?.startSmoothScroll(smoothScroller)
    }

    private fun onClickBtnBurger() {
        val bottomSheetMenuFragment = BottomSheetMenuFragment(
            { onClickMenuItem(it) },
            categoryAdapter.currentList
        )
        bottomSheetMenuFragment.show(parentFragmentManager, BOTTOM_SHEET_FRAGMENT)
    }

    private fun onClickMenuItem(position: Int) {
        onClickCategory(position)
    }

    private fun onClickBtnBasket() {
        val action =
            RestaurantDetailFragmentDirections.actionRestaurantDetailFragmentToBasketFragment(
                viewModel.selectedProducts.toTypedArray(),
                restaurant.name,
                restaurant.address
            )
        findNavController().navigate(action)
    }

    private fun scrollListener() {
        binding.recyclerViewMenu.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val posFirst =
                    menuLayoutManager.findFirstVisibleItemPosition()
                if (posFirst == categoryScrollingPos) {
                    isCategoryScrolling = false
                }
                if (!isCategoryScrolling) {
                    if (categoryAdapter.itemCount - 1 == menuLayoutManager.findLastVisibleItemPosition()) {
                        categoryAdapter.selectItem(categoryAdapter.itemCount - 1)
                        binding.recyclerViewCategory.scrollToPosition(categoryAdapter.itemCount - 1)
                    } else {
                        categoryAdapter.selectItem(posFirst)
                        binding.recyclerViewCategory.scrollToPosition(posFirst)
                    }
                }
            }
        })
    }

    override fun onClickPlus(product: Product) = with(binding) {
        viewModel.addProduct(product)
        updateButtonData()
    }

    override fun onClickMinus(product: Product) = with(binding) {
        viewModel.removeProduct(product)
        updateButtonData()
    }

    private fun updateButtonData() = with(binding) {
        textViewProductListCount.text = viewModel.getSelectedProductsCount()
        textViewProductListTotalPrice.text = viewModel.totalPrice.toString()
        buttonBasket.isVisible = viewModel.totalPrice > 0
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}