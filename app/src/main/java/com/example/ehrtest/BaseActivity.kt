package com.example.ehrtest

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ehrtest.network.NetworkStateReceiverListener
import com.example.ehrtest.network.NetworkUtils

abstract class BaseActivity : AppCompatActivity() {
    private var networkCallback: ConnectivityManager.NetworkCallback? = null
    private val networkUtils by lazy { NetworkUtils(applicationContext) /*important to be applicationContext to prevent memoryLeak*/}
    private val connectivityManager by lazy { getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }

    protected val NetworkStateReceiverListener.isConnected: Boolean // can be used by childs
        get() {
            this as BaseActivity // only accessible from child class, so cast i safe here
            return networkUtils.isConnected()
        }

    private fun registerConnectivityMonitoring(listener: NetworkStateReceiverListener) {
        val networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                listener.networkConnectivityChanged()
            }

            override fun onLost(network: Network) {
                listener.networkConnectivityChanged()
            }
        }
        this.networkCallback = networkCallback
        connectivityManager.registerNetworkCallback(NetworkRequest.Builder().build(), networkCallback)
    }

    private fun unregisterConnectivityMonitoring() {
        val networkCallback = this.networkCallback ?: return
        connectivityManager.unregisterNetworkCallback(networkCallback)
        this.networkCallback = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (this is NetworkStateReceiverListener)
            registerConnectivityMonitoring(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (this is NetworkStateReceiverListener)
            unregisterConnectivityMonitoring()
    }

    override fun onResume() {
        super.onResume()
        if (this is NetworkStateReceiverListener && !isConnected)
            this.networkConnectivityChanged()// call to show no network banner on activity resume
    }
}