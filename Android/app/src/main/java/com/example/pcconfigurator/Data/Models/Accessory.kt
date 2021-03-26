import com.example.pcconfigurator.Data.Models.AccessoryType
import java.util.*

class Accessory(
    var name: String,
    var vendor: String,
    var id: UUID,
    var price: Int,
    var accessoryType: AccessoryType ) {

}