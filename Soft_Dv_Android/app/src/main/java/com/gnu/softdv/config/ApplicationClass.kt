package com.gnu.softdv.config

import android.app.Application
import android.content.SharedPreferences
import com.gnu.softdv.src.search.model.SearchResult
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApplicationClass : Application(){
    val API_URL = "https://gnusoftdev.shop/" // API를 받아오는 기본 주소

    companion object{ // 앱 실행과 동시에 초기화 할 변수
        lateinit var sDB : SharedPreferences // 폰의 메모리에 데이터를 저장하기 위한 변수
        lateinit var editor : SharedPreferences.Editor // 폰의 메모리에 데이터를 저장하기 위한 변수
        //base retrofit
        lateinit var retrofit: Retrofit
        // JWT Token Header 키 값
        const val HEADER_TOKEN = "HEADER_TOKEN"
        var searchArray = arrayListOf<SearchResult>()
    }

    override fun onCreate() {
        super.onCreate()
        sDB = applicationContext.getSharedPreferences("softDV", MODE_PRIVATE)
        editor = sDB.edit()
        // 레트로핏 인스턴스 생성
        initRetrofitInstance()
    }

    private fun initRetrofitInstance() {
        val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            // 로그캣에 okhttp.OkHttpClient 로 검색하면 http 통신 내용을 보여줍니다.
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addNetworkInterceptor(HAccessTokenInterceptor()) // JWT 자동 헤더 전송
            .build()

        // sRetrofit 이라는 전역변수에 API url, 인터셉터, Gson 을 넣어주고 빌드해주는 코드
        // 이 전역변수로 http 요청을 서버로 보내면 됩니다.
        retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }



}