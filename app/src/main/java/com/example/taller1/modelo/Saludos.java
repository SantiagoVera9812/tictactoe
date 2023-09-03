package com.example.taller1.modelo;

import org.jetbrains.annotations.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class Saludos {


    private String name;

    private String greetigs;

    public String getName() {
        return name;
    }

    public String getGreetigs() {
        return greetigs;
    }

    public Saludos(@NotNull String name, @NotNull String greeting) {
    this.name = name;
    this.greetigs = greeting;
    }

    @Override
    public String toString() {
        return name;
    }
}
