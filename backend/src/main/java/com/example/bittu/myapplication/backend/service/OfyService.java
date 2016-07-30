package com.example.bittu.myapplication.backend.service;

import com.example.bittu.myapplication.backend.model.Joke;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

/**
 * Created by Bittu on 7/14/2016.
 */
public class OfyService {

    static {
        factory().register(Joke.class);
    }


    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }


    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }

}
