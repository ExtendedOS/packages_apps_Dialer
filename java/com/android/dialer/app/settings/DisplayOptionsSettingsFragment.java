/*
 * Copyright (C) 2015 The Android Open Source Project
 * Copyright (C) 2016-2019 The MoKee Open Source Project
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
 * limitations under the License
 */

package com.android.dialer.app.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import com.android.dialer.app.R;

public class DisplayOptionsSettingsFragment extends PreferenceFragment {

  private static final String SORT_ORDER = "sortOrder";
  private static final String DISPLAY_ORDER = "displayOrder";

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.xml.display_options_settings);

    if (!showDisplayOptions()) {
      getPreferenceScreen().removePreference(findPreference(SORT_ORDER));
      getPreferenceScreen().removePreference(findPreference(DISPLAY_ORDER));
    }
  }

  /**
   * Returns {@code true} or {@code false} based on whether the display options setting should be
   * shown. For languages such as Chinese, Japanese, or Korean, display options aren't useful
   * since contacts are sorted and displayed family name first by default.
   *
   * @return {@code true} if the display options should be shown, {@code false} otherwise.
   */
  private boolean showDisplayOptions() {
    return getResources().getBoolean(R.bool.config_display_order_user_changeable)
            && getResources().getBoolean(R.bool.config_sort_order_user_changeable);
  }
}
