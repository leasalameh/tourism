package com.example.tourismghanem

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var backButton: Button
    private lateinit var titleText: TextView
    private lateinit var searchEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        backButton = findViewById(R.id.back_button)
        titleText = findViewById(R.id.region_label)
        searchEditText = findViewById(R.id.search_edit_text)

        // Initialize RecyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        // Set up initial view with regions
        setupRegions()

        // Set up the back button
        backButton.setOnClickListener {
            setupRegions()
            backButton.visibility = View.GONE
            searchEditText.visibility = View.GONE
            titleText.text = getString(R.string.label_region)
        }

        // Adding TextWatcher for search functionality
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                (recyclerView.adapter as? MainAdapter)?.filter(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun setupRegions() {
        val regions = listOf(
            MainAdapter.RegionItem("Middle East", R.drawable.region_middle_east),
            MainAdapter.RegionItem("Europe", R.drawable.region_europe)
        )
        recyclerView.adapter = MainAdapter(regions) { region ->
            showCountries(region.name)
        }
        searchEditText.visibility = View.GONE
    }

    private fun showCountries(region: String) {
        val countries = when (region) {
            "Middle East" -> listOf(
                MainAdapter.RegionItem("Lebanon", R.drawable.country_lebanon),
                MainAdapter.RegionItem("Dubai", R.drawable.country_dubai, true),
                MainAdapter.RegionItem("Qatar", R.drawable.country_qatar, true),
                MainAdapter.RegionItem("Egypt", R.drawable.country_egypt, true)
            )
            "Europe" -> listOf(
                MainAdapter.RegionItem("Paris", R.drawable.country_paris),
                MainAdapter.RegionItem("Barcelona", R.drawable.country_barcelona, true),
                MainAdapter.RegionItem("Madrid", R.drawable.country_madrid, true),
                MainAdapter.RegionItem("Rome", R.drawable.country_rome, true)
            )
            else -> emptyList() // Ensure this is properly formatted as a default case
        }
        recyclerView.adapter = MainAdapter(countries) { _ -> // Use '_' if 'item' is not used
            // Actions can be added here if needed when clicking on a country.
            // Currently, it does nothing as suggested by '_'.
        }
        backButton.visibility = View.VISIBLE
        searchEditText.visibility = View.VISIBLE
        titleText.text = getString(R.string.label_country)
    }

}
