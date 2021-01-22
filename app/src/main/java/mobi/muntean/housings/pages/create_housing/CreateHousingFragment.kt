package mobi.muntean.housings.pages.create_housing

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import kotlinx.android.synthetic.main.create_housing_fragment.*
import mobi.muntean.housings.Housing
import mobi.muntean.housings.MainViewModel
import mobi.muntean.housings.R

class CreateHousingFragment : Fragment() {

    companion object {
        fun newInstance() = CreateHousingFragment()
    }

    private val mainModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.create_housing_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        add_housing_button.setOnClickListener {
            val housing = Housing(
                address_edit_text.text.toString(),
                kvm_edit_text.text.toString().toInt()
            )

            mainModel.housingList.add(housing)

            activity?.supportFragmentManager?.popBackStack()
        }
    }

}