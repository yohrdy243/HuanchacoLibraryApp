package upn.edu.pe.huanchacolibraryapp.services.ServiceReserva

import android.content.Context
import android.widget.ListView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import upn.edu.pe.huanchacolibraryapp.models.entity.Reserva

import upn.edu.pe.huanchacolibraryapp.services.RetrofitReserva

import upn.edu.pe.huanchacolibraryapp.utils.AdaptadorReserva

class ResponseApiServiceReserva {
        fun grabaReserva(idReserva: Int, libro_fk:String?,estudiante_fk:String?,
                         fecha:String?, toast: Toast) {

            val r = Reserva(0,libro_fk,estudiante_fk,fecha)
            val re = RetrofitReserva.buildService(ApiServiceReserva::class.java)
            val call = re.grabaReserva(r)
            var mensaje: String=""

            call!!.enqueue(object :Callback<Reserva>{
                override fun onResponse(call: Call<Reserva>, response: Response<Reserva>) {
                    if(response.isSuccessful) mensaje= "Reserva Guardada"
                    else mensaje ="Reintente Nuevamente"
                    toast.setText(mensaje)
                    toast.show()
                }

                override fun onFailure(call: Call<Reserva>, t: Throwable) {
                    mensaje =" Reintente Nuevamente "
                    toast.setText(mensaje)
                    toast.show()
                }
            })
        }

        fun listarReserva(context: Context, listView: ListView){
            val r = RetrofitReserva.buildService(ApiServiceReserva::class.java)
            val call = r.listarReservas()

            call!!.enqueue(object :Callback<List<Reserva>> {
                override fun onResponse(call: Call<List<Reserva>>, response: Response<List<Reserva>>) {
                    if(response.isSuccessful){
                        val rpta =response.body()!!
                        val adap = AdaptadorReserva(context,rpta)
                        listView.adapter = adap
                    }
                }

                override fun onFailure(call: Call<List<Reserva>>, t: Throwable) {
                    println(t.toString())

                }
            })
        }
}