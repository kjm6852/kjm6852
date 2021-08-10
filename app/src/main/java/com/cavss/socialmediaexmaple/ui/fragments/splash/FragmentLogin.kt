package com.cavss.socialmediaexmaple.ui.fragments.splash

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.cavss.socialmediaexmaple.R
import com.cavss.socialmediaexmaple.databinding.FragSplashLoginBinding
import com.cavss.socialmediaexmaple.ui.activities.main.MainActivity
import com.cavss.socialmediaexmaple.ui.activities.splash.SplashActivity
import com.cavss.socialmediaexmaple.util.Resize
import com.cavss.socialmediaexmaple.util.Strings

class FragmentLogin : Fragment() {
    private lateinit var binding : FragSplashLoginBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        try{
            binding = DataBindingUtil.inflate(inflater, R.layout.frag_splash_login, container, false)
            binding.run{
                lifecycleOwner = activity as SplashActivity
            }
        }catch (e:Exception){
            Log.e("mException","에러발생 : FragmentLogin, onCreateView  // Exception : ${e.message}")
        }finally {
            return binding.root
        }
    }

    override fun onStart() {
        try{
            super.onStart()
            moveRegisterView()
            moveMainView()
            setLayoutDesign()
        }catch (e:Exception){
            Log.e("mException","에러발생 : FragmentLogin, onStart  // Exception : ${e.message}")
        }
    }

    private fun moveRegisterView(){
        try{
            binding.register.setOnClickListener {
                (activity as SplashActivity).setFrameLayout(Strings.REGISTER)
            }
        }catch (e:Exception){
            Log.e("mException","에러발생 : FragmentLogin, moveRegisterView  // Exception : ${e.message}")
        }
    }
    private fun moveMainView(){
        try{
            binding.login.setOnClickListener {
                val nextIntent = Intent((activity as SplashActivity), MainActivity::class.java)
                startActivity(nextIntent)
            }
        }catch (e:Exception){
            Log.e("mException","에러발생 : FragmentLogin, moveMainView  // Exception : ${e.message}")
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
}