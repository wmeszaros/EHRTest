package com.example.ehrtest.api

import com.example.ehrtest.data.RepoResult
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RepositoryRetriever {
    private val service: GithubService

    companion object {
        private const val BASE_URL = "https://api.github.com/"
    }

    init {
        val retrofit = Retrofit.Builder()
            //1
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            //2
            .build()
        //3
        service = retrofit.create(GithubService::class.java)
    }

    fun getRepositories(callback: Callback<RepoResult>) {
        //4
        service.searchRepositories().enqueue(callback)
    }
}