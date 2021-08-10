package com.cavss.socialmediaexmaple.ui.fragments.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.cavss.socialmediaexmaple.R
import com.cavss.socialmediaexmaple.databinding.FragMainTimelineBinding
import com.cavss.socialmediaexmaple.ui.activities.main.MainActivity


class FragmentTimeLine : Fragment() {
    private lateinit var binding : FragMainTimelineBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        try{
            binding = DataBindingUtil.inflate(inflater, R.layout.frag_main_timeline, container, false)
            binding.run{
                lifecycleOwner = activity as MainActivity
            }
            dummyFunction()
        }catch (e:Exception){
            Log.e("mException","에러발생 : FragmentTimeLine, onCreateView  // Exception : ${e.message}")
        }finally {
            return binding.root
        }
    }

    private fun dummyFunction(){
        try{

        }catch (e:Exception){
            Log.e("mException","에러발생 : FragmentTimeLine, dummyFunction  // Exception : ${e.message}")
        }
    }
}