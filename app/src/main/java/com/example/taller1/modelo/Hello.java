package com.example.taller1.modelo;

public class Hello {

    private String language;

    private String hello;

    public String getLanguage() {
        return language;
    }

    public String getHello() {
        return hello;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public Hello(String language, String hello) {
        this.language = language;
        this.hello = hello;
    }
}
