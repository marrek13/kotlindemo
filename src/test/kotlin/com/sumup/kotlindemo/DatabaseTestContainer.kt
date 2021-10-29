package com.sumup.kotlindemo

import org.testcontainers.containers.PostgreSQLContainer

class DatabaseTestContainer(

): PostgreSQLContainer<DatabaseTestContainer>("postgres:11.1") {
    override fun stop() {

    }

    companion object {
        private var container: DatabaseTestContainer? = null

        fun getInstance(): DatabaseTestContainer? {
            if(container == null) {
                container = DatabaseTestContainer().withReuse(true)
            }

            return container
        }
    }
}