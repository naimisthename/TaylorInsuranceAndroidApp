package com.malkinfo.loginpageui.jsonresponse

import com.google.gson.Gson
import java.net.URL

fun main(args: Array<String>) {
    var response= URL("http://10.0.0.245:8080/").readText()
    var gson = Gson()

    val data = gson.fromJson(response, Array<Response>::class.java)
    for (x in 1 until data.size)
    print(data[x].id)

}