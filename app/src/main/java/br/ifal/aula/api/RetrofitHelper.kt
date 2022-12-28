package br.ifal.aula.api

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class RetrofitHelper {

    private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://viacep.com.br/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()


    val addressService = retrofit.create(AddressService::class.java)
}