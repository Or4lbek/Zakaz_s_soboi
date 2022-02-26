package kz.example.zakazssoboi.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kz.example.zakazssoboi.R
import kz.example.zakazssoboi.common.MarginItemDecoration
import kz.example.zakazssoboi.databinding.FragmentBottomSheetMenuBinding
import kz.example.zakazssoboi.domain.entity.Category
import kz.example.zakazssoboi.presentation.ui.adapter.CategoryMenuAdapter

class BottomSheetMenuFragment(
    private val onClickMenuItem: (Int) -> Unit,
    private val itemsMenu: List<Category>
) : BottomSheetDialogFragment() {

    private var _binding: FragmentBottomSheetMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_bottom_sheet_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentBottomSheetMenuBinding.bind(view)
        init()
    }

    private fun init() = with(binding) {
        val adapter = CategoryMenuAdapter {
            onClickMenuItem(it)
            dismiss()
        }
        adapter.submitList(itemsMenu)
        recyclerViewCategory.apply {
            this.adapter = adapter
            addItemDecoration(
                MarginItemDecoration(
                    binding.root.context,
                    LinearLayoutManager.VERTICAL,
                    3
                )
            )
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}