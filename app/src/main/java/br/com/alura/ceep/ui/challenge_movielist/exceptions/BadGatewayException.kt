package br.com.alura.ceep.ui.coffemachine.exceptions

class BadGatewayException(msg: String = "Erro de servidor") : Exception() {

  override val message: String = msg

}