package com.malkinfo.loginpageui

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CustomerService {


    //"http://10.0.0.245:8080/
    @GET("/customers/byid?customerId=1")
    suspend fun getCustomers() : Response<Customer>

}