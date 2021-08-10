package com.cavss.socialmediaexmaple.ui.fragments.splash

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.cavss.socialmediaexmaple.R
import com.cavss.socialmediaexmaple.databinding.FragSplashRegisterBinding
import com.cavss.socialmediaexmaple.ui.activities.splash.SplashActivity
import com.cavss.socialmediaexmaple.util.Resize
import com.cavss.socialmediaexmaple.util.Strings

class FragmentRegister : Fragment() {
    private lateinit var binding : FragSplashRegisterBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        try{
            binding = DataBindingUtil.inflate(inflater, R.layout.frag_splash_register, container, false)
            binding.run{
                lifecycleOwner = activity as SplashActivity
            }
        }catch (e:Exception){
            Log.e("mException","에러발생 : FragmentRegister, onCreateView  // Exception : ${e.message}")
        }finally {
            return binding.root
        }
    }

    override fun onStart() {
        try{
            super.onStart()
            setLayoutDesign()
            backLoginView()
        }catch (e:Exception){
            Log.e("mException","에러발생 : FragmentRegister, onStart  // Exception : ${e.message}")
        }
    }

    private fun setLayoutDesign(){
        try{
            val emailIcon = Resize.imageResize(activity as SplashActivity, R.drawable.image_email, 16, 16 )
            val passwordIcon = Resize.imageResize(activity as SplashActivity, R.drawable.image_password, 16, 16 )
            binding.emailInput.setCompoundDrawablesWithIntrinsicBounds(emailIcon, null, null, null)
            binding.passwordInput.setCompoundDrawablesWithIntrinsicBounds(passwordIcon, null, null, null)
        }catch (e:Exception){
            Log.e("mException","에러발생 : FragmentLogin, moveRegisterView  // Exception : ${e.message}")
        }
    }
    private fun backLoginView(){
        try{
            binding.back.setOnClickListener {
                (activity as SplashActivity).setFrameLayout(Strings.LOGIN)
            }
        }catch (e:Exception){
            Log.e("mException","에러발생 : FragmentRegister, onStart  // Exception : ${e.message}")
        }
    }
}