package com.malkinfo.loginpageui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class NewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        val txtcustomerInfo = findViewById<TextView>(R.id.customerInfo)
        //val txthomeInfo=findViewById<TextView>(R.id.homeInfo)
        //val txtautoInfo=findViewById<TextView>(R.id.autoInfo)
        val txthomePolicy = findViewById<TextView>(R.id.homePolicy)
        val txtautoPolicy = findViewById<TextView>(R.id.autoPolicy)
        val getaQuote = findViewById<ImageView>(R.id.getaQuote)

        getaQuote.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://10.0.0.245:8080/"))
            startActivity(intent)
        }
        val customerApi = RetroFitHelper.getInstance().create(CustomerService::class.java)
        // launching a new coroutine
        GlobalScope.launch {
            val customer = customerApi.getCustomers().body()
            if (customer != null) {

                runOnUiThread {

                    var userInfo = "Account Number : " + customer.id
                    userInfo += "\nFirst Name : " + customer.firstName
                    userInfo += "\nLast Name : " + customer.lastName
                    userInfo += "\nEmail : " + customer.email
                    userInfo += "\nDate Of Birth : " + customer.dateOfBirth
                    txtcustomerInfo.text = userInfo

//                    if(customer.homes.isNotEmpty())
//                    {
//
//                        val home=customer.homes[0]
//                        var homeInfo="Home Number : "+home.homeId
//                        homeInfo+="\nHeating Type : "+home.heatingType
//                        homeInfo+="\nDate Built : "+home.dateBuilt
//                        homeInfo+="\nValue : "+home.value
//                        homeInfo+="\nLocation : "+home.location
//
//                        txthomeInfo.text=homeInfo
//
//                    }
//
//                    if(customer.autos.isNotEmpty())
//                    {
//
//                        val auto=customer.autos[0]
//                        var autoInfo="Auto ID : "+auto.autoId
//                        autoInfo+="\nYear : "+auto.autoYear
//                        autoInfo+="\nMake : "+auto.make
//                        autoInfo+="\nModel : "+auto.model
//                        autoInfo+="\n Number of Accidents : "+auto.numberOfAccidents
//
//
//                        txtautoInfo.text=autoInfo
//
//                    }




                    if (customer.autoPolicies.isNotEmpty()) {

                        val autopolicy = customer.autoPolicies[0]
                        var autopolicyInfo ="\nAuto Model : " + autopolicy.autoModel
                        autopolicyInfo += "\nPolicy ID : " + autopolicy.autoPolicyId
                        autopolicyInfo += "\nYear : " + autopolicy.autoYear
                        autopolicyInfo += "\nPremium : " + autopolicy.premium
                        autopolicyInfo += "\nStart Date : " + autopolicy.startDate
                        autopolicyInfo += "\nEnd Date : " + autopolicy.endDate


                        txtautoPolicy.text = autopolicyInfo

                    }

                    if (customer.homePolicies[0]!=null) {

                        val homepolicy = customer.homePolicies[0]
                        var homePolicyInfo ="\nPolicy ID : " + homepolicy.homePolicyId
                        homePolicyInfo += "\nPremium : " + homepolicy.premium
                        homePolicyInfo += "\nStart Date : " + homepolicy.startDate
                        homePolicyInfo += "\nEnd Date : " + homepolicy.endDate

                        txthomePolicy.text = homePolicyInfo

                    }

                    Log.d("Customer", customer.toString())


                }
                // Checking the results
//                Log.d("Customer: ", customer.body().toString())

            }
        }
    }
}





