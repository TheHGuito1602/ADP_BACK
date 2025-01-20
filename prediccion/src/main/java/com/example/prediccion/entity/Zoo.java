import jakarta.persistence.Entity;

import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;

import lombok.Builder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Zoo implements Serializable{
    private int hair;
    private int feathers;
    private int eggs;
    private int milk;
    private int airbone;
    private int aquatic;
    private int predator;
    private int toothed;
    private int backbone;
    private int breathes;
    private int venomous;
    private int fins;
    private int legs;
    private int tail;
    private int domestic;
    private int catsize;

}