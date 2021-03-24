package com.example.pcconfigurator.Data

class TestRepository() : ITestDataRepository {
    override fun getList(): List<Int> {
        return listOf(1,2,3,4,5,6,7,8,9)
    }
}