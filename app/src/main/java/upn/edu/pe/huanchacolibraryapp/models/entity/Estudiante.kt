package upn.edu.pe.huanchacolibraryapp.models.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Estudiante {
    @SerializedName("id")
    @Expose
    var id= 0

    @SerializedName("nombre")
    @Expose
    var nombres: String? = null

    @SerializedName ("apellidos")
    @Expose
    var apellidos: String? = null

    @SerializedName("carrera")
    @Expose
    var carrera: String? = null

    @SerializedName("email")
    @Expose
    var email: String? = null

    constructor(id: Int, apellidos:String?, nombres: String?, carrera: String?, email:String?){
        this.id= id
        this.apellidos=apellidos
        this.nombres=nombres
        this.carrera=carrera
        this.email=email
    }
}