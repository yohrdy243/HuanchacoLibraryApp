package upn.edu.pe.huanchacolibraryapp.services.ServiceReserva

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import upn.edu.pe.huanchacolibraryapp.models.entity.Reserva

interface ApiServiceReserva {
    @POST(".")
    fun grabaReserva(@Body reserva: Reserva?): Call<Reserva>

    @GET(".")
    fun listarReservas(): Call<List<Reserva>>

}