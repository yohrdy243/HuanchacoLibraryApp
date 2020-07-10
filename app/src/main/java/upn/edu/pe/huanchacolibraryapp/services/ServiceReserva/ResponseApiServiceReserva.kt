package upn.edu.pe.huanchacolibraryapp.services.ServiceReserva

import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import upn.edu.pe.huanchacolibraryapp.models.entity.Reserva
import upn.edu.pe.huanchacolibraryapp.services.RetrofitClient

class ResponseApiServiceReserva {
        fun grabaReserva(idReserva: Int, libro_fk:String?,estudiante_fk:String?,
                         fecha:String?, toast: Toast) {

            val r = Reserva(0,libro_fk,estudiante_fk,fecha)
            val re = RetrofitClient.buildService(ApiServiceReserva::class.java)
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
}