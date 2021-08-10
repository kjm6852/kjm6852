package com.cavss.socialmediaexmaple.ui.fragments.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.cavss.socialmediaexmaple.R
import com.cavss.socialmediaexmaple.databinding.FragMainChatBinding
import com.cavss.socialmediaexmaple.databinding.FragMainMainBinding
import com.cavss.socialmediaexmaple.ui.activities.main.MainActivity
import com.cavss.socialmediaexmaple.util.Strings

class FragmentMain : Fragment() {
    private lateinit var binding : FragMainMainBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        try{
            binding = DataBindingUtil.inflate(inflater, R.layout.frag_main_main, container, false)
            binding.run{
                lifecycleOwner = activity as MainActivity
            }
            dummyFunction()
        }catch (e:Exception){
            Log.e("mException","에러발생 : FragmentMain, onCreateView  // Exception : ${e.message}")
        }finally {
            return binding.root
        }
    }

    private fun dummyFunction(){
        try{

        }catch (e:Exception){
            Log.e("mException","에러발생 : FragmentMain, dummyFunction  // Exception : ${e.message}")
        }
    }
}