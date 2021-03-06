package com.example.pcconfigurator.Presentation.Adapters.ViewHolders

import Accessory
import Accessory.*
import android.annotation.SuppressLint
import android.opengl.Visibility
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pcconfigurator.Data.Models.Configuration
import com.example.pcconfigurator.Presentation.Fragments.IClickListenerCallBack
import com.example.pcconfigurator.R
import javax.security.auth.callback.Callback
import kotlin.math.acos

class ConfigurationDetailsAccessoriesViewHolder(itemView: View, callback: IClickListenerCallBack) :
    RecyclerView.ViewHolder(itemView) {

    init {
        itemView.setOnLongClickListener {
            callback.itemClick(adapterPosition)
            true
        }


    }

    //MotherBoardViews
    private lateinit var motherBoardLayout: LinearLayout
    private lateinit var titleMotherBoard: TextView
    private lateinit var nameMotherBoard: TextView
    private lateinit var vendorMotherBoard: TextView
    private lateinit var chipsetMotherBoard: TextView
    private lateinit var formFactorMotherBoard: TextView
    private lateinit var socketMotherBoard: TextView
    private lateinit var typeRamMotherBoard: TextView
    private lateinit var countRamMotherBoard: TextView
    private lateinit var m2MotherBoard: TextView

    //CpuViews
    private lateinit var cpuLayout: LinearLayout
    private lateinit var titleCpu: TextView
    private lateinit var nameCpu: TextView
    private lateinit var vendorCpu: TextView
    private lateinit var coresCountCpu: TextView
    private lateinit var streamsCountCpu: TextView
    private lateinit var cashCpu: TextView
    private lateinit var gpuCpu: TextView
    private lateinit var socketCpu: TextView

    //GpuViews
    private lateinit var gpuLayout: LinearLayout
    private lateinit var titleGpu: TextView
    private lateinit var nameGpu: TextView
    private lateinit var vendorGpu: TextView
    private lateinit var frequencyGpu: TextView
    private lateinit var memorySizeGpu: TextView
    private lateinit var powerGpu: TextView
    private lateinit var typeMemoryGpu: TextView

    //RamViews
    private lateinit var ramLayout: LinearLayout
    private lateinit var titleRam: TextView
    private lateinit var nameRam: TextView
    private lateinit var vendorRam: TextView
    private lateinit var frequencyRam: TextView
    private lateinit var sizeRam: TextView
    private lateinit var typeRam: TextView

    //CoolerViews
    private lateinit var coolerLayout: LinearLayout
    private lateinit var titleCooler: TextView
    private lateinit var nameCooler: TextView
    private lateinit var vendorCooler: TextView
    private lateinit var noiceCooler: TextView
    private lateinit var socketCooler: TextView
    private lateinit var typeCooler: TextView

    //PowerSupplyViews
    private lateinit var powerSupplyLayout: LinearLayout
    private lateinit var titlePowerSupply: TextView
    private lateinit var namePowerSupply: TextView
    private lateinit var vendorPowerSupply: TextView
    private lateinit var powerPowerSupply: TextView
    private lateinit var formFactorPowerSupply: TextView

    //DiskViews
    private lateinit var diskLayout: LinearLayout
    private lateinit var titleDisk: TextView
    private lateinit var nameDisk: TextView
    private lateinit var vendorDisk: TextView
    private lateinit var sizeDisk: TextView
    private lateinit var typeDisk: TextView

    //ComputerCaseViews
    private lateinit var computerCaseLayout: LinearLayout
    private lateinit var titleComputerCase: TextView
    private lateinit var nameComputerCase: TextView
    private lateinit var vendorComputerCase: TextView
    private lateinit var formFactorsComputerCase: TextView
    private lateinit var typeSizeComputerCase: TextView
    private lateinit var coolersCountComputerCase: TextView
    private lateinit var formFactorsPowerSupplyComputerCase: TextView

    @SuppressLint("SetTextI18n")
    fun initData(accessory: Accessory) {
        when (accessory) {
            is MotherBoard -> {
                initLayouts(accessory)
                titleMotherBoard = itemView.findViewById(R.id.title_mother_board)
                nameMotherBoard = itemView.findViewById(R.id.name_mother_board)
                nameMotherBoard.text = nameMotherBoard.text.toString() + accessory.name
                vendorMotherBoard = itemView.findViewById(R.id.vendor_mother_board)
                vendorMotherBoard.text = vendorMotherBoard.text.toString() + accessory.vendor
                chipsetMotherBoard = itemView.findViewById(R.id.chipset_mother_board)
                chipsetMotherBoard.text = chipsetMotherBoard.text.toString() + accessory.chipset
                formFactorMotherBoard = itemView.findViewById(R.id.formFactor_mother_board)
                formFactorMotherBoard.text =
                    formFactorMotherBoard.text.toString() + accessory.formFactor
                socketMotherBoard = itemView.findViewById(R.id.socket_mother_board)
                socketMotherBoard.text = socketMotherBoard.text.toString() + accessory.socket
                typeRamMotherBoard = itemView.findViewById(R.id.typeram_mother_board)
                typeRamMotherBoard.text = typeRamMotherBoard.text.toString() + accessory.typeRam
                countRamMotherBoard = itemView.findViewById(R.id.ramCount_mother_board)
                countRamMotherBoard.text = countRamMotherBoard.text.toString() + accessory.ramCount
                m2MotherBoard = itemView.findViewById(R.id.hasSlotForM2_mother_board)
                if (accessory.hasSlotForM2)
                    m2MotherBoard.text = m2MotherBoard.text.toString() + "есть"
                else
                    m2MotherBoard.text = m2MotherBoard.text.toString() + "нет"
            }
            is Cpu -> {
                initLayouts(accessory)
                titleCpu = itemView.findViewById(R.id.title_cpu)
                nameCpu = itemView.findViewById(R.id.name_сpu)
                nameCpu.text = nameCpu.text.toString() + accessory.name
                vendorCpu = itemView.findViewById(R.id.vendor_cpu)
                vendorCpu.text = vendorCpu.text.toString() + accessory.vendor
                coresCountCpu = itemView.findViewById(R.id.coresCount_cpu)
                coresCountCpu.text = coresCountCpu.text.toString() + accessory.coresCount
                streamsCountCpu = itemView.findViewById(R.id.streamsCount_cpu)
                streamsCountCpu.text = streamsCountCpu.text.toString() + accessory.streamsCount
                cashCpu = itemView.findViewById(R.id.cash_memory_cpu)
                cashCpu.text = cashCpu.text.toString() + accessory.cashMemory
                gpuCpu = itemView.findViewById(R.id.hasGpu_cpu)
                if (accessory.hasGpu)
                    gpuCpu.text = gpuCpu.text.toString() + "есть"
                else
                    gpuCpu.text = gpuCpu.text.toString() + "нет"

                socketCpu = itemView.findViewById(R.id.socket_cpu)
                socketCpu.text = socketCpu.text.toString() + accessory.socket
            }
            is Gpu -> {
                initLayouts(accessory)
                titleGpu = itemView.findViewById(R.id.title_gpu)
                nameGpu = itemView.findViewById(R.id.name_gpu)
                nameGpu.text = nameGpu.text.toString() + accessory.name
                vendorGpu = itemView.findViewById(R.id.vendor_gpu)
                vendorGpu.text = vendorGpu.text.toString() + accessory.vendor
                frequencyGpu = itemView.findViewById(R.id.core_frequency_gpu)
                frequencyGpu.text = frequencyGpu.text.toString() + accessory.coreFrequency
                memorySizeGpu = itemView.findViewById(R.id.memory_size_gpu)
                memorySizeGpu.text = memorySizeGpu.text.toString() + accessory.memorySize
                powerGpu = itemView.findViewById(R.id.power_gpu)
                powerGpu.text = powerGpu.text.toString() + accessory.power
                typeMemoryGpu = itemView.findViewById(R.id.video_memory_type)
                typeMemoryGpu.text = typeMemoryGpu.text.toString() + accessory.videoMemoryType
            }
            is Ram -> {
                initLayouts(accessory)
                titleRam = itemView.findViewById(R.id.title_ram)
                nameRam = itemView.findViewById(R.id.name_ram)
                nameRam.text = nameRam.text.toString() + accessory.name
                vendorRam = itemView.findViewById(R.id.vendor_ram)
                vendorRam.text = vendorRam.text.toString() + accessory.vendor
                frequencyRam = itemView.findViewById(R.id.frequency_ram)
                frequencyRam.text = frequencyRam.text.toString() + accessory.frequency
                sizeRam = itemView.findViewById(R.id.value_ram)
                sizeRam.text = sizeRam.text.toString() + accessory.valueRam
                typeRam = itemView.findViewById(R.id.typy_ram)
                typeRam.text = typeRam.text.toString() + accessory.typeRam
            }
            is Cooler -> {
                initLayouts(accessory)
                titleCooler = itemView.findViewById(R.id.title_cooler)
                nameCooler = itemView.findViewById(R.id.name_cooler)
                nameCooler.text = nameCooler.text.toString() + accessory.name
                vendorCooler = itemView.findViewById(R.id.vendor_cooler)
                vendorCooler.text = vendorCooler.text.toString() + accessory.vendor
                noiceCooler = itemView.findViewById(R.id.noice_cooler)
                noiceCooler.text = noiceCooler.text.toString() + accessory.noiceLvl
                socketCooler = itemView.findViewById(R.id.socket_cooler)
                socketCooler.text = socketCooler.text.toString() + accessory.socket
                typeCooler = itemView.findViewById(R.id.material_cooler)
                typeCooler.text = typeCooler.text.toString() + accessory.material
            }
            is PowerSupply -> {
                initLayouts(accessory)
                titlePowerSupply = itemView.findViewById(R.id.title_powersupply)
                namePowerSupply = itemView.findViewById(R.id.name_powersupply)
                namePowerSupply.text = namePowerSupply.text.toString() + accessory.name
                vendorPowerSupply = itemView.findViewById(R.id.vendor_powersupply)
                vendorPowerSupply.text = vendorPowerSupply.text.toString() + accessory.vendor
                powerPowerSupply = itemView.findViewById(R.id.power_powersupply)
                powerPowerSupply.text = powerPowerSupply.text.toString() + accessory.powerCount
                formFactorPowerSupply = itemView.findViewById(R.id.formFactor_powersupply)
                formFactorPowerSupply.text =
                    formFactorPowerSupply.text.toString() + accessory.formFactorPowerSupply
            }
            is Disk -> {
                initLayouts(accessory)
                titleDisk = itemView.findViewById(R.id.title_disk)
                nameDisk = itemView.findViewById(R.id.name_disk)
                nameDisk.text = nameDisk.text.toString() + accessory.name
                vendorDisk = itemView.findViewById(R.id.vendor_disk)
                vendorDisk.text = vendorDisk.text.toString() + accessory.vendor
                sizeDisk = itemView.findViewById(R.id.size_disk)
                sizeDisk.text = sizeDisk.text.toString() + accessory.diskSizeGB
                typeDisk = itemView.findViewById(R.id.type_disk)
                typeDisk.text = typeDisk.text.toString() + accessory.diskType
            }
            is ComputerCase -> {
                initLayouts(accessory)
                titleComputerCase = itemView.findViewById(R.id.title_computerCase)
                nameComputerCase = itemView.findViewById(R.id.name_computerCase)
                nameComputerCase.text = nameComputerCase.text.toString() + accessory.name
                vendorComputerCase = itemView.findViewById(R.id.vendor_computerCase)
                vendorComputerCase.text = vendorComputerCase.text.toString() + accessory.vendor
                formFactorsComputerCase = itemView.findViewById(R.id.form_factors_computerCase)
                formFactorsComputerCase.text =
                    formFactorsComputerCase.text.toString() + accessory.formFactors
                typeSizeComputerCase = itemView.findViewById(R.id.type_computerCase)
                typeSizeComputerCase.text =
                    typeSizeComputerCase.text.toString() + accessory.typeSize
                coolersCountComputerCase = itemView.findViewById(R.id.coolers_count_computerCase)
                coolersCountComputerCase.text =
                    coolersCountComputerCase.text.toString() + accessory.coolersCount
                formFactorsPowerSupplyComputerCase =
                    itemView.findViewById(R.id.form_factors_powerSupply_computerCase)
                formFactorsPowerSupplyComputerCase.text =
                    formFactorsPowerSupplyComputerCase.text.toString() + accessory.formFactorPowerSupply
            }
        }
    }

    private fun initLayouts(accessory: Accessory) {
        motherBoardLayout = itemView.findViewById(R.id.mother_board_layout)
        cpuLayout = itemView.findViewById(R.id.cpu_layout)
        computerCaseLayout = itemView.findViewById(R.id.computerCase_layout)
        diskLayout = itemView.findViewById(R.id.disk_layout)
        powerSupplyLayout = itemView.findViewById(R.id.powersupply_layout)
        coolerLayout = itemView.findViewById(R.id.cooler_layout)
        ramLayout = itemView.findViewById(R.id.ram_layout)
        gpuLayout = itemView.findViewById(R.id.gpu_layout)
        computerCaseLayout.visibility = View.GONE
        diskLayout.visibility = View.GONE
        powerSupplyLayout.visibility = View.GONE
        coolerLayout.visibility = View.GONE
        ramLayout.visibility = View.GONE
        gpuLayout.visibility = View.GONE
        cpuLayout.visibility = View.GONE
        motherBoardLayout.visibility = View.GONE
        when (accessory) {
            is MotherBoard -> motherBoardLayout.visibility = View.VISIBLE
            is Cpu -> cpuLayout.visibility = View.VISIBLE
            is Gpu -> gpuLayout.visibility = View.VISIBLE
            is Ram -> ramLayout.visibility = View.VISIBLE
            is Cooler -> coolerLayout.visibility = View.VISIBLE
            is PowerSupply -> powerSupplyLayout.visibility = View.VISIBLE
            is Disk -> diskLayout.visibility = View.VISIBLE
            is ComputerCase -> computerCaseLayout.visibility = View.VISIBLE
        }

    }
}