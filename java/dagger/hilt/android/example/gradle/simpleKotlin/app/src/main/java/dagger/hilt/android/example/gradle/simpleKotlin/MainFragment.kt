package dagger.hilt.android.example.gradle.simpleKotlin

import android.os.Bundle
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : BaseFragment() {

  @Inject
  lateinit var testApplicationHilt: TestApplicationHilt

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    testApplicationHilt.toast()
    Log.d("MainFragment", "onCreate: parentFragment ${parentFragment}")
  }
}