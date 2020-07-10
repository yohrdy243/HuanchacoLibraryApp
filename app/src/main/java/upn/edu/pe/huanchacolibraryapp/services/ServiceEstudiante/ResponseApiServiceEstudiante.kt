package upn.edu.pe.huanchacolibraryapp.services.ServiceEstudiante

import android.content.Context
import android.widget.ListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.Toast
import upn.edu.pe.huanchacolibraryapp.models.entity.Estudiante
import upn.edu.pe.huanchacolibraryapp.services.RetrofitClient
import upn.edu.pe.huanchacolibraryapp.utils.AdaptadorEstudiante

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
            fun listarEstudiantes(context: Context, listView: ListView){
                val r = RetrofitClient.buildService(ApiServiceEstudiante::class.java)
                val call = r.listarEstudiantes()

                call!!.enqueue(object :Callback<List<Estudiante>> {
                    override fun onResponse(call: Call<List<Estudiante>>, response: Response<List<Estudiante>>) {
                        if(response.isSuccessful){
                            val rpta =response.body()!!
                            val adap =AdaptadorEstudiante(context,rpta)
                            listView.adapter = adap
                        }
                    }

                    override fun onFailure(call: Call<List<Estudiante>>, t: Throwable) {
                        println(t.toString())

                    }
                })
            }


}