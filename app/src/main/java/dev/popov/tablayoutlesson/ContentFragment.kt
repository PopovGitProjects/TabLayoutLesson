package dev.popov.tablayoutlesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.tabs.TabLayoutMediator
import dev.popov.tablayoutlesson.databinding.FragmentContentBinding

class ContentFragment : Fragment() {
    private var binding: FragmentContentBinding? = null
    private val model: MainViewModel by activityViewModels()

    private val fragList = listOf(
        FragmentInfo.newInstance(),
        FragmentUseCase.newInstance()
    )
    private val fragTitleList = listOf(
        "Description",
        "Employment"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContentBinding.inflate(inflater, container, false)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        model.plant.observe(viewLifecycleOwner){
            binding?.imageMain?.setImageResource(it.imageId)
        }

        val adapter = ViewPagerAdapter(activity as AppCompatActivity, fragList)
        binding?.viewPager2?.adapter = adapter
        binding?.apply {
            TabLayoutMediator(tabLayout, viewPager2){
                    tab, pos -> tab.text = fragTitleList[pos]
            }.attach()
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ContentFragment()
    }
}