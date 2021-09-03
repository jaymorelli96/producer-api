package com.example.producerapi.service;

import com.example.producerapi.config.FavoriteAMQPConfig;
import com.example.producerapi.dto.FavoriteDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitRetryTemplateCustomizer;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendFavoriteToRabbit(FavoriteDTO favoriteDTO) {
        rabbitTemplate.convertAndSend(FavoriteAMQPConfig.EXCHANGE_NAME, "", favoriteDTO);
    }

}
