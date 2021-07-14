package com.example.gallerify.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.gallerify.api.FlckrApi
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class FlckrRepository @Inject constructor(private val flkcrApi: FlckrApi) {
    fun getSearchResults() =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UnsplashPagingSource(flkcrApi) }
        ).liveData

    fun getSearchImagesResults(query:String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { FlckrSearchPagingSource(flkcrApi,query) }
        ).liveData


}