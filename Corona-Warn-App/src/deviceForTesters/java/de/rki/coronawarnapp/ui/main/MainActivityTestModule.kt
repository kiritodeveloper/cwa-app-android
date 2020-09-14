package de.rki.coronawarnapp.ui.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import de.rki.coronawarnapp.test.risklevel.ui.TestRiskLevelCalculationFragment
import de.rki.coronawarnapp.test.risklevel.ui.TestRiskLevelCalculationFragmentModule

@Module
abstract class MainActivityTestModule {

    @ContributesAndroidInjector(modules = [TestRiskLevelCalculationFragmentModule::class])
    abstract fun testRiskLevelCalculationFragment(): TestRiskLevelCalculationFragment
}