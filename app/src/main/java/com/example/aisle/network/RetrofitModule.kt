package com.example.aisle.network

import com.example.aisle.network.ApiService.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RetrofitModule {

    @Provides
    fun provideOkHttpClient() =
        run {
            val headerInterceptor = Interceptor { chain ->
                val original = chain.request()
                val builder = original.newBuilder()

//                builder.header(
//                    tenant_identifier,
//                    master
//                )
//
//                builder.header(
//                    content_type,
//                    application_json
//                )
                val request = builder.method(original.method, original.body)
                    .build()

                chain.proceed(request)
            }


            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            OkHttpClient.Builder()
                .addInterceptor(headerInterceptor)
                .addInterceptor(loggingInterceptor)

                .addInterceptor { chain ->
                    val request = chain.request()
                    val response = chain.proceed(request)
                    response
                }
                .connectTimeout(30, TimeUnit.SECONDS)
                .callTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)

                .build()

        }

    @Singleton
    @Provides
    fun provideApiService(
        okHttpClient: OkHttpClient
    ): ApiService {


        return Retrofit.Builder().baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)
    }

//

}