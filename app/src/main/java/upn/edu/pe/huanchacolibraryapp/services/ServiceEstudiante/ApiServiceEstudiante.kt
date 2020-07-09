package upn.edu.pe.huanchacolibraryapp.services.ServiceEstudiante

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import upn.edu.pe.huanchacolibraryapp.models.entity.Estudiante

interface ApiServiceEstudiante {

    @POST(".")
    fun grabaEstudiante(@Body estudiante: Estudiante?): Call<Estudiante>

    @GET(".")
    fun listarEstudiantes(): Call<List<Estudiante>>
}