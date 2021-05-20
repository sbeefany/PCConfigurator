package com.example.pcconfigurator.Data.Models

import java.util.*

data class User(val uuid: UUID, var login: String, var password: String) {
}