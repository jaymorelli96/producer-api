package com.example.producerapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteDTO implements Serializable{
    @JsonProperty("username")
    private String username;
    @JsonProperty("municipality")
    private String municipality;
    @JsonProperty("codprov")
    private String codprov;
    @JsonProperty("codauton")
    private String codauton;
    @JsonProperty("codigoine")
    private String codigoine;
}