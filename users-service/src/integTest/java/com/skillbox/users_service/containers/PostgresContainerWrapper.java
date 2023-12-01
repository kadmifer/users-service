package com.skillbox.users_service.containers;

import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresContainerWrapper extends PostgreSQLContainer<PostgresContainerWrapper> {
    private static final String POSTGRES_IMAGE_NAME = "postgres";
    private static final String POSTGRES_DB = "users_service_test";
    private static final String POSTGRES_USER = "users_service_test";
    private static final String POSTGRES_PASSWORD = "users_service_test";

    public PostgresContainerWrapper() {
        super(POSTGRES_IMAGE_NAME);
        this
                .withDatabaseName(POSTGRES_DB)
                .withUsername(POSTGRES_USER)
                .withPassword(POSTGRES_PASSWORD)
                .withInitScript("postgres/init-test.sql");
    }

    @Override
    public void start() {
        super.start();
        this.getContainerId();
        // debug point. Container has to be already started
    }
}
