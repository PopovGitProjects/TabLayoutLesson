package dev.popov.tablayoutlesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dev.popov.tablayoutlesson.databinding.FragmentUsecaseBinding

class FragmentUseCase : Fragment() {

    private val model: MainViewModel by activityViewModels()
    private var binding: FragmentUsecaseBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUsecaseBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.plant.observe(viewLifecycleOwner){
            binding?.tvUseCase?.text = it.useCase
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentUseCase()
    }
}