package com.cavss.socialmediaexmaple.ui.customs.popup

import android.content.Context
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.databinding.DataBindingUtil
import com.cavss.socialmediaexmaple.R
import com.cavss.socialmediaexmaple.databinding.PopupWindowBinding

class PopupView {
    private var context : Context? = null
    fun getContext(get : Context){ this.context = get }

    private var getPosition : View? = null
    fun getPlace(where : View){ this.getPosition = where }

    private var popupWindow : PopupWindow? = null
    fun showPopupView(x : Int, y : Int) : PopupWindow {
        try{
            val binding : PopupWindowBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.popup_window, null, false)
            popupWindow = PopupWindow(binding.root, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            popupWindow?.apply {
                isOutsideTouchable = true
                isFocusable = true
                elevation = 10.0f
//                setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                showAtLocation(getPosition, Gravity.NO_GRAVITY, x, y)
                update()
            }
            binding.popupDismiss.setOnClickListener {
                dismiss()
            }
//            if(recyclerview == null) recyclerview = binding.popupDropdownRecyclerview
        }catch(e : Exception){
            Log.e("mException","에러발생 : PopupView, showPopupView  // Exception : ${e.message}")
        }finally{
            return popupWindow!!
        }
    }

    fun dismiss(){
        if(popupWindow!!.isShowing){
            popupWindow?.dismiss()
            popupWindow = null
            if (popupWindow == null){
                Log.e("mException","PopupView 사라짐" )
            }
        }
    }
}