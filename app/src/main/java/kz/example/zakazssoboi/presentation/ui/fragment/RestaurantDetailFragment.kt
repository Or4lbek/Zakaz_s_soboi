package kz.example.zakazssoboi.presentation.ui.fragment

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import kz.example.zakazssoboi.R
import kz.example.zakazssoboi.common.Constants.BOTTOM_SHEET_FRAGMENT
import kz.example.zakazssoboi.databinding.FragmentRestaurantDetailBinding
import kz.example.zakazssoboi.domain.entity.Category
import kz.example.zakazssoboi.domain.entity.Product
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

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var menuLayoutManager: LinearLayoutManager
    private lateinit var viewModel: RestaurantDetailViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRestaurantDetailBinding.bind(view)
        viewModel = ViewModelProvider(this)[RestaurantDetailViewModel::class.java]
        init()
        initViewPager()
        binding.initUI()
        setObserver()
    }

    private fun init() {
        binding.buttonBurger.setOnClickListener { onClickBtnBurger() }
        binding.buttonBasket.setOnClickListener { onClickBtnBasket() }
        val args: RestaurantDetailFragmentArgs by navArgs()
        val restaurantId = args.id
    }

    private fun initViewPager() {
        val viewPagerRestaurantAdapter = ViewPagerRestaurantAdapter()
        viewPagerRestaurantAdapter.submitList(viewModel.viewPagerImages)
        binding.viewPagerRestaurantImages.adapter = viewPagerRestaurantAdapter
    }

    private fun FragmentRestaurantDetailBinding.initUI() {
        categoryAdapter = CategoryAdapter {
            onClickCategory(it)
        }
        recyclerViewCategory.adapter = categoryAdapter
        recyclerViewMenu.adapter = parentMenuAdapter

        menuLayoutManager = LinearLayoutManager(requireContext())
        recyclerViewMenu.layoutManager = menuLayoutManager
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
            RestaurantDetailFragmentDirections.actionRestaurantDetailFragmentToBasketFragment()
        findNavController().navigate(action)
    }

    private fun setObserver() {
        viewModel.liveData.observe(viewLifecycleOwner) { result ->
            val category = result.map { categoryProduct ->
                Category(
                    categoryProduct.id,
                    categoryProduct.category,
                    categoryProduct.products,
                    false
                )
            }
            categoryAdapter.submitList(category)
            parentMenuAdapter.submitList(result)
            scrollListener()
        }
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
                    categoryAdapter.selectItem(posFirst)
                    binding.recyclerViewCategory.scrollToPosition(posFirst)
                }
            }
        })
    }

    override fun onClickPlus(product: Product) = with(binding) {
        viewModel.totalPrice += product.price

        if (viewModel.totalPrice > 0) {

            buttonBasket.visibility = View.VISIBLE
            buttonBasket.text = viewModel.totalPrice.toString()
        }
    }

    override fun onClickMinus(product: Product) = with(binding) {
        viewModel.totalPrice -= product.price

        if (viewModel.totalPrice <= 0) {
            buttonBasket.visibility = View.GONE
            buttonBasket.text = viewModel.totalPrice.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}