package com.gnu.softdv.config

import com.gnu.softdv.config.ApplicationClass.Companion.HEADER_TOKEN
import com.gnu.softdv.config.ApplicationClass.Companion.sDB
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class HAccessTokenInterceptor : Interceptor{ // Header와 함께 들어오는 응답을 받아 처리할 Interceptor
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()
        val jwtToken: String? = sDB.getString(HEADER_TOKEN, null)
        if (jwtToken != null) { // 토큰이 있는지 확인
            builder.addHeader("HEADER_TOKEN", jwtToken)
        }
        return chain.proceed(builder.build()) // header와 body, method, tag를 엮어줌
    }
}