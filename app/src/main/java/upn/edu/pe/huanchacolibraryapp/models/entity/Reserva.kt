package upn.edu.pe.huanchacolibraryapp.models.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import upn.edu.pe.huanchacolibraryapp.models.entity.Libro

class Reserva {
    @SerializedName("idReserva")
    @Expose
    var idReserva = 0;

    @SerializedName("libro_fk")
    @Expose
    var librofk: String? = null //NOSE SI ESTA BIEN

    @SerializedName("estudiante_fk")
    @Expose
    var estudiantefk: String? = null//NO SE SI ESTA BIEN

    @SerializedName("fecha")
    @Expose
    var fecha: String? = null//FECHA DECLARADA EN STRING

    constructor(idReserva: Int, librofk: String?, estudiantefk:String?, fecha:String?){
        this.idReserva=idReserva
        this.librofk=librofk
        this.estudiantefk=estudiantefk
        this.fecha=fecha
    }


}