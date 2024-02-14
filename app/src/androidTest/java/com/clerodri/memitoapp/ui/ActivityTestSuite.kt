package com.clerodri.memitoapp.ui

import com.clerodri.memitoapp.ui.record.MainActivityTest
import com.clerodri.memitoapp.ui.record.RecordFragmentTest
import org.junit.runner.RunWith
import org.junit.runners.Suite


@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivityTest::class,
    RecordFragmentTest::class,
)
class ActivityTestSuite
