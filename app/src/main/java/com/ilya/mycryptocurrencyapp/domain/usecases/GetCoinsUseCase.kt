package com.ilya.mycryptocurrencyapp.domain.usecases


import android.util.Log
import com.ilya.mycryptocurrencyapp.data.network.dto.CoinsDto.toCoin
import com.ilya.mycryptocurrencyapp.domain.model.Coin
import com.ilya.mycryptocurrencyapp.domain.repositiory.Repository
import com.ilya.mycryptocurrencyapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import java.util.Collections.emptyList
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> =
         flow {
            try {
                emit(Resource.Loading<List<Coin>>())
              val coins = repository.getCoins().map { it.toCoin() }
                Log.e("tag", "$coins", )

              emit(Resource.Success<List<Coin>>(coins))
            }catch (e: HttpException){
                emit(Resource.Error<List<Coin>>(message = "Unexpected response"))
                Log.e("tag", "HTTP", )
            }catch (e: IOException){
                emit(Resource.Error<List<Coin>>(message = "Couldn't reach server. Check your internet connection"))
                Log.e("tag", "IO", )
            }
    }

}
