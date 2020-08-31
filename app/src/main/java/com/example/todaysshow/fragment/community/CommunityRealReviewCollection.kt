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
import com.example.todaysshow.`object`.DetailComment
import com.example.todaysshow.adapter.RealReviewCommentCollectionAdapter
import com.example.todaysshow.fragment.CommunityFragment


class CommunityRealReviewCollection : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewGroup: ViewGroup = inflater.inflate(R.layout.fragment_real_review_collection, null) as ViewGroup
        var realReviewCollectionCloseButton : Button = viewGroup.findViewById(R.id.real_review_collection_close_bt)
        realReviewCollectionCloseButton.setOnClickListener(View.OnClickListener {
            var parentFrag: CommunityFragment =
                this@CommunityRealReviewCollection.parentFragment as CommunityFragment
            parentFrag.backToCommunity()
        })

        var realReviewCollectionRecyclerView : RecyclerView = viewGroup.findViewById(R.id.real_review_collection_rv)
        realReviewCollectionRecyclerView.layoutManager = LinearLayoutManager(context)
        realReviewCollectionRecyclerView.adapter = RealReviewCommentCollectionAdapter(getComments(), context!!)

        return viewGroup
    }

    fun getComments():ArrayList<DetailComment>{
        var comments:ArrayList<DetailComment> = ArrayList()
        comments.add(
            DetailComment(
                "오페라의 유령",
                "10분전",
                R.drawable.editor_profile_4,
                "제인",
                "20대 / 병아리",
                true,
                "볼거리가 풍부하고 감ㄷ몽적이었습니다.\n같이 본 가족들 모두 만족했어요!",
                "음향이 아쉬웠어요.. 초반에 잡음이 들렸지만\n곧 괜찮아졌어요. 비교적 만족!",
                128,
                35
            )
        )
        comments.add(
            DetailComment(
            "오페라의 유령",
            "40분",
            R.drawable.editor_profile_1,
            "JG",
            "20대 / 병아리",
            false,
            "다들 연기장인들이었어요! 완전 몰입해서\n봤습니다. 무대 의상도 화려하고, 오케스트라의\n웅장함이 가슴 뛰게 하네요ㅎㅎ 한번 더 보고 싶어요!",
            "하지만 너무 비싸요... VIP석이 절반은 넘는 듯\nㅜ할인 종류도 부족해서.. 뭔가 할인이 더 있으면\n좋을 듯요..",
            88,
            25
        )
        )
        comments.add(
            DetailComment(
            "오페라의 유령",
            "50분전",
            R.drawable.editor_profile_5,
            "우",
            "20대 / 병아리",
            true,
            "노래를 매우 잘합니다. 오리지널 캐스트라\n그런지 한국버전으로 봤을 때와 느낌도 다르고,\n새로운 느낌이네요! 그리고 넘버들이\n너무 좋아요.. 이건 아무도 반박불가..!",
            "대사가 많은데 노래 속도가 너무 빨라서 잘 안들렸어요..\n가까이서 보면 그럴 일은 없겠죠..? ㅜ\n다음에는 돈 조금 더 들여서 1층으로 가렵니다..!",
            128,
            35
        )
        )
        comments.add(
            DetailComment(
                "오페라의 유령",
                "10분전",
                R.drawable.editor_profile_4,
                "제인",
                "20대 / 병아리",
                true,
                "볼거리가 풍부하고 감ㄷ몽적이었습니다.\n같이 본 가족들 모두 만족했어요!",
                "음향이 아쉬웠어요.. 초반에 잡음이 들렸지만\n곧 괜찮아졌어요. 비교적 만족!",
                128,
                35
            )
        )
        comments.add(
            DetailComment(
                "오페라의 유령",
                "40분",
                R.drawable.editor_profile_1,
                "JG",
                "20대 / 병아리",
                false,
                "다들 연기장인들이었어요! 완전 몰입해서\n봤습니다. 무대 의상도 화려하고, 오케스트라의\n웅장함이 가슴 뛰게 하네요ㅎㅎ 한번 더 보고 싶어요!",
                "하지만 너무 비싸요... VIP석이 절반은 넘는 듯\nㅜ할인 종류도 부족해서.. 뭔가 할인이 더 있으면\n좋을 듯요..",
                88,
                25
            )
        )
        comments.add(
            DetailComment(
                "오페라의 유령",
                "50분전",
                R.drawable.editor_profile_5,
                "우",
                "20대 / 병아리",
                true,
                "노래를 매우 잘합니다. 오리지널 캐스트라\n그런지 한국버전으로 봤을 때와 느낌도 다르고,\n새로운 느낌이네요! 그리고 넘버들이\n너무 좋아요.. 이건 아무도 반박불가..!",
                "대사가 많은데 노래 속도가 너무 빨라서 잘 안들렸어요..\n가까이서 보면 그럴 일은 없겠죠..? ㅜ\n다음에는 돈 조금 더 들여서 1층으로 가렵니다..!",
                128,
                35
            )
        )


        return comments

    }

}
