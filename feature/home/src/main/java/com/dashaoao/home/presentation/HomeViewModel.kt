package com.dashaoao.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dashaoao.home.domain.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {
    private val _res = MutableStateFlow("error")
    val res: StateFlow<String> = _res

    fun getData() {
        viewModelScope.launch {
            repository.getData().collect {
                _res.value = it
            }
        }
    }
}
