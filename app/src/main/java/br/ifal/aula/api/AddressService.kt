package br.ifal.aula.api

import br.ifal.aula.api.model.AddressDTO
import br.ifal.aula.domain.Address
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AddressService {

    @GET(value = "ws/{cep}/json/")
    fun findAddressByCep(@Path("cep") cep : String) : Call<AddressDTO>

}