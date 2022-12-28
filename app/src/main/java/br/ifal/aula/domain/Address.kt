package br.ifal.aula.domain

class Address (
    val cep: String,
    val logradouro: String,
    val complemento: String,
    val bairro: String,
    val uf: String,
    val ibge: String,
    val gia: String,
    val ddd: String,
    val siafi: String,
    val localidade: String,
) {

    override fun toString(): String {
        return "Address(cep='$cep', logradouro='$logradouro', complemento='$complemento', bairro='$bairro', uf='$uf', ibge='$ibge', gia='$gia', ddd='$ddd', siafi='$siafi', localidade='$localidade')"
    }
}