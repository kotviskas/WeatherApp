package com.example.weatherapp.presentation.city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentCityBinding
import com.example.weatherapp.presentation.utils.ErrorUtil
import org.koin.androidx.viewmodel.ext.android.viewModel

class CityFragment : Fragment(R.layout.fragment_city) {
    private lateinit var binding: FragmentCityBinding
    private val viewModel by viewModel<CityViewModel>()

    private lateinit var cityName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cityName = CityFragmentArgs.fromBundle(it).cityName
            viewModel.getWeather(cityName)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCityBinding.inflate(inflater, container, false)
        viewModel.weather.observe(viewLifecycleOwner) {
            binding.tvCityTest.text = it.temp.toString()
        }
        viewModel.internetError.observe(viewLifecycleOwner) {
            ErrorUtil.handleError(requireContext(),it)
        }
        return binding.root
    }
}