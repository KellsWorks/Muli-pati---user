package app.mulipati.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import app.mulipati.R
import app.mulipati.adapters.PagerAdapter
import app.mulipati.databinding.ActivityOnBoardingBinding
import app.mulipati.ui.onboard.FirstSlider
import app.mulipati.ui.onboard.SecondSlider
import app.mulipati.ui.onboard.ThirdSlider
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator


class OnBoarding : AppCompatActivity() {

    private lateinit var onBoardingBinding: ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onBoardingBinding = DataBindingUtil.setContentView(this, R.layout.activity_on_boarding)

        setupViewPager()

        onBoardingBinding.skip.setOnClickListener {
            startActivity(Intent(this, AuthenticationActivity::class.java))
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }
    }

    private fun setupViewPager() {

        val adapter = PagerAdapter(supportFragmentManager)

        adapter.addFragment(FirstSlider() , " One ")
        adapter.addFragment(SecondSlider() , " two ")
        adapter.addFragment(ThirdSlider(), "Three")

        onBoardingBinding.onBoardPager.adapter = adapter

        onBoardingBinding.dotsIndicator.setViewPager(onBoardingBinding.onBoardPager)

        onBoardingBinding.onBoardPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {

            }
        })



    }
}