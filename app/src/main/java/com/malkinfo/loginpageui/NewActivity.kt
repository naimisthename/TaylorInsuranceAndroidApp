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
        val txthomePolicy = findViewById<TextView>(R.id.homePolicy)
        val txtautoPolicy = findViewById<TextView>(R.id.autoPolicy)
        val getaQuote = findViewById<ImageView>(R.id.getaQuote)
        val customerNumber = intent.getStringExtra("customerNumber").toString()





        getaQuote.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://192.168.2.26:8080/"))
            startActivity(intent)
        }
        val customerApi = RetroFitHelper.getInstance().create(CustomerService::class.java)
        // launching a new coroutine
        GlobalScope.launch {
            val customer = customerApi.getCustomers(customerNumber).body()
            if (customer != null) {

                runOnUiThread {

                    var userInfo = "Account Number : " + customer.id
                    userInfo += "\nFirst Name : " + customer.firstName
                    userInfo += "\nLast Name : " + customer.lastName
                    userInfo += "\nEmail : " + customer.email
                    userInfo += "\nDate Of Birth : " + customer.dateOfBirth
                    txtcustomerInfo.text = userInfo

                    if (customer.autoPolicies.isNotEmpty()) {

                        val autopolicy = customer.autoPolicies[0]
                        var autopolicyInfo = "\nAuto Model : " + autopolicy.autoModel
                        autopolicyInfo += "\nPolicy ID : " + autopolicy.autoPolicyId
                        autopolicyInfo += "\nYear : " + autopolicy.autoYear
                        autopolicyInfo += "\nPremium : " + autopolicy.premium
                        autopolicyInfo += "\nStart Date : " + autopolicy.startDate
                        autopolicyInfo += "\nEnd Date : " + autopolicy.endDate


                        txtautoPolicy.text = autopolicyInfo

                    } else {
                        txtautoPolicy.text = "\nYou have no Auto policy!"
                    }

                    if (customer.homePolicies.isNotEmpty()) {

                        val homepolicy = customer.homePolicies[0]
                        var homePolicyInfo = "\nPolicy ID : " + homepolicy.homePolicyId
                        homePolicyInfo += "\nPremium : " + homepolicy.premium
                        homePolicyInfo += "\nStart Date : " + homepolicy.startDate
                        homePolicyInfo += "\nEnd Date : " + homepolicy.endDate

                        txthomePolicy.text = homePolicyInfo

                    } else {
                        txthomePolicy.text = "\nYou have Home no Policy!"
                    }

                    // Checking the results
                    Log.d("Customer", customer.toString())
                    println(customerNumber)

                }


            }
        }
    }
}





