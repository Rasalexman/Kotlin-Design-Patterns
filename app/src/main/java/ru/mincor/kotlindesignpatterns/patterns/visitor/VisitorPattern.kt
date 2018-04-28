package ru.mincor.kotlindesignpatterns.patterns.visitor


/**
The visitor pattern is used to separate a relatively complex set of structured data classes from the functionality that may be performed upon the data that they hold.
 */
interface ReportVisitable {
    fun accept(visitor: ReportVisitor)
}

class FixedPriceContract(val costPerYear: Long) : ReportVisitable {
    override fun accept(visitor: ReportVisitor) = visitor.visit(this)
}

class TimeAndMaterialsContract(val costPerHour: Long, val hours: Long) : ReportVisitable {
    override fun accept(visitor: ReportVisitor) = visitor.visit(this)
}

class SupportContract(val costPerMonth: Long) : ReportVisitable {
    override fun accept(visitor: ReportVisitor) = visitor.visit(this)
}

interface ReportVisitor {
    fun visit(contract: FixedPriceContract)
    fun visit(contract: TimeAndMaterialsContract)
    fun visit(contract: SupportContract)
}

class MonthlyCostReportVisitor(var monthlyCost: Long = 0) : ReportVisitor {
    override fun visit(contract: FixedPriceContract) {
        monthlyCost += contract.costPerYear / 12
    }

    override fun visit(contract: TimeAndMaterialsContract) {
        monthlyCost += contract.costPerHour * contract.hours
    }

    override fun visit(contract: SupportContract) {
        monthlyCost += contract.costPerMonth
    }
}