package com.ilya.mycryptocurrencyapp.domain.usecases

import com.ilya.mycryptocurrencyapp.data.network.dto.CoinDto.toCoinDetails
import com.ilya.mycryptocurrencyapp.domain.model.Coin
import com.ilya.mycryptocurrencyapp.domain.model.CoinDetails
import com.ilya.mycryptocurrencyapp.domain.repositiory.Repository
import com.ilya.mycryptocurrencyapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinByIdUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> =
         flow{
            try {
                emit(Resource.Loading<CoinDetails>())
                val coin = repository.getCoinById(coinId).toCoinDetails()
                emit(Resource.Success<CoinDetails>(coin))
            }catch (e: HttpException)
            {
                emit(Resource.Error<CoinDetails>(message = "Unexpected response"))
            }catch (e: IOException){
                emit(Resource.Error<CoinDetails>(message = "Couldn't reach server. Check your internet connection"))
            }
        }

}