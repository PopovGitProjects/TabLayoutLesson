package dev.popov.tablayoutlesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dev.popov.tablayoutlesson.databinding.FragmentInfoBinding

class FragmentInfo : Fragment() {
    private val model: MainViewModel by activityViewModels()
    private var binding: FragmentInfoBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.plant.observe(viewLifecycleOwner){
            binding?.tvInfo?.text = it.info
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentInfo()
    }
}