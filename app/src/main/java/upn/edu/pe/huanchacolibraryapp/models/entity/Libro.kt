package upn.edu.pe.huanchacolibraryapp.models.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Libro {
    @SerializedName("id_Libro")
    @Expose
    var idLibro =0

    @SerializedName("nombre_Libro")
    @Expose
    var nombreLibro: String? = null

    @SerializedName("editorial_Libro")
    @Expose
    var editorialLibro: String? = null

    @SerializedName("categoria_Libro")
    @Expose
    var categoriaLibro: String? = null

    @SerializedName("ejemplar_Libro")
    @Expose
    var ejemplarLibro: String? =null

}
