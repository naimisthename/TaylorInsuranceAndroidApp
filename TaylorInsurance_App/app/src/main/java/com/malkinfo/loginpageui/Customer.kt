package com.malkinfo.loginpageui

data class Customer(val id: Int, val firstName: String, val lastName: String, val email: String, val dateOfBirth: String, val autos:List<Autos>, val homes:List<Homes>, val autoQuotes:List<Autoquotes>, val homeQuotes:List<Homequotes>, val homePolicies:List<HomePolicies>, val autoPolicies:List<AutoPolicies>)
