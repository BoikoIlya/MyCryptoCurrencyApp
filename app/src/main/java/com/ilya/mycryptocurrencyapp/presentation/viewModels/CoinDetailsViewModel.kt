package com.ilya.mycryptocurrencyapp.presentation.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilya.mycryptocurrencyapp.domain.usecases.GetCoinByIdUseCase
import com.ilya.mycryptocurrencyapp.presentation.states.CoinDetailsState
import com.ilya.mycryptocurrencyapp.utils.Constance
import com.ilya.mycryptocurrencyapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinByIdUseCase: GetCoinByIdUseCase,
    savedStateHandle: SavedStateHandle
):ViewModel() {

    private val _state = mutableStateOf(CoinDetailsState())
    val state: State<CoinDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constance.PARAM_COIN_ID)?.let { coinId->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String) = viewModelScope.launch {
        getCoinByIdUseCase(coinId).collect(){ result->
            when(result){
                is Resource.Success -> {
                    _state.value = CoinDetailsState(data = result.data)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailsState(error = result.message?: "")
                }
                is Resource.Loading ->{
                    _state.value = CoinDetailsState(isLoading = true)
                }
            }
        }
    }
}