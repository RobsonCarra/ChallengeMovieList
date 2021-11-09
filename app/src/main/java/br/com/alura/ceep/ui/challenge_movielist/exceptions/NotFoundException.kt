package br.com.alura.ceep.ui.coffemachine.exceptions

class NotFoundException(msg: String = "Exames não encontrados") : Exception() {

    override val message: String = msg

}