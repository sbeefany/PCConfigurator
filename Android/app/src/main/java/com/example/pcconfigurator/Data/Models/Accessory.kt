import com.example.pcconfigurator.Data.Models.*

import java.util.*

sealed class Accessory {
    abstract val name: String
    abstract val vendor: String
    abstract val id: UUID
    abstract val price: Int

    data class PowerSupply(
        override val name: String,
        override val vendor: String,
        override val id: UUID,
        override val price: Int,
        val powerCount:Int,
        val formFactorPowerSupply: FormFactorPowerSupply
    ) : Accessory()

    data class Disk(
        override val name: String,
        override val vendor: String,
        override val id: UUID,
        override val price: Int,
        val diskSizeGB:Int,
        val diskType: DiskType
    ) : Accessory()

    data class ComputerCase(
        override val name: String,
        override val vendor: String,
        override val id: UUID,
        override val price: Int,
        val formFactors:List<FormFactor>,
        val typeSize:TypeSizeComputerCase,
        val coolersCount:Int,
        val connectors:List<Connector>,
        val formFactorPowerSupply: List<FormFactorPowerSupply>
    ) : Accessory()

    data class Cooler(
        override val name: String,
        override val vendor: String,
        override val id: UUID,
        override val price: Int,
        val noiceLvl:Int,
        val socket: List<Socket>,
        val material: Material
    ) : Accessory()

    data class Ram(
        override val name: String,
        override val vendor: String,
        override val id: UUID,
        override val price: Int,
        val valueRam:Int,
        val frequency:Int,
        val typeRam: TypeRam
    ) : Accessory()

    data class MotherBoard(
        override val name: String,
        override val vendor: String,
        override val id: UUID,
        override val price: Int,
        val chipset: Chipset,
        val formFactor:FormFactor,
        val socket: Socket,
        val typeRam: TypeRam,
        val ramCount:Int,
        val hasSlotForM2:Boolean
    ) : Accessory()

    data class Cpu(
        override val name: String,
        override val vendor: String,
        override val id: UUID,
        override val price: Int,
        val coresCount: Int,
        val streamsCount:Int,
        val cashMemory:Int,
        val hasGpu:Boolean,
        val socket: Socket
    ) : Accessory()

    data class Gpu(
        override val name: String,
        override val vendor: String,
        override val id: UUID,
        override val price: Int,
        val coreFrequency:Int,
        val memorySize:Int,
        val power:Int,
        val videoMemoryType: VideoMemoryType
    ) : Accessory()


}