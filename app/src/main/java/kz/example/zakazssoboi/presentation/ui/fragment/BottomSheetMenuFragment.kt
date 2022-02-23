package kz.example.zakazssoboi.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kz.example.zakazssoboi.R
import kz.example.zakazssoboi.databinding.FragmentBottomSheetMenuBinding

class BottomSheetMenuFragment(
    private val onClickMenuItem: (Int) -> Unit,
    private val itemsMenu: ArrayList<String>
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
//        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, itemsMenu)
//        menuLV.adapter = adapter
//        menuLV.onItemClickListener =
//            AdapterView.OnItemClickListener { _, _, position, _ ->
//                onClickMenuItem(position)
//                dismiss()
//            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}