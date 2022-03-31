package dev.popov.tablayoutlesson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import dev.popov.tablayoutlesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val fragList = listOf(
        Fragment1.newInstance(),
        Fragment2.newInstance(),
        Fragment3.newInstance()
    )
    private val fragTitleList = listOf(
        "One",
        "Two",
        "Three"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ViewPagerAdapter(this, fragList)
        binding.viewPager2.adapter = adapter
        binding.apply {
            TabLayoutMediator(tabLayout, viewPager2){
                tab, pos -> tab.text = fragTitleList[pos]
            }.attach()
        }

    }
}