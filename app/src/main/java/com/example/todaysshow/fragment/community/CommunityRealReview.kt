package com.example.todaysshow.fragment.community

import android.app.SearchManager
import android.content.Context
import android.database.Cursor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.R
import com.example.todaysshow.`object`.DetailComment
import com.example.todaysshow.adapter.RealReviewCommentAdapter
import com.example.todaysshow.adapter.RealReviewSearchSuggestionAdapter
import java.util.*
import kotlin.collections.ArrayList


class CommunityRealReview : Fragment() {
    var communityRealReviceSearchBar : SearchView? = null
    var communityRealReviewCommentRecyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewGroup: ViewGroup = inflater.inflate(R.layout.activity_community_real_review_fragment, null) as ViewGroup

        communityRealReviceSearchBar = viewGroup.findViewById(R.id.community_real_review_search_bar)
        communityRealReviceSearchBar!!.setIconifiedByDefault(false)

        var searchManager : SearchManager = context!!.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        communityRealReviceSearchBar!!.setSearchableInfo(searchManager.getSearchableInfo(activity?.componentName));
        var a : Array<out String>
        a = arrayOf("showName")
        var b : IntArray
        b = intArrayOf(R.id.real_review_suggestion_iv,R.id.real_review_suggestion_title_tv, R.id.real_review_suggestion_tag_tv, R.id.real_review_suggestion_date_tv)
        communityRealReviceSearchBar!!.suggestionsAdapter = RealReviewSearchSuggestionAdapter(context!!,a, b)

        communityRealReviewCommentRecyclerView = viewGroup.findViewById(R.id.community_real_review_comment_rv)
        communityRealReviewCommentRecyclerView!!.layoutManager = LinearLayoutManager(context)
        communityRealReviewCommentRecyclerView!!.adapter = RealReviewCommentAdapter(getComments(), context!!)


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
            "어떤 페어로 봐도 완벽한 공연이었어요.\n넘버가 정말 좋았어요!!",
            "무대랑 객석이 너무 멀어요ㅜ\n최대한 앞자리에서 보는 게 좋아요!",
            128,
            35
        )
        )
        comments.add(DetailComment(
            "브로드웨이 42번가",
            "40분",
            R.drawable.editor_profile_1,
            "JG",
            "20대 / 병아리",
            false,
            "화려한 의상이랑 춤으로 즐겁게 보기 좋았어요!\n앙상블을 갈아서 만든 춤이라더니 진짜 군무 대박이에요!",
            "화려하지만 그에 반해 스토리가 약한 느낌..\n솔직히 뻔하고 지루한 스토리에요..",
            88,
            25
        ))
        comments.add(DetailComment(
            "썸씽로튼",
            "50분전",
            R.drawable.editor_profile_3,
            "우",
            "20대 / 병아리",
            true,
            "셰익스피어를 소재로해서 교육적으로도 굉장히 좋을 것 같아요.\n딸과 함께 봤는데 재밌다고 또 보러 가자네요.\n그리고 유연석님 너무 멋있어요~",
            "대사가 많은데 노래 속도가 너무 빨라서 잘 안들렸어요..\n가까이서 보면 그럴 일은 없겠죠..? ㅜ\n다음에는 돈 조금 더 들여서 1층으로 가렵니다..!",
            128,
            35
        ))
        comments.add(
            DetailComment(
                "오페라의 유령",
                "10분전",
                R.drawable.editor_profile_4,
                "제인",
                "20대 / 병아리",
                true,
                "어떤 페어로 봐도 완벽한 공연이었어요.\n넘버가 정말 좋았어요!!",
                "무대랑 객석이 너무 멀어요ㅜ\n최대한 앞자리에서 보는 게 좋아요!",
                128,
                35
            )
        )
        comments.add(DetailComment(
            "브로드웨이 42번가",
            "40분",
            R.drawable.editor_profile_1,
            "JG",
            "20대 / 병아리",
            false,
            "화려한 의상이랑 춤으로 즐겁게 보기 좋았어요!\n앙상블을 갈아서 만든 춤이라더니 진짜 군무 대박이에요!",
            "화려하지만 그에 반해 스토리가 약한 느낌..\n솔직히 뻔하고 지루한 스토리에요..",
            88,
            25
        ))
        comments.add(DetailComment(
            "썸씽로튼",
            "50분전",
            R.drawable.editor_profile_3,
            "우",
            "20대 / 병아리",
            true,
            "셰익스피어를 소재로해서 교육적으로도 굉장히 좋을 것 같아요.\n딸과 함께 봤는데 재밌다고 또 보러 가자네요.\n그리고 유연석님 너무 멋있어요~",
            "대사가 많은데 노래 속도가 너무 빨라서 잘 안들렸어요..\n가까이서 보면 그럴 일은 없겠죠..? ㅜ\n다음에는 돈 조금 더 들여서 1층으로 가렵니다..!",
            128,
            35
        ))



        return comments

    }
}
