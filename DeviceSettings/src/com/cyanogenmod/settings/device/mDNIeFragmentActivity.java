/*
 * Copyright (C) 2012 The CyanogenMod Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cyanogenmod.settings.device;

import android.os.Bundle;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;

public class mDNIeFragmentActivity extends PreferenceFragment {

    private mDNIeScenario mDNIeScenario;
    private mDNIeMode mDNIeMode;
    private mDNIeNegative mDNIeNegative;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.mdnie_preferences);

        PreferenceCategory prefs = (PreferenceCategory) findPreference(DeviceSettings.CATEGORY_MDNIE);

        mDNIeScenario = (mDNIeScenario) findPreference(DeviceSettings.KEY_MDNIE_SCENARIO);
        if (!mDNIeScenario.isSupported()) {
            prefs.removePreference(mDNIeScenario);
        }

        mDNIeMode = (mDNIeMode) findPreference(DeviceSettings.KEY_MDNIE_MODE);
        if (!mDNIeMode.isSupported()) {
            prefs.removePreference(mDNIeMode);
        }

        mDNIeNegative = (mDNIeNegative) findPreference(DeviceSettings.KEY_MDNIE_NEGATIVE);
        if (!mDNIeNegative.isSupported()) {
            prefs.removePreference(mDNIeNegative);
        }

        if (prefs.getPreferenceCount() == 0) {
            getPreferenceScreen().removePreference(prefs);
        }
    }
}
