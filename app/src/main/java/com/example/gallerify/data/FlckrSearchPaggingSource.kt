package com.example.gallerify.data

import androidx.paging.PagingSource
import com.example.gallerify.api.FlckrApi
import retrofit2.HttpException
import java.io.IOException


private const val UNSPLASH_STARTING_PAGE_INDEX = 1

class FlckrSearchPagingSource(
    private val flckrApi: FlckrApi,
    private val query:String
) : PagingSource<Int, images>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, images> {
        val position = params.key ?: UNSPLASH_STARTING_PAGE_INDEX

        return try {
            val response = flckrApi.getSearchImages(query,position,params.loadSize)
            val photos = response.photos.photo

            LoadResult.Page(
                data = photos,
                prevKey = if (position == UNSPLASH_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (photos.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}