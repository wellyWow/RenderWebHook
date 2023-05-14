package com.example.renderwebhook;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class TelegramConfig {

    @Value("${telegram.bot-token}")
    private String botToken;

    @Value("${telegram.username}")
    private String username;

    @Value("${telegram.path}")
    private String path;
}
