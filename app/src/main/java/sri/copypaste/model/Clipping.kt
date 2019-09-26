package sri.copypaste.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Clipping {

    @Json(name = "id")
    lateinit var id: String

    @Json(name = "text")
    lateinit var text: String

    @Json(name = "timestamp")
    var timestamp: Long = 0

    override fun toString(): String {
        return "Clipping(id='$id', text='$text', timestamp=$timestamp)"
    }


}