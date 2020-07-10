package upn.edu.pe.huanchacolibraryapp.services.ServiceLibro

import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import upn.edu.pe.huanchacolibraryapp.models.entity.Libro
import upn.edu.pe.huanchacolibraryapp.services.RetrofitClient

class ResponseApiServiceLibro {
    fun grabaLibro(idLibro: Int, nombreLibro:String?,editorialLibro:String?,idiomaLibro:String?,
                        categoriaLibro:String?, ejemplarLibro:String?, toast: Toast) {

        val l = Libro(0,nombreLibro,editorialLibro,idiomaLibro,categoriaLibro,ejemplarLibro)
        val r = RetrofitClient.buildService(ApiServiceLibro::class.java)
        val call =r.grabaLibro(l)
        var mensaje: String =""

        call!!.enqueue(object : Callback<Libro>{
            override fun onResponse(call: Call<Libro>, response: Response<Libro>) {
                if(response.isSuccessful) mensaje= "Libro Grabado"
                else mensaje ="Reintente nuevamente"
                toast.setText(mensaje)
                toast.show()
            }

            override fun onFailure(call: Call<Libro>, t: Throwable) {
                mensaje="Reintente nuevamente"
                toast.setText(mensaje)
                toast.show()
            }
        })
    }
}