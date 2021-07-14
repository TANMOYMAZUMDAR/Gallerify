package com.example.gallerify.api

import com.example.gallerify.data.FlckrPhotos
import com.example.gallerify.data.images
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface FlckrApi {



    @GET("?method=flickr.photos.getRecent&per_page=20&page=1&api_key=6f102c62f41998d151e5a1b48713cf13&format=json&nojsoncallback=1&extras=url_s")
  suspend  fun getImages(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): FlckrPhotos

  @GET( "?method=flickr.photos.search&api_key=6f102c62f41998d151e5a1b48713cf13&format=json&nojsoncallback=1&extras=url_s&text=cat")

  suspend fun getSearchImages(
      @Query("text") text : String?,
      @Query("page") page: Int,
      @Query("per_page") perPage: Int
      ):FlckrPhotos

}