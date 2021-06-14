package com.swetajain.databindingwithsharedviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.swetajain.databindingwithsharedviewmodel.databinding.FragmentSelectionBinding
import com.swetajain.databindingwithsharedviewmodel.viewmodel.MainViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [SelectionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectionFragment : Fragment() {
    private var _binding: FragmentSelectionBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_selection,
            container,
            false
        )
        val view = binding.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            mainViewModel = viewModel
            selectionFragment = this@SelectionFragment
        }
    }

    fun goToSummary() {
        findNavController().navigate(R.id.action_selectionFragment_to_summaryFragment)
    }

    fun goToHome() {
        findNavController().navigate(R.id.action_selectionFragment_to_homeFragment)
    }
}