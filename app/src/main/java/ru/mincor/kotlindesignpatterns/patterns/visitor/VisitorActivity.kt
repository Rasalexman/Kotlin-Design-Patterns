package ru.mincor.kotlindesignpatterns.patterns.visitor

import android.os.Bundle
import ru.mincor.kotlindesignpatterns.activity.BackActivity

class VisitorActivity : BackActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "VISITOR EXAMPLE"

        val projectAlpha = FixedPriceContract(costPerYear = 10000)
        val projectBeta = SupportContract(costPerMonth = 500)
        val projectGamma = TimeAndMaterialsContract(hours = 150, costPerHour = 10)
        val projectKappa = TimeAndMaterialsContract(hours = 50, costPerHour = 50)

        val projects = arrayOf(projectAlpha, projectBeta, projectGamma, projectKappa)

        val monthlyCostReportVisitor = MonthlyCostReportVisitor()
        projects.forEach { it.accept(monthlyCostReportVisitor) }
        println("Monthly cost: ${monthlyCostReportVisitor.monthlyCost}")

    }
}