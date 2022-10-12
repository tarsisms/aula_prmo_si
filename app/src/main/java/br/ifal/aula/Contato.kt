package br.ifal.aula

class Contato (val nome : String, val msg : String, val status : String) {

    override fun toString() : String {
        return "$nome \n$msg"
    }
}