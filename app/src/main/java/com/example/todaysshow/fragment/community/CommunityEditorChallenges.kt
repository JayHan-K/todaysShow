package com.example.todaysshow.fragment.community

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.todaysshow.R
import com.example.todaysshow.adapter.EditorChallengesSpinnerAdapter
import com.example.todaysshow.fragment.CommunityFragment
import com.example.todaysshow.fragment.HomeFragment
import java.util.*
import kotlin.collections.ArrayList

class CommunityEditorChallenges : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewGroup: ViewGroup = inflater.inflate(R.layout.activity_editor_challenges, null) as ViewGroup

        var editorChallengesSpinner = viewGroup.findViewById<Spinner>(R.id.editor_challenges_spinner)
        var spinnerItems : ArrayList<String> = ArrayList()
        spinnerItems.add("공연 병아리 필수")
        spinnerItems.add("가족과 함께")
        spinnerItems.add("연인과 함께")
        spinnerItems.add("혼자가 딱좋아")
        spinnerItems.add("공연 좀 많이 봤니?")
        spinnerItems.add("집순이도 볼수있어")
        spinnerItems.add("해외가면 꼭 봐!")
        spinnerItems.add("극장 꿀팁")
        spinnerItems.add("공연별 꿀팁")
        var editorChallengesSpinnerAdater : EditorChallengesSpinnerAdapter = EditorChallengesSpinnerAdapter(spinnerItems,
            context!!
        )
        editorChallengesSpinner.adapter = editorChallengesSpinnerAdater
        editorChallengesSpinner.setSelection(10)

        var editorChallengesCloseButton = viewGroup.findViewById<Button>(R.id.editor_challenges_close_bt)
        editorChallengesCloseButton.setOnClickListener(View.OnClickListener {
            var parentFrag: CommunityFragment =
                this@CommunityEditorChallenges.parentFragment as CommunityFragment
            parentFrag.backToCommunity()
        })

        var editorChallengesAddPictureNoticeTextView : TextView = viewGroup.findViewById(R.id.editor_challenges_add_picture_notice_tv)
        var sText : SpannableString = SpannableString(editorChallengesAddPictureNoticeTextView.text)
        sText.setSpan(ForegroundColorSpan(Color.rgb(126, 50, 50)),9,17,0)
        sText.setSpan(ForegroundColorSpan(Color.rgb(126, 50, 50)),21,27,0)
        editorChallengesAddPictureNoticeTextView.text = sText


        var editorChallengesJournalEditText : EditText = viewGroup.findViewById(R.id.editor_challenges_journal_et)
        var editorChallengesJournalHintTextView : TextView = viewGroup.findViewById(R.id.editor_challenges_journal_hint_tv)

        editorChallengesJournalEditText.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(count!=0){
                    editorChallengesJournalHintTextView.visibility=View.INVISIBLE
                }else{
                    editorChallengesJournalHintTextView.visibility=View.VISIBLE
                }
            }

        })



        return viewGroup
    }
}
