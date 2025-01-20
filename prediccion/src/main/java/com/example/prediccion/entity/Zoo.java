package com.example.prediccion.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;

import lombok.Builder;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Zoo implements Serializable {
    @JsonProperty("hair")
    private int hair;
    @JsonProperty("feathers")
    private int feathers;
    @JsonProperty("eggs")
    private int eggs;
    @JsonProperty("milk")
    private int milk;
    @JsonProperty("airborne")
    private int airborne;
    @JsonProperty("aquatic")
    private int aquatic;
    @JsonProperty("predator")
    private int predator;
    @JsonProperty("toothed")
    private int toothed;
    @JsonProperty("backbone")
    private int backbone;
    @JsonProperty("breathes")
    private int breathes;
    @JsonProperty("venomous")
    private int venomous;
    @JsonProperty("fins")
    private int fins;
    @JsonProperty("legs")
    private int legs;
    @JsonProperty("tail")
    private int tail;
    @JsonProperty("domestic")
    private int domestic;
    @JsonProperty("catsize")
    private int catsize;

    public String toStringZoo(){
        return "Zoo{" +
                "hair=" + hair +
                ", feathers=" + feathers +
                ", eggs=" + eggs +
                ", milk=" + milk +
                ", airborne=" + airborne +
                ", aquatic=" + aquatic +
                ", predator=" + predator +
                ", toothed=" + toothed +
                ", backbone=" + backbone +
                ", breathes=" + breathes +
                ", venomous=" + venomous +
                ", fins=" + fins +
                ", legs=" + legs +
                ", tail=" + tail +
                ", domestic=" + domestic +
                ", catsize=" + catsize +
                '}';
    }
}