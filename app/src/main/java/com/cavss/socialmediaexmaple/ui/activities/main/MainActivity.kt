package com.cavss.socialmediaexmaple.ui.activities.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cavss.socialmediaexmaple.BR
import com.cavss.socialmediaexmaple.R
import com.cavss.socialmediaexmaple.databinding.ActivityMainBinding
import com.cavss.socialmediaexmaple.databinding.HolderDockBinding
import com.cavss.socialmediaexmaple.ui.customs.dock.DockModel
import com.cavss.socialmediaexmaple.ui.customs.recyclerview.BaseRecyclerViewAdapter
import com.cavss.socialmediaexmaple.ui.customs.recyclerview.IClickListener
import com.cavss.socialmediaexmaple.ui.fragments.main.FragmentChat
import com.cavss.socialmediaexmaple.ui.fragments.main.FragmentMain
import com.cavss.socialmediaexmaple.ui.fragments.main.FragmentTimeLine
import com.cavss.socialmediaexmaple.ui.fragments.splash.FragmentLogin
import com.cavss.socialmediaexmaple.ui.fragments.splash.FragmentLogo
import com.cavss.socialmediaexmaple.ui.fragments.splash.FragmentRegister
import com.cavss.socialmediaexmaple.ui.vm.main.MainVM
import com.cavss.socialmediaexmaple.util.Strings

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        try{
            super.onCreate(savedInstanceState)
            binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
            binding.run {
                val customMainVM = ViewModelProvider(this@MainActivity)[MainVM::class.java]
                mainVM = customMainVM
                lifecycleOwner = this@MainActivity
            }
        }catch(e:Exception){
            Log.e("mException", "에러발생 : MainActivity, onCreate  // Exception : ${e.message}")
        }
    }

    override fun onStart() {
        try{
            super.onStart()
            setDockView(binding.dockView)
            setFrameLayout(Strings.TIMELINE)
        }catch(e:Exception){
            Log.e("mException", "에러발생 : MainActivity, onStart  // Exception : ${e.message}")
        }
    }

    //----------------------------------------- frame 설정 ---------------------------------------------//
    private var fragMain : FragmentMain? = null
    private var fragChat : FragmentChat? = null
    private var fragTimeLine : FragmentTimeLine? = null
    private fun setFrameLayout(frag : String){
        try{
            val manager = supportFragmentManager.beginTransaction()
            when(frag){
                Strings.MAIN -> {
                    // 프래그먼트 변경
                    if (fragMain == null) fragMain = FragmentMain()
                    manager.replace(R.id.frameView_main, fragMain!!).commit()
                }
                Strings.CHAT -> {
                    // 프래그먼트 변경
                    if (fragChat == null) fragChat = FragmentChat()
                    manager.replace(R.id.frameView_main, fragChat!!).commit()
                }
                Strings.TIMELINE -> {
                    // 프래그먼트 변경
                    if (fragTimeLine == null) fragTimeLine = FragmentTimeLine()
                    manager.replace(R.id.frameView_main, fragTimeLine!!).commit()
                }
            }
        }catch (e:Exception){
            Log.e("mException", "에러발생 : SplashActivity, setFrameLayout  // Exception : ${e.message}")
        }
    }

    //----------------------------------------- dockView 설정 ---------------------------------------------//
    private fun setDockView(recyclerView : RecyclerView){
        try{
            val clickEvent = object : IClickListener {
                override fun onClick(position: Int, listValueString: Any?) {
                    if(listValueString is DockModel){
                        when(listValueString.itemTitle){
                            Strings.MAIN -> {
                                setFrameLayout(Strings.MAIN)
                            }
                            Strings.CHAT -> {
                                setFrameLayout(Strings.CHAT)
                            }
                            Strings.TIMELINE -> {
                                setFrameLayout(Strings.TIMELINE)
                            }
                        }
                    }
                }
            }
            val dockAdapter = object : BaseRecyclerViewAdapter.Adapter<DockModel, HolderDockBinding>(
                layoutResId = R.layout.holder_dock,
                bindingVariableId = BR.dockModel,
                bindingClickVariableID = BR.clickListener
            ){}

            val dockList = mutableListOf(
                DockModel(
                    itemTitle = Strings.MAIN,
                    itemImage = ResourcesCompat.getDrawable(resources, R.drawable.ic_launcher_background, null)
                ),
                DockModel(
                    itemTitle = Strings.CHAT,
                    itemImage = ResourcesCompat.getDrawable(resources, R.drawable.ic_launcher_background, null)
                ),
                DockModel(
                    itemTitle = Strings.TIMELINE,
                    itemImage = ResourcesCompat.getDrawable(resources, R.drawable.ic_launcher_background, null)
                )
            )
            dockAdapter.let {
                it.setOnClick(clickListener = clickEvent)
                it.updateList(dockList)
            }

            recyclerView.apply {
                adapter = dockAdapter
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@MainActivity).apply{
                    orientation = LinearLayoutManager.HORIZONTAL
                    isItemPrefetchEnabled = false
                }
                setItemViewCacheSize(0)
            }
        }catch(e:Exception){
            Log.e("mException", "에러발생 : MainActivity, setDockView  // Exception : ${e.message}")
        }
    }

}