/*
 * Copyright (c) 2014 - DeAngelo Mannie | Intravita LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.intravita.android.tsr;

import com.bugsnag.android.Bugsnag;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class TechjoyntSpheroApplication extends Application {
	private static final String BUGSNAG_ID = "8bcb52f416ae4ea56ea2fb851246bf8b";
	
	private static Context mApplicationContext;
	private static SharedPreferences mPrefs;
	
	@Override
	public void onCreate() {
		super.onCreate();
		Bugsnag.register(getApplicationContext(), BUGSNAG_ID);
		Bugsnag.setReleaseStage("development"); // TODO: Set Back to Production
		mApplicationContext = getApplicationContext();
		mPrefs = PreferenceManager.getDefaultSharedPreferences(mApplicationContext);
	}
	
	public static Context getGloablContext() {
		return mApplicationContext;
	}

	public static SharedPreferences getPrefs() {
		return mPrefs;
	}
}
