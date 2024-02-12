package com.clerodri.memitoapp.ui.record

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.clerodri.memitoapp.R

public class RecordFragmentDirections private constructor() {
  public companion object {
    public fun actionRecordFragmentToTodoFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_recordFragment_to_todoFragment)
  }
}
