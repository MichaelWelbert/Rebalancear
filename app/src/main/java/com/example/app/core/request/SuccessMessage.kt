package com.example.app.core.request

sealed class SuccessMessage(val message: String) {
    class AssetAdd(message: String = "Parabens seu ativo foi adicionado com sucesso") :
        SuccessMessage(message)

    class AssetDelete(message: String = "Parabens seu ativo foi deletado com sucesso") :
        SuccessMessage(message)

    class AssetUpdate(message: String = "Parabens seu ativo foi alterado com sucesso") :
        SuccessMessage(message)
}
