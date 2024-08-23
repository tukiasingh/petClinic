package com.example.petclinic.model;

import java.util.List;

public class Response {
    private int code;
    private String message;
    private List<Pet> pets;

    public Response() {
    }

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(int code, String message, List<Pet> pets) {
        this.code = code;
        this.message = message;
        this.pets = pets;
    }

    public int getCode() {
        return code;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
