package com.softwarepro.mygolf.ui.settings

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.android.material.textfield.TextInputLayout
import com.softwarepro.mygolf.R
import kotlin.math.log

class SettingsFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        var darkLightToggle: SwitchMaterial = view.findViewById(R.id.darkModeToggle)
        var handicapInput: TextInputLayout = view.findViewById(R.id.handicapInput)
        var radioGroup: RadioGroup = view.findViewById(R.id.radioGroup)

        //Buttons
        var resetAppButton: Button = view.findViewById(R.id.resetButton)
        var updateHandicapButton: Button = view.findViewById(R.id.button3)

        // Handicap Current Value
        var handicapLabel: TextView = view.findViewById(R.id.currentHandicap)
        // Current scoring method
        var currentScoringMethod: TextView = view.findViewById(R.id.currentScoringMethod)

        updateHandicapButton.setOnClickListener {
            if(handicapInput.editText?.text.toString() != "")
            {
                Log.d("TEST","Value Entered")
                handicapLabel.text = "Current Handicap: ${handicapInput.editText?.text.toString()}"
            }
            else{
                // popup please enter a handicap value
                Log.d("TEST","No Value Entered")
            }
        }
        

        return view
    }
}