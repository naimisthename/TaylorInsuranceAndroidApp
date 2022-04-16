package com.malkinfo.loginpageui.jsonresponse

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("firstName")
	val firstName: String? = null,

	@field:SerializedName("lastName")
	val lastName: String? = null,

	@field:SerializedName("autoQuotes")
	val autoQuotes: List<AutoQuotesItem?>? = null,

	@field:SerializedName("homeQuotes")
	val homeQuotes: List<HomeQuotesItem?>? = null,

	@field:SerializedName("homePolicies")
	val homePolicies: List<HomePoliciesItem?>? = null,

	@field:SerializedName("autoPolicies")
	val autoPolicies: List<AutoPoliciesItem?>? = null,

	@field:SerializedName("homes")
	val homes: List<HomesItem?>? = null,

	@field:SerializedName("autos")
	val autos: List<AutosItem?>? = null,

	@field:SerializedName("dateOfBirth")
	val dateOfBirth: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null
)

data class HomeQuotesItem(

	@field:SerializedName("premium")
	val premium: Double? = null,

	@field:SerializedName("homeQuoteId")
	val homeQuoteId: Int? = null,

	@field:SerializedName("endDate")
	val endDate: String? = null,

	@field:SerializedName("startDate")
	val startDate: String? = null
)

data class AutoQuotesItem(

	@field:SerializedName("premium")
	val premium: Double? = null,

	@field:SerializedName("endDate")
	val endDate: String? = null,

	@field:SerializedName("autoQuoteId")
	val autoQuoteId: Int? = null,

	@field:SerializedName("startDate")
	val startDate: String? = null,

	@field:SerializedName("autoModel")
	val autoModel: String? = null,

	@field:SerializedName("autoYear")
	val autoYear: Int? = null
)

data class HomesItem(

	@field:SerializedName("dateBuilt")
	val dateBuilt: String? = null,

	@field:SerializedName("heatingType")
	val heatingType: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("location")
	val location: String? = null,

	@field:SerializedName("homeId")
	val homeId: Int? = null,

	@field:SerializedName("value")
	val value: Int? = null,

	@field:SerializedName("age")
	val age: Int? = null
)

data class HomePoliciesItem(

	@field:SerializedName("homePolicyId")
	val homePolicyId: Int? = null,

	@field:SerializedName("premium")
	val premium: Double? = null,

	@field:SerializedName("endDate")
	val endDate: String? = null,

	@field:SerializedName("startDate")
	val startDate: String? = null
)

data class AutoPoliciesItem(

	@field:SerializedName("autoPolicyId")
	val autoPolicyId: Int? = null,

	@field:SerializedName("premium")
	val premium: Double? = null,

	@field:SerializedName("endDate")
	val endDate: String? = null,

	@field:SerializedName("startDate")
	val startDate: String? = null,

	@field:SerializedName("autoModel")
	val autoModel: String? = null,

	@field:SerializedName("autoYear")
	val autoYear: Int? = null
)

data class AutosItem(

	@field:SerializedName("autoId")
	val autoId: Int? = null,

	@field:SerializedName("model")
	val model: String? = null,

	@field:SerializedName("make")
	val make: String? = null,

	@field:SerializedName("numberOfAccidents")
	val numberOfAccidents: Int? = null,

	@field:SerializedName("autoYear")
	val autoYear: Int? = null
)
