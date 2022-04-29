package com.onpu.lab5

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayoutMediator
import com.onpu.lab5.databinding.ActivityT2Binding
import com.onpu.lab5.databinding.FragmentT2Binding

class Task2Activity : AppCompatActivity() {

    lateinit var binding: ActivityT2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupViewPager()
    }

    private fun setupBinding() {
        supportActionBar?.hide()

        binding = ActivityT2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupViewPager() {
        val list = setupData()
        binding.t2Vp.adapter = T2ViewPagerAdapter(list)

        binding.apply {
            TabLayoutMediator(t2Tl, t2Vp) { tab, position ->
                tab.text = list[position].text
            }.attach()
        }
    }

    private fun setupData(): List<FragmentModel> {
        return listOf(
            FragmentModel("Fragment 1", R.drawable.ic_baseline_adb_24),
            FragmentModel("Fragment 2", R.drawable.ic_baseline_cloud_circle_24),
            FragmentModel("Fragment 3", R.drawable.ic_baseline_architecture_24),
            FragmentModel("Fragment 4", R.drawable.ic_baseline_adb_24),
        )
    }

    class T2ViewPagerAdapter(private val list: List<FragmentModel>) :
        RecyclerView.Adapter<ViewHolder>() {

        override fun getItemCount(): Int = list.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_t2, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(list[position])
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = FragmentT2Binding.bind(itemView)

        fun bind(model: FragmentModel) {
            binding.t2FTv.text = model.text
            binding.t2FIv.setBackgroundResource(model.imgSrc)
        }
    }

    data class FragmentModel(
        val text: String,
        val imgSrc: Int
    )
}