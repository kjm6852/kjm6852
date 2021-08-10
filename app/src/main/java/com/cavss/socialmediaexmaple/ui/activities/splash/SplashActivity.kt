package com.cavss.socialmediaexmaple.ui.activities.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.cavss.socialmediaexmaple.R
import com.cavss.socialmediaexmaple.databinding.ActivitySplashBinding
import com.cavss.socialmediaexmaple.ui.fragments.splash.FragmentLogin
import com.cavss.socialmediaexmaple.ui.fragments.splash.FragmentLogo
import com.cavss.socialmediaexmaple.ui.fragments.splash.FragmentRegister
import com.cavss.socialmediaexmaple.ui.vm.splash.SplashVM
import com.cavss.socialmediaexmaple.util.Strings

class SplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        try{
            super.onCreate(savedInstanceState)
            binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
            binding.run {
                val customSplashVM = ViewModelProvider(this@SplashActivity)[SplashVM::class.java]
                splashVM = customSplashVM
                lifecycleOwner = this@SplashActivity
            }
            setFrameLayout(frag = Strings.LOGO)
        }catch(e:Exception){
            Log.e("mException", "에러발생 : SplashActivity, onCreate  // Exception : ${e.message}")
        }
    }

    //----------------------------------------- frame 설정 ---------------------------------------------//
    private var fragLogo : FragmentLogo? = null
    private var fragLogin : FragmentLogin? = null
    private var fragRegister : FragmentRegister? = null
    fun setFrameLayout(frag : String){
        try{
            val manager = supportFragmentManager.beginTransaction()
            when(frag){
                Strings.LOGO -> {
                    // 프래그먼트 변경
                    if (fragLogo == null) fragLogo = FragmentLogo()
                    manager.replace(R.id.frameView, fragLogo!!).commit()
                }
                Strings.LOGIN -> {
                    // 프래그먼트 변경
                    if (fragLogin == null) fragLogin = FragmentLogin()
                    manager.replace(R.id.frameView, fragLogin!!).commit()
                }
                Strings.REGISTER -> {
                    // 프래그먼트 변경
                    if (fragRegister == null) fragRegister = FragmentRegister()
                    manager.replace(R.id.frameView, fragRegister!!).commit()
                }
            }
        }catch (e:Exception){
            Log.e("mException", "에러발생 : SplashActivity, setFrameLayout  // Exception : ${e.message}")
        }
    }
}