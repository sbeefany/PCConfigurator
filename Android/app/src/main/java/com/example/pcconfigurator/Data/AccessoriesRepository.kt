package com.example.pcconfigurator.Data

import Accessory
import com.example.pcconfigurator.Data.Models.*
import java.util.*

object AccessoriesRepository {

    val allAccessories: List<Accessory> = listOf(
        Accessory.Disk("HDWL110UZSVA", "Toshiba", UUID.randomUUID(), 3900, 1024, DiskType.HardDisk),
        Accessory.Disk("HDWK105UZSVA", "Toshiba", UUID.randomUUID(), 3500, 500, DiskType.HardDisk),
        Accessory.Disk(
            "ST1000DM010 ",
            "Seagate ",
            UUID.randomUUID(),
            3450,
            1024,
            DiskType.HardDisk
        ),
        Accessory.Disk(
            "HDWD110EZSTA ",
            "Toshiba",
            UUID.randomUUID(),
            3500,
            1024,
            DiskType.HardDisk
        ),
        Accessory.Disk("AFALCON-256G-C ", "A-Data", UUID.randomUUID(), 4120, 256, DiskType.M2),
        Accessory.Disk("SA400S37/120G ", "Kingston ", UUID.randomUUID(), 1990, 120, DiskType.SSD),
        Accessory.Ram("PSD34G16002 ", "Patriot ", UUID.randomUUID(), 1730, 4, 1600, TypeRam.DDR3),
        Accessory.Ram(
            "KM-LD3-1600-8GS ",
            "Kingmax ",
            UUID.randomUUID(),
            2990,
            8,
            1600,
            TypeRam.DDR3
        ),
        Accessory.Ram(
            "KM-LD4-2666-8GS ",
            "Kingmax  ",
            UUID.randomUUID(),
            2720,
            8,
            2666,
            TypeRam.DDR4
        ),
        Accessory.Ram("PSD48G266681  ", "Patriot ", UUID.randomUUID(), 2750, 8, 2666, TypeRam.DDR4),
        Accessory.Ram(
            "M378A1K43EB2  ",
            "Samsung  ",
            UUID.randomUUID(),
            2840,
            8,
            2933,
            TypeRam.DDR4
        ),
        Accessory.Ram(
            "PSD48G320081   ",
            "Patriot ",
            UUID.randomUUID(),
            2800,
            8,
            3200,
            TypeRam.DDR4
        ),
        Accessory.PowerSupply(
            "ACC-350-12", "Accord ", UUID.randomUUID(), 1150, 350,
            FormFactorPowerSupply.ATX
        ),
        Accessory.PowerSupply(
            "ECO-450", "Aerocool  ", UUID.randomUUID(), 1800, 450,
            FormFactorPowerSupply.ATX
        ),
        Accessory.PowerSupply(
            "LW6-600W", "LinkWorld ", UUID.randomUUID(), 2350, 600,
            FormFactorPowerSupply.ATX
        ),
        Accessory.PowerSupply(
            "Aerocool ", "VX-700 ", UUID.randomUUID(), 3530, 700,
            FormFactorPowerSupply.ATX
        ),
        Accessory.Cooler(
            "Air Frost 2", "Aerocool ",
            UUID.randomUUID(), 910, 26, Socket.values().toList(),
            Material.ALUMINIUM
        ),
        Accessory.Cooler(
            "BAS AUG", "Aerocool ",
            UUID.randomUUID(), 900, 27, Socket.values().toList(),
            Material.ALUMINIUM
        ),
        Accessory.Cooler(
            "BETA 11 Soc-AMD", "Deepcool ",
            UUID.randomUUID(), 650, 30, listOf(Socket.AM2, Socket.AM3, Socket.FM2, Socket.FM3),
            Material.ALUMINIUM
        ),
        Accessory.Cooler(
            "CNPS80F Soc-AMD", "Zalman  ",
            UUID.randomUUID(), 550, 28, Socket.values().toList(),
            Material.ALUMINIUM
        ),
        Accessory.Gpu(
            "RX550",
            "AMD/ASUS",
            UUID.randomUUID(),
            7550,
            7000,
            2,
            400,
            VideoMemoryType.GDDR5
        ),
        Accessory.Gpu(
            "GV-R55XTGAMING", "AMD/Gigabyte ",
            UUID.randomUUID(), 17750, 7000, 4, 400,
            VideoMemoryType.GDDR6
        ),
        Accessory.Gpu(
            "RX5500XT",
            "AMD/MSI",
            UUID.randomUUID(),
            17200,
            7000,
            4,
            400,
            VideoMemoryType.GDDR6
        ),
        Accessory.Gpu(
            "GT1030", "Nvidia/Gigabyte ",
            UUID.randomUUID(), 7200, 2100, 2, 300,
            VideoMemoryType.GDDR4
        ),
        Accessory.Gpu(
            "GTX1650 ", "Nvidia/Gigabyte",
            UUID.randomUUID(), 15400, 12000, 4, 300,
            VideoMemoryType.GDDR6
        ),
        Accessory.Gpu(
            "GT710",
            "Nvidia/Palit ",
            UUID.randomUUID(),
            3550,
            1600,
            1,
            300,
            VideoMemoryType.GDDR3
        ),
        Accessory.ComputerCase(
            "3407", "Accord ",
            UUID.randomUUID(), 2220,
            FormFactor.values().toList(),
            TypeSizeComputerCase.Desktop, 8,
            listOf(Connector.Usb2, Connector.Usb2, Connector.Usb3, Connector.Audio),
            FormFactorPowerSupply.values().toList()
        ),
        Accessory.ComputerCase(
            "ACC-B021",
            "Accord ",
            UUID.randomUUID(),
            1700,
            listOf(FormFactor.MATX, FormFactor.MiniITX),
            TypeSizeComputerCase.Cube,
            4,
            listOf(Connector.Usb2, Connector.Usb2, Connector.Audio),
            FormFactorPowerSupply.values().toList()
        ),
        Accessory.ComputerCase(
            "ACC-B307", "Accord ",
            UUID.randomUUID(), 1710,
            FormFactor.values().toList(),
            TypeSizeComputerCase.Desktop, 3,
            listOf(Connector.Usb2, Connector.Usb3, Connector.Audio),
            FormFactorPowerSupply.values().toList()
        )
    )

    fun findAccessoryById(id: UUID) = allAccessories.find { it.id == id }

    fun getAccessoriesByType(type: String): List<Accessory> {
        when (type) {
            "Материнская плата" -> {
                return allAccessories.filterIsInstance<Accessory.MotherBoard>()
            }
            "Процессор" -> {
                return allAccessories.filterIsInstance<Accessory.Cpu>()
            }
            "Видеокарта" -> {
                return allAccessories.filterIsInstance<Accessory.Gpu>()
            }
            "Оперативная память" -> {
                return allAccessories.filterIsInstance<Accessory.Ram>()
            }
            "Устройство хранения" -> {
                return allAccessories.filterIsInstance<Accessory.Disk>()
            }
            "Устройство охлаждения" -> {
                return allAccessories.filterIsInstance<Accessory.Cooler>()
            }
            "Корпус" -> {
                return allAccessories.filterIsInstance<Accessory.ComputerCase>()
            }
            "Блок питания" -> {
                return allAccessories.filterIsInstance<Accessory.PowerSupply>()
            }
            else -> {
                return allAccessories
            }
        }
    }


}