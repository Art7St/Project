package com.test.strangerthings.presentation.quote

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.strangerthings.databinding.FragmentQuotesBinding
import com.test.strangerthings.presentation.quote.adapter.QuotesAdapter


class QuotesFragment : Fragment() {
    private var _binding: FragmentQuotesBinding? = null
    private val binding get() = _binding!!

    private lateinit var quotesViewModel: QuotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val adapter = QuotesAdapter(findNavController())
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        val mainViewModelProvider = QuotesViewModelFactory()

        quotesViewModel =
            ViewModelProvider(this, mainViewModelProvider)[QuotesViewModel::class.java]

        quotesViewModel.myResponse.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                response.body()?.let { adapter.setData(it) }
                Log.d("Response", response.body().toString())
            } else {
                Log.d("Response", response.errorBody().toString())
            }

        }
    }
}