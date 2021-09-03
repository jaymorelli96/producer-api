package com.example.producerapi.service;

import com.example.producerapi.dto.FavoriteDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class FavoriteServiceTest {

    @InjectMocks
    private FavoriteService service;

    @Mock
    private RabbitTemplate rt;

    @Test
    void sendFavoriteToRabbit() {

        Mockito.doNothing().when(rt).convertAndSend(Mockito.any(), Mockito.any(), Mockito.any(FavoriteDTO.class));

        //Act
        service.sendFavoriteToRabbit(new FavoriteDTO());

        //Assert
        Mockito.verify(rt, Mockito.times(1)).convertAndSend(Mockito.any(), Mockito.any(), Mockito.any(FavoriteDTO.class));
    }
}