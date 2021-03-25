package com.example.pcconfigurator.Data.Network.NetworkDTO

import java.util.*

class AccessoryDTO(
    var name: String,
    var vendor: String,
    var id: UUID,
    var accessoryType: AccessoryType,
    var price: Int
) {

}
