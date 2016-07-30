package com.example.bittu.myapplication.backend.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;



/**
 * Created by Bittu on 7/14/2016.
 */

@Entity
public class Joke {

    @Id
    private Long id;



    public static enum Type{
        PAID,
        FREE
    }

    @Index
    private Type type;

    private String joke;

    public Joke(){}

    public Joke(Type type, String joke){
        this.type = type;
        this.joke = joke;
    }

    public String getJoke(){
        return joke;
    }

    public Type getType(){
        return type;
    }


    public Long getId() {
        return id;
    }


}
