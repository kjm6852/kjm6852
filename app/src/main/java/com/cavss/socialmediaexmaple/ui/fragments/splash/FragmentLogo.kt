package com.cavss.socialmediaexmaple.ui.fragments.splash

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.cavss.socialmediaexmaple.R
import com.cavss.socialmediaexmaple.databinding.FragSplashLogoBinding
import com.cavss.socialmediaexmaple.ui.activities.splash.SplashActivity
import com.cavss.socialmediaexmaple.util.Strings

class FragmentLogo : Fragment() {
    private lateinit var binding : FragSplashLogoBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        try{
            binding = DataBindingUtil.inflate(inflater, R.layout.frag_splash_logo, container, false)
            binding.run{
                lifecycleOwner = activity as SplashActivity
            }
            dummyFunction()
        }catch (e:Exception){
            Log.e("mException","에러발생 : FragmentLogo, onCreateView  // Exception : ${e.message}")
        }finally {
            return binding.root
        }
    }

    private fun dummyFunction(){
        try{
            binding.logoView.setOnClickListener {
                (activity as SplashActivity).setFrameLayout(Strings.LOGIN)
            }
        }catch (e:Exception){
            Log.e("mException","에러발생 : FragmentLogo, dummyFunction  // Exception : ${e.message}")
        }
    }
}