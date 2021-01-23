package app.mulipati.network.services

import app.mulipati.network.responses.TripsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TripsService {

    @GET("v1/trips/trips/all")
    suspend fun getTrips() : Response<TripsResponse>

    @GET("v1/trips/trips/all/{location}")
    suspend fun getTripsByLocation(@Path("location") location: String): Response<TripsResponse>

}