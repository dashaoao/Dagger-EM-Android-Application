package com.dashaoao.home.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.dashaoao.core.di.AppDependenciesProvider
import com.dashaoao.core.di.app.AppViewModelFactory
import com.dashaoao.home.databinding.HomeFragmentLayoutBinding
import com.dashaoao.home.di.HomeComponent
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragment : Fragment() {

    private var _binding: HomeFragmentLayoutBinding? = null
    private val binding: HomeFragmentLayoutBinding
        get() = _binding ?: throw RuntimeException("HomeFragmentLayoutBinding = null")

    @Inject
    lateinit var factory: AppViewModelFactory
    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this, factory)[HomeViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HomeComponent.init((requireActivity().application as AppDependenciesProvider).provide())
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentLayoutBinding.inflate(inflater, container, false)

        viewModel.getData()
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.res.collect {
                    Log.d("HomeFragment", "onCreateView: $it")
                }
            }
        }
        return binding.root
    }
}
