package br.ifal.aula.api.model

import br.ifal.aula.domain.Address

data class AddressDTO(
    val cep: String?,
    val logradouro: String,
    val complemento: String,
    val bairro: String,
    val localidade: String,
    val uf: String,
    val ibge: String,
    val gia: String,
    val ddd: String,
    val siafi: String,
) {
    val address : Address get() = Address(
        cep = cep ?: "",
        logradouro = logradouro ?: "",
        bairro = complemento ?: "",
        uf = bairro ?: "",
        ibge = uf ?: "",
        gia = ibge ?: "",
        ddd = gia ?: "",
        siafi = ddd ?: "",
        localidade = siafi ?: "",
        complemento = localidade ?: "",
    )
}