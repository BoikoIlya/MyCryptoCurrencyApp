package com.ilya.mycryptocurrencyapp.presentation.viewModels

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilya.mycryptocurrencyapp.domain.usecases.GetCoinsUseCase
import com.ilya.mycryptocurrencyapp.presentation.states.CoinListState
import com.ilya.mycryptocurrencyapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinsViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

   private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() = viewModelScope.launch {
        getCoinsUseCase().collect(){ result->
            Log.e("tag", "$result", )
           when(result){
               is Resource.Success-> {
                   Log.d("tag", "${result.data}")
                  _state.value = CoinListState(coins = result.data?: emptyList())
               }
               is Resource.Error-> {
                   Log.d("tag", "${result.message}")
                   _state.value = CoinListState(error = result.message?:"")
               }
               is Resource.Loading->{
                   Log.d("tag", "Loading...")
                   _state.value = CoinListState(isLoading = true)
               }
           }
        }
    }
}