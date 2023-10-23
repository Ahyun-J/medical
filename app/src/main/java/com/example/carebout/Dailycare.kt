package com.example.carebout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.ToggleButton
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.Date



class Dailycare : Fragment() {
    var nthDaily: Int = 0; // 데일리케어 개수
    var dailycareText = Array<String>(10, {"-"}) // 데일리케어 타이틀
    var dailycareNumber = Array<Int>(10, {0}) // 타이틀을 몇 번 해야하는지
    val st = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT , ViewGroup.LayoutParams.WRAP_CONTENT)
    val stBtn = LinearLayout.LayoutParams(130, 130)

    // 시간 가져오는 함수
    fun getTime() : String{
        var now: Long = System.currentTimeMillis();
        var date = Date(now);
        val sdf = SimpleDateFormat("mm");
        var getTime: String = sdf.format(date)

        return getTime
    }

    var saveTime: String = getTime()
    var crtTime: String = ""

    // 뼈다귀 토글버튼 리스너
    fun setButtonOnClick(bornButton: ToggleButton) {
        bornButton.setOnClickListener {
            if (bornButton.isChecked) {
                bornButton.setBackgroundDrawable(resources.getDrawable(R.drawable.fillborn))
            } else {
                bornButton.setBackgroundDrawable(resources.getDrawable(R.drawable.bornn))
            }
        }
    }

    lateinit var views: ToggleButton


    // 데일리케어 타이틀 아래에 들어갈 뼈다귀 모양 토글버튼 1개 생성
    fun setBornIcon() : View {
        var btnView = LinearLayout(this.context)

        for (i in 1..dailycareNumber[nthDaily]) {
            var bornButton = ToggleButton(this.context) // 버튼 생성
            bornButton.layoutParams = stBtn // 레이아웃 지정
            btnView.layoutParams = st
            views = bornButton
            bornButton.text = ""
            bornButton.textOn = ""
            bornButton.textOff = ""
            bornButton.setBackgroundDrawable(resources.getDrawable(R.drawable.bornn))
            setButtonOnClick(bornButton) // 리스너 연결

            btnView.addView(bornButton)
        }
        return btnView // 뷰 리턴
    }

    // 자정이 되면 뼈다귀 토글버튼 해제
    fun unSelectBorn(btn : ToggleButton) {
//        crtTime = getTime()
//        if(saveTime.toInt() < crtTime.toInt())
//            for (n in 0..nthDaily){
//
//            }

        btn.toggle()
//        saveTime = crtTime
    }

    // 데일리케어 타이틀의 텍스트뷰 생성
    fun setDailycare() : View {
        var dailycareTextView = TextView(this.context) // 빈 텍스트뷰 생성
        dailycareTextView.text = "\n-" + dailycareText[nthDaily] // 텍스트 넣기
        dailycareTextView.textSize = 18.0f
        dailycareTextView.layoutParams = st // 레이아웃 지정
        dailycareTextView.id = ViewCompat.generateViewId() // 아이디 랜덤으로 지정

        return dailycareTextView
    }

    // 데일리케어 정보를 insert
    fun insertDailycare(title: String, number: Int) {
        dailycareText[nthDaily] = title
        dailycareNumber[nthDaily] = number
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        val dailyView: View = inflater.inflate(R.layout.dailycare, container, false)
        val lay : LinearLayout = dailyView.findViewById(R.id.dailyLayout)

        insertDailycare("약 먹이기", 2)
        lay.addView(setDailycare())
        lay.addView(setBornIcon())
        nthDaily++;

        insertDailycare("산책", 3)
        lay.addView(setDailycare())
        lay.addView(setBornIcon())
        nthDaily++;

        return dailyView
    }


}
