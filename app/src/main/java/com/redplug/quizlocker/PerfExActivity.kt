package com.redplug.quizlocker

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_perf_ex.*

class PerfExActivity : AppCompatActivity() {

    //nameField 의 데이터를 저장할 Key
    val nameFieldKey = "nameField"

    // pushCheckBox 의 데이터를 저장할 Key
    val pushCheckBoxKey = "pushCheckBox"

    // shared perference 객체, Activity 초기화 이후에 사용해야 하기 때문에 lazy 위임을 사용
    val preference by lazy { getSharedPreferences("PerfExActivity", Context.MODE_PRIVATE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perf_ex)

        // 저장 버튼이 클릭된 경우
        saveButton.setOnClickListener {
            // SharedPreference 에서 nameFieldKey 키값으로 nameField 의 현재 텍스트를 저장한다.
            preference.edit().putString(nameFieldKey, nameField.text.toString()).apply()

            // Sharedpreference 에서 pushCheckBoxKey 키값으로 체크 박스의 현재 체크 상태를 저장한다.
            preference.edit().putBoolean(pushCheckBoxKey, pushCheckBox.isChecked).apply()
        }
        // 불러오기 버튼을 클릭한 경우
        loadButton.setOnClickListener{
            // SharedPreference 에서 nameFieldKey로 저장된 문자열을 불러와 nameField 의 텍스트로 설정
            nameField.setText(preference.getString(nameFieldKey, ""))

            // SharedPreference 에서 pushCheckBoxKey 키 값으로 불린값을 불러와 pushCheckBox 의 체크상태를 설정
            pushCheckBox.isChecked = preference.getBoolean(pushCheckBoxKey, false)
        }
    }


}
