package ru.mincor.kotlindesignpatterns.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import android.content.Intent
import ru.mincor.kotlindesignpatterns.patterns.builder.BuilderActivity
import ru.mincor.kotlindesignpatterns.patterns.abstractfactory.AbstractFactoryActivity
import ru.mincor.kotlindesignpatterns.patterns.decorator.DecoratorActivity
import ru.mincor.kotlindesignpatterns.patterns.observer.ObserverActivity
import ru.mincor.kotlindesignpatterns.patterns.strategy.StrategyActivity
import ru.mincor.kotlindesignpatterns.patterns.visitor.VisitorActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }

    inner class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
            verticalLayout {
                lparams(matchParent, matchParent)
                gravity = Gravity.CENTER_HORIZONTAL

                textView("PATTERNS:") {

                }.lparams {
                    topMargin = dip(16)
                }

                button("STRATEGY") {
                    onClick {
                        startActivity(Intent(this@MainActivity, StrategyActivity::class.java))
                    }
                }.lparams(dip(120)) {
                    topMargin = dip(16)
                }

                button("OBSERVER") {
                    onClick {
                        startActivity(Intent(this@MainActivity, ObserverActivity::class.java))
                    }
                }.lparams(dip(120)) {
                    topMargin = dip(16)
                }

                button("DECORATOR") {
                    onClick {
                        startActivity(Intent(this@MainActivity, DecoratorActivity::class.java))
                    }
                }.lparams(dip(120)) {
                    topMargin = dip(16)
                }

                button("BUILDER") {
                    onClick {
                        startActivity(Intent(this@MainActivity, BuilderActivity::class.java))
                    }
                }.lparams(dip(120)) {
                    topMargin = dip(16)
                }

                button("ABSTRACTFACTORY") {
                    onClick {
                        startActivity(Intent(this@MainActivity, AbstractFactoryActivity::class.java))
                    }
                }.lparams(dip(120)) {
                    topMargin = dip(16)
                }

                button("VISITOR") {
                    onClick {
                        startActivity(Intent(this@MainActivity, VisitorActivity::class.java))
                    }
                }.lparams(dip(120)) {
                    topMargin = dip(16)
                }
            }
        }
    }
}
