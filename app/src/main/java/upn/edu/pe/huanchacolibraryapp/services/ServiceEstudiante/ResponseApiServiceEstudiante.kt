package upn.edu.pe.huanchacolibraryapp.services.ServiceEstudiante

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.Toast
import upn.edu.pe.huanchacolibraryapp.models.entity.Estudiante
import upn.edu.pe.huanchacolibraryapp.services.RetrofitClient

class ResponseApiServiceEstudiante {
    fun grabaEstudiante(id: Int, apellidos:String?,nombre:String?,
                        carrera:String?, email:String?, toast: Toast) {

        val e = Estudiante(0, apellidos, nombre, carrera, email)
        val r = RetrofitClient.buildService(ApiServiceEstudiante::class.java)
        val call =r.grabaEstudiante(e)
        var mensaje: String = ""

        call!!.enqueue(object : Callback<Estudiante> {
            override fun onResponse(call: Call<Estudiante>, response: Response<Estudiante>) {
                if (response.isSuccessful) mensaje = "GRABADO"
                else mensaje = "REINTENTE NUEVAMENTE"
                toast.setText(mensaje)
                toast.show()
            }

            override fun onFailure(call: Call<Estudiante>, t: Throwable) {
                mensaje = "REINTENTE NUEVAMENTE"
                toast.setText(mensaje)
                toast.show()
            }
        })
    }
}