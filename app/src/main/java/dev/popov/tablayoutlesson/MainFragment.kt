package dev.popov.tablayoutlesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dev.popov.tablayoutlesson.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var binding: FragmentMainBinding? = null
    private val model: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.button?.setOnClickListener {
            model.plant.value = context?.let { it1 ->
                PlantModel(
                    R.drawable.plant,
                    info = it1.getString(R.string.info),
                    useCase = requireContext().getString(R.string.use_case)
                )
            }
            (activity as AppCompatActivity).supportFragmentManager
                .beginTransaction()
                .replace(R.id.holder, ContentFragment.newInstance())
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MainFragment()
    }
}