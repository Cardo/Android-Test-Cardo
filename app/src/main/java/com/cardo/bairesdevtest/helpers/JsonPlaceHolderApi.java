package com.cardo.bairesdevtest.helpers;

import com.cardo.bairesdevtest.models.Proyectos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    //Uso simple de RetroFit para consumo del REST API  de GitHub
    @GET("repos?page=1&per_page=10")
    Call<List<Proyectos>> getPosts();

}
