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

    companion object{ // 앱 실행과 동시에 초기화 할 변수
        lateinit var sDB : SharedPreferences // 폰의 메모리에 데이터를 저장하기 위한 변수
        lateinit var editor : SharedPreferences.Editor // 폰의 메모리에 데이터를 저장하기 위한 변수
        //base retrofit (HTTP 통신을 위한 라이브러리를 사용하게 해주는 Retrofit 변수)
        lateinit var retrofit: Retrofit
        // JWT Token Header 키 값
        const val HEADER_TOKEN = "HEADER_TOKEN"
        var searchArray = arrayListOf<SearchResult>() // 검색 결과를 저장할 리스트
        const val API_URL = "https://gnusoftdev.shop/" // API를 받아오는 기본 주소
    }

    override fun onCreate() { // 앱 실행과 동시에 호출
        super.onCreate()
        sDB = applicationContext.getSharedPreferences("softDV", MODE_PRIVATE) // 메모리에 저장할 데이터의 식별자 정의
        editor = sDB.edit() // 메모리 저장 기능들을 사용한다는 것을 정의
        // 레트로핏 인스턴스 생성
        initRetrofitInstance()
    }

    private fun initRetrofitInstance() {
        // http 통신을 위한 client 변수
        val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            // 로그캣에 okhttp.OkHttpClient 로 검색하면 http 통신 내용을 보여줍니다.
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addNetworkInterceptor(HAccessTokenInterceptor()) // JWT 자동 헤더 전송
            .build()

        // retrofit 이라는 전역변수에 API url, 인터셉터, Gson 을 넣어주고 빌드해주는 코드
        // 이 전역변수로 http 요청을 서버로 보낸다.
        retrofit = Retrofit.Builder()
            .baseUrl(Companion.API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }



}