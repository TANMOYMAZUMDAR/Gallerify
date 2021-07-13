package com.example.gallerify.ui.gallery

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.example.gallerify.api.FlckrApi
import com.example.gallerify.data.FlckrRepository
import com.example.gallerify.data.images
import kotlinx.coroutines.launch


class GalleryViewModel @ViewModelInject constructor(
    private val repository: FlckrRepository,
    @Assisted state: SavedStateHandle
) : ViewModel() {

           val _images=repository.getSearchResults().cachedIn(viewModelScope)

   }

