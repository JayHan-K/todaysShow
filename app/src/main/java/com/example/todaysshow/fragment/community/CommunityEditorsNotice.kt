package com.example.todaysshow.fragment.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.R
import com.example.todaysshow.`object`.Notice
import com.example.todaysshow.adapter.NoticeAdapter
import com.example.todaysshow.fragment.CommunityFragment

class CommunityEditorsNotice : Fragment() {

    var communityEditorNoticeRecyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewGroup: ViewGroup = inflater.inflate(R.layout.fragment_notice, null) as ViewGroup

        var noticeFragmentCloseButton : Button = viewGroup.findViewById(R.id.notice_fragment_close_bt)
        noticeFragmentCloseButton.setOnClickListener(View.OnClickListener {
            var parentFrag: CommunityFragment =
                this@CommunityEditorsNotice.parentFragment as CommunityFragment
            parentFrag.backToCommunity()
        })

        communityEditorNoticeRecyclerView = viewGroup.findViewById(R.id.notice_fragment_notice_rv)
        communityEditorNoticeRecyclerView!!.layoutManager = LinearLayoutManager(context)
        communityEditorNoticeRecyclerView!!.adapter = NoticeAdapter(getNotices(), context!!)




        return viewGroup
    }

    fun getNotices():ArrayList<Notice>{
        var notices : ArrayList<Notice> = ArrayList()
        notices.add(Notice(true, "2020 공연 문화 에티켓지키기", "오늘의 공연 | 2020-00-00"))
        notices.add(Notice(true, "코로나 19 안전수칙 및 공연 이용 규제 관련 공지", "오늘의 공연 | 2020-00-00"))
        notices.add(Notice(true, "공연 연기 일정 확인", "오늘의 공연 | 2020-00-00"))
        notices.add(Notice(false, "휴관 안내", "오늘의 공연 | 2020-00-00"))
        notices.add(Notice(false, "공연장 찾아오시는 길 안내", "오늘의 공연 | 2020-00-00"))
        notices.add(Notice(false, "임시공휴일 휴무 안내", "오늘의 공연 | 2020-00-00"))
        notices.add(Notice(false, "출석체크 포인트 안내", "오늘의 공연 | 2020-00-00"))
        notices.add(Notice(false, "멤버쉽 혜택 변경 안내", "오늘의 공연 | 2020-00-00"))
        notices.add(Notice(false, "오늘의 공연 APP 시스템 정비 안내", "오늘의 공연 | 2020-00-00"))
        notices.add(Notice(false, "티켓 예매 안내", "오늘의 공연 | 2020-00-00"))
        notices.add(Notice(false, "공연 연기 일정 확인", "오늘의 공연 | 2020-00-00"))
        notices.add(Notice(false, "휴관 안내", "오늘의 공연 | 2020-00-00"))
        notices.add(Notice(false, "공연장 찾아오시는 길 안내", "오늘의 공연 | 2020-00-00"))
        notices.add(Notice(false, "임시공휴일 휴무 안내", "오늘의 공연 | 2020-00-00"))
        notices.add(Notice(false, "출석체크 포인트 안내", "오늘의 공연 | 2020-00-00"))
        notices.add(Notice(false, "멤버쉽 혜택 변경 안내", "오늘의 공연 | 2020-00-00"))
        notices.add(Notice(false, "오늘의 공연 APP 시스템 정비 안내", "오늘의 공연 | 2020-00-00"))
        notices.add(Notice(false, "티켓 예매 안내", "오늘의 공연 | 2020-00-00"))
        notices.add(Notice(false, "공연 연기 일정 확인", "오늘의 공연 | 2020-00-00"))



        return notices
    }
}
