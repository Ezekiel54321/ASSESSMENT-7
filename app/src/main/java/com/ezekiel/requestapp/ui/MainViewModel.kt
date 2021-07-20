package com.ezekiel.requestapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ezekiel.requestapp.api.RequestProvider
import com.ezekiel.requestapp.models.Item
import com.ezekiel.requestapp.models.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val itemsLiveData = MutableLiveData<List<Item>>()
    val studentsLiveData = MutableLiveData<List<Student>>()

//    val studentsLiveData = liveData<List<Student>> {
//        itemsLiveData.postValue(ServiceProvider.placeHolderApi.getItems())
//    }

    fun getItems() {
        CoroutineScope(Dispatchers.IO).launch {
            itemsLiveData.postValue(RequestProvider.apiRequests.getItems())
        }
    }

    fun addStudent(newStudent: Student) {
        CoroutineScope(Dispatchers.IO).launch {
            studentsLiveData.postValue(RequestProvider.apiRequests.addStudents(newStudent))
        }
    }
}