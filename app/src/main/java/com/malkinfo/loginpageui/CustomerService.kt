package com.malkinfo.loginpageui

import android.widget.EditText
import android.widget.ImageView
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CustomerService {

    //"http://10.0.0.245:8080/
    @GET("/customers/{id}")
    suspend fun getCustomers(@Path("id") id:String) : Response<Customer>


    //@Query("id") id:String

}