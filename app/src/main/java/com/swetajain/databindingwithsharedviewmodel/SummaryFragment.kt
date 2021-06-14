package com.swetajain.databindingwithsharedviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.swetajain.databindingwithsharedviewmodel.databinding.FragmentSummaryBinding
import com.swetajain.databindingwithsharedviewmodel.viewmodel.MainViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [SummaryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SummaryFragment : Fragment() {
    private var _binding: FragmentSummaryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_summary,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            mainViewModel = viewModel
            summaryFragment = this@SummaryFragment
        }
    }

    fun goToHome() {
        findNavController().navigate(R.id.action_summaryFragment_to_homeFragment)
    }

    fun goToSelection() {
        findNavController().navigate(R.id.action_summaryFragment_to_selectionFragment)
    }
}