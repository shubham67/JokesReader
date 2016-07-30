/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.bittu.myapplication.backend;

import com.example.bittu.myapplication.backend.model.Joke;
import com.example.bittu.myapplication.backend.service.OfyService;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.project.bittu.jokesreader.JokesList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.myapplication.bittu.example.com",
    ownerName = "backend.myapplication.bittu.example.com",
    packagePath=""
  )
)
public class MyEndpoint {

    ArrayList<String> paidJokes = new ArrayList<>();
    ArrayList<String> freeJokes = new ArrayList<>();


    @ApiMethod(name = "getJokes", httpMethod = ApiMethod.HttpMethod.GET)
    public List<Joke> getJokes(@Named("type") Joke.Type type){
        return OfyService.ofy().load().type(Joke.class)
                .filter("type", type).list();
    }

    @ApiMethod(name = "saveJokes")
    public void saveJokes(@Named("type") Joke.Type type){
        Joke joke;
        if(type == Joke.Type.PAID){
            if(OfyService.ofy().load().type(Joke.class).filter("type", Joke.Type.PAID).list().size() > 0)
                return;
                paidJokes = JokesList.getPaidJokes();


            for(int i = 0; i < paidJokes.size(); i++) {
                joke = new Joke(type, paidJokes.get(i));
                OfyService.ofy().save().entity(joke).now();
            }
        }else if(type == Joke.Type.FREE){
            if(OfyService.ofy().load().type(Joke.class).filter("type", Joke.Type.FREE).list().size() > 0)
                return;
            freeJokes = JokesList.getFreeJokes();
            for(int i = 0; i < freeJokes.size(); i++) {
                joke = new Joke(type, freeJokes.get(i));
                OfyService.ofy().save().entity(joke).now();
            }
        }


    }

}
