package com.example.rebalancear.core

sealed class ResultError (val message: String) {
    class CannotFindAssetCode(message: String = "Não foi possivel encontrar esse código") : ResultError(message)
    class CannotFindData(message: String = "Não foi possivel carregar os dados") : ResultError(message)
    class CodeAlreadyAdd (message: String = "Código já adicionado") : ResultError(message)
    class EmptyCode(message: String = "Digite um código válido") : ResultError(message)
    class CannotFindAsset(message: String = "Não conseguimos encontrar o ativo") : ResultError(message)
}
