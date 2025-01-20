package com.example.prediccion.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Iris implements Serializable {
    private float a1;
    private float a2;
    private float a3;
    private float a4;

}
