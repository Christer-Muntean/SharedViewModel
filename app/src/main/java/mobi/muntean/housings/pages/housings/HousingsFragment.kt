package mobi.muntean.housings.pages.housings

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import kotlinx.android.synthetic.main.housings_fragment.*
import mobi.muntean.housings.MainViewModel
import mobi.muntean.housings.R
import mobi.muntean.housings.pages.create_housing.CreateHousingFragment

class HousingsFragment : Fragment() {

    companion object {
        fun newInstance() = HousingsFragment()
    }

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.housings_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigate_add_housing_button.setOnClickListener {
            activity?.supportFragmentManager?.commit {
                setReorderingAllowed(true)
                addToBackStack(null)
                replace(R.id.fragment_container_view, CreateHousingFragment())
            }
        }

        housings_text_view.text = ""
        for (housing in viewModel.housingList){
            housings_text_view.append("${housing.address} ${housing.kvm} kvm\n")
        }
    }
}