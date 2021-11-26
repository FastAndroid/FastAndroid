package com.magicworld.ecosantander.preference

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.magicworld.ecosantander.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}