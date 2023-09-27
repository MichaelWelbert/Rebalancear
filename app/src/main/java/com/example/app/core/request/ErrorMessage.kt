package com.example.app.core.request

sealed class ErrorMessage(val message: String) {
    class CannotFindAssetCode(message: String = "Não foi possivel encontrar esse código") :
        ErrorMessage(message)

    class CannotFindData(message: String = "Não foi possivel carregar os dados") :
        ErrorMessage(message)

    class CannotFindStocks(message: String = "Não foi possivel carregar essa ação, código incorreto") :
        ErrorMessage(message)

    class CannotFindCode(message: String = "Não foi possivel carregar um dos ativos") :
        ErrorMessage(message)

    class CodeAlreadyAdd(message: String = "Código já adicionado") : ErrorMessage(message)
    class CodeNotFound(message: String = "Código não encontrado") : ErrorMessage(message)

    class InvalidGoal(message: String = "Meta invalida") : ErrorMessage(message)

    class InvalidUnit(message: String = "Quantidade invalida") : ErrorMessage(message)

    class CannotFindPatrimony(message: String = "Não foi possivel encontrar o patrimonio") : ErrorMessage(message)

    class WalletNotUpdated(message: String = "Não foi possivel atualizar os ativos da sua carteira") : ErrorMessage(message)
    class EmptyCode(message: String = "Digite um código válido") : ErrorMessage(message)
    class CannotFindAsset(message: String = "Desculpe-nos pelo transtorno, não conseguimos encontrar o ativo") :
        ErrorMessage(message)

    class ServerErrorMessage(message: String = "Desculpe-nos pelo transtorno. Não foi possivel carregar os dados. Por favor, tente novamente mais tarde.") :
        ErrorMessage(message)
}
