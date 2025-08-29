package com.fredrik.webservice_uppgifter_lektion_5.model;

public record User(
        long id,
        String username,
        String password,
        Boolean isEnabled
) {
}
