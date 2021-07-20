package com.ezekiel.requestapp.api

import com.ezekiel.requestapp.models.Item
import com.ezekiel.requestapp.models.Student
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiRequests {

    @GET("items")
    suspend fun getItems(): List<Item>

    @POST("students")
    suspend fun addStudents(@Body newStudent: Student): List<Student>
}