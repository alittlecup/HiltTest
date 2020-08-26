/*
 * Copyright (C) 2020 The Dagger Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dagger.hilt.android.example.gradle.simpleKotlin

import android.app.Activity
import android.app.Application
import android.content.Context
import android.util.Log
import androidx.fragment.app.FragmentActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Singleton

data class TestApplicationHilt(val application: Context) {
  fun toast() {
    Log.d("TestApplicationHilt", "toast: $application")
    Log.d("TestApplicationHilt", "toast parent: ${application.javaClass.superclass?.simpleName} ")
  }
}

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {
  @UserName
  @Provides
  fun provideUserName(): String {
    return "Android User"
  }

  @Provides
  @ActivityScoped
  fun provideHiltApplication(application: Activity): TestApplicationHilt {
    return TestApplicationHilt(application)
  }


}
