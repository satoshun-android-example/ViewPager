package com.github.satoshun.example.lazyload

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.LazyLoadFragBinding

class LazyLoadFragment : Fragment(R.layout.lazy_load_frag) {
  private val binding: LazyLoadFragBinding get() = LazyLoadFragBinding.bind(requireView())

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.viewPager.adapter = LazyLoadFragmentAdapter(this)
  }
}

class LazyLoadFragmentAdapter(
  fragment: Fragment
) : FragmentStatePagerAdapter(
  fragment.childFragmentManager
//  BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
  override fun getCount(): Int = 5

  override fun getItem(position: Int): Fragment =
    if (position == 0) Fragment1()
    else Fragment2()
}

class Fragment1 : Fragment(R.layout.lazy_load_test_frag) {
  private val TAG = "Fragment1"

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    println("LAZYLOAD ViewCreated $TAG")
  }

  override fun onResume() {
    super.onResume()

    println("LAZYLOAD onResume $TAG")
  }
}

class Fragment2 : Fragment(R.layout.lazy_load_test_frag) {
  private val TAG = "Fragment2"

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    println("LAZYLOAD ViewCreated $TAG")
  }

  override fun onResume() {
    super.onResume()

    println("LAZYLOAD onResume $TAG")
  }
}
