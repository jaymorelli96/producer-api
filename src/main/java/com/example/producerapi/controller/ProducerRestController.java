package com.example.producerapi.controller;


import com.example.producerapi.dto.FavoriteDTO;
import com.example.producerapi.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://meteoes.westeurope.azurecontainer.io")
@RequestMapping("/api/favorites")
public class ProducerRestController {


    @Autowired
    private FavoriteService favoriteService;

    @PostMapping
    public ResponseEntity<FavoriteDTO> sendToRabbit(@RequestBody FavoriteDTO favoriteDTO) {
        favoriteService.sendFavoriteToRabbit(favoriteDTO);
        return ResponseEntity.ok(favoriteDTO);
    }
}
