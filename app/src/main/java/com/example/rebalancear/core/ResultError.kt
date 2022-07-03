package com.example.rebalanceamentodecarteira.core

sealed class ResultError(val message: String) {
    class ServerError(
        message: String = "Ocorreu um erro de servidor"
    ) : ResultError(message)

    class AssetCodeError(
        message: String = "Código não encontrado, certifique-se de digitar o código corretamente"
    ) : ResultError(message)

    class AssetAlreadyRegisterError(
        message: String = "Esse ativo já está cadastrado, verifique sua lista de ativos"
    ) : ResultError(message)

    class AssetGoalGreaterThanMaxPercentError(
        message: String = "Seu objetivo, faz com que sua carteira ultrapasse 100%, escolha um objetivo menor ou diminuia o objetivo de outro ativo"
    ) : ResultError(message)

    class UnexpectedError(
        message: String = "Ocorreu um Error inesperado"
    ) : ResultError(message)
}