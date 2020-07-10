package upn.edu.pe.huanchacolibraryapp.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import upn.edu.pe.huanchacolibraryapp.R
import upn.edu.pe.huanchacolibraryapp.models.entity.Reserva

class AdaptadorReserva (
                        context: Context,
                        private val datos: List<Reserva>
                        ): ArrayAdapter<Reserva>(context, R.layout.fila_reservas,datos) {

            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val inflater = LayoutInflater.from(context)
                val vista =inflater.inflate(R.layout.fila_reservas,null,true)

                val tv_librofk =vista.findViewById<TextView>(R.id.tv_librofk)     //INTRODUCIR CAMPOS EN XML
                val tv_estudiantefk = vista.findViewById<TextView>(R.id.tv_estudiantefk)            //FILA_ESTUDIANTES.XML
                val tv_fecha =vista.findViewById<TextView>(R.id.tv_fecha)         //FILA_ESTUDIANTES.XML

                tv_librofk.text =datos.get(position).librofk
                tv_estudiantefk.text =datos.get(position).estudiantefk
                tv_fecha.text =datos.get(position).fecha

                return vista
            }

}