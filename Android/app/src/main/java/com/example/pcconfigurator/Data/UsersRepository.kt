package com.example.pcconfigurator.Data

import com.example.pcconfigurator.Data.Models.User
import java.util.*

object UsersRepository {

    val users = listOf<User>(User(UUID.fromString("be0b6c37-f50d-4511-9e3b-31cff4de6b11"),
        "admin",
        "admin"))
}