package com.joveo.testcontainer.dao.singletontestcontainer;

import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresTestContainer {
    private static final PostgreSQLContainer postgreSQLContainer =
            (PostgreSQLContainer)
                    new PostgreSQLContainer("postgres:10.4")
                            .withStartupTimeoutSeconds(600);

    static {
        postgreSQLContainer.start();
    }
}
