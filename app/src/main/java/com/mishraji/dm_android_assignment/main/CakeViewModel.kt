package com.mishraji.dm_android_assignment.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mishraji.dm_android_assignment.data.CakeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CakeViewModel @Inject constructor(
    repository: CakeRepository
) : ViewModel() {
    val cake = repository.getCake().asLiveData()
}