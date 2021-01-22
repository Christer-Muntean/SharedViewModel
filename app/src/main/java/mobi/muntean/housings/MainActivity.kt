package mobi.muntean.housings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import mobi.muntean.housings.pages.create_housing.CreateHousingFragment
import mobi.muntean.housings.pages.housings.HousingsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setContentView(R.layout.activity_main)

        createHousings()

        navigationHandler(savedInstanceState)
    }

    private fun createHousings() {
        viewModel.housingList.add(Housing("Vei 2", 45))
        viewModel.housingList.add(Housing("Snuveien 4", 150))
    }

    private fun navigationHandler(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<HousingsFragment>(R.id.fragment_container_view)
            }
        }
    }

}