package com.example.todaysshow.fragment

import android.content.Context
import android.graphics.Point
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.ItemClickListener
import com.example.todaysshow.R
import com.example.todaysshow.`object`.Comment
import com.example.todaysshow.`object`.Journal
import com.example.todaysshow.adapter.CommentAdapter
import com.example.todaysshow.adapter.CommunityEditorsJournalAdapter
import com.example.todaysshow.adapter.RealReviewSearchSuggestionAdapter

class JournalDetailFragment(parent: String) : Fragment(){
    var parent = parent
    var journalDetailCommentRecyclerView : RecyclerView? = null
    var journalDetailOtherJournalRecyclerView : RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewGroup: ViewGroup = inflater.inflate(R.layout.activity_journal_detail_fragment, null) as ViewGroup


        var wm : WindowManager = context!!.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        var display : Display = wm.defaultDisplay
        var size : Point = Point()
        display.getSize(size)
        var width = size.x
        var height = size.y
        var journalDetailMainImageViewRelativeLayout: RelativeLayout = viewGroup.findViewById(R.id.journal_detail_main_iv_rl)
        var metrics : DisplayMetrics = context!!.resources.displayMetrics
        var heightDouble : Double = height * 0.9
        height = heightDouble.toInt()
        setSizeInDP(journalDetailMainImageViewRelativeLayout, width, height)


        val mListener : ItemClickListener = object : ItemClickListener {
            override fun onItemClicked(vh: RecyclerView.ViewHolder, item: Any, pos: Int) {
                if (parent.equals("Home")) {
                    var parentFrag: HomeFragment =
                        this@JournalDetailFragment.parentFragment as HomeFragment
                    parentFrag.homeChangeToJournalDetail()
                }else if(parent.equals("Search")){
                    var parentFrag: SearchFragment =
                        this@JournalDetailFragment.parentFragment as SearchFragment
                    parentFrag.changeSearchFrameToJournalDetail()
                }else if(parent.equals("Community")){
                    var parentFrag: CommunityFragment =
                        this@JournalDetailFragment.parentFragment as CommunityFragment
                    parentFrag.communityChangeToJournalDetail()
                }
            }

            override fun onItemClicked(
                v: RealReviewSearchSuggestionAdapter.ViewHolder,
                item: Any,
                pos: Int
            ) {

            }
        }

        journalDetailOtherJournalRecyclerView = viewGroup.findViewById(R.id.journal_detail_other_journal_rv)
        journalDetailOtherJournalRecyclerView!!.adapter = CommunityEditorsJournalAdapter(getJournals(), context!!,mListener)
        var gridLayoutManager : GridLayoutManager = GridLayoutManager(context!!, 2)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup(){
            override fun getSpanSize(position: Int): Int {
                when(position){
                    else -> return 1
                }
            }
        }
        journalDetailOtherJournalRecyclerView!!.layoutManager = gridLayoutManager


        var journalDetailMainJournalTextView : TextView = viewGroup.findViewById(R.id.journal_detail_main_jorunal_tv)
        var journalStr : String = "천리도 못 가서 발병난다. 내가 그의 이름을 불러 주었을 때 그는 돌같이 하라 뭉치면 살고 흩어지면 죽는다. 이 몸이 죽고 죽어 일백번 고쳐 죽어도 임 향한 일편단심 가실 줄이 있으랴.\n\n관용은 미덕이다. 가서 발병난다. 주었을 때 이 몸이 죽고 죽어 일백번 고쳐 죽어 백골이 진토되어 넑이라도 있고 었고 관용은\n\n그는 나에게로 와서 꽃이 되었다. 황금 보기를 돌같이 죽는다. 미덕이다. 왜 사냐건 웃지요. 나를 버리고 가시는 님은 십리도 못가서 발병난다. 나에게로 와서 꽃이 되었다.\n\n황금 보기들 백골이 진토되어 넋이라고 있고 없이 하라 뭉치면 살고 흝어지면 ...."
        journalDetailMainJournalTextView.setText(journalStr)

        var journalDetailCloseButton: Button = viewGroup.findViewById(R.id.journal_detail_fragment_close_bt)
        journalDetailCloseButton.setOnClickListener(View.OnClickListener {
            if (parent.equals("Home")) {
                var parentFrag: HomeFragment =
                    this@JournalDetailFragment.parentFragment as HomeFragment
                parentFrag.BackToHome()
            }else if(parent.equals("Search")){
                var parentFrag: SearchFragment =
                    this@JournalDetailFragment.parentFragment as SearchFragment
                parentFrag.backToSearchFrame()
            }else if(parent.equals("Community")){
                var parentFrag: CommunityFragment =
                    this@JournalDetailFragment.parentFragment as CommunityFragment
                parentFrag.backToCommunity()
            }
        })


        journalDetailCommentRecyclerView = viewGroup.findViewById(R.id.journal_detail_comment_rv)
        journalDetailCommentRecyclerView!!.adapter = CommentAdapter(getComments(), context!!)
        journalDetailCommentRecyclerView!!.layoutManager = LinearLayoutManager(context!!)



        return viewGroup
    }

    fun setSizeInDP(view: View, width: Int, height: Int){
        if(view.layoutParams is ViewGroup.LayoutParams){
            val screenDensity : Float = view.context.resources.displayMetrics.density
            val params : ViewGroup.LayoutParams = view.layoutParams as ViewGroup.LayoutParams

            params.width = width
            params.height = height
            view.requestLayout()
        }
    }

    fun getJournals() : ArrayList<Journal> {
        val journals = java.util.ArrayList<Journal>()
        journals.add(
            Journal(
                "공연 병아리\n필수",
                R.drawable.editors_sample1
            )
        )
        journals.add(
            Journal(
                "연인과 함께",
                R.drawable.editors_sample2
            )
        )
        journals.add(
            Journal(
                "가족과 함께?",
                R.drawable.editors_sample3
            )
        )
        journals.add(
            Journal(
                "4대 뮤지컬\n오페라의 유령",
                R.drawable.editors_sample4
            )
        )
        journals.add(
            Journal(
                "2020\n공연트렌트",
                R.drawable.family
            )
        )
        journals.add(
            Journal(
                "샤롯데 씨어\n첫! 방문기",
                R.drawable.alone
            )
        )

        return journals
    }

    fun getComments():ArrayList<Comment>{
        val comments: ArrayList<Comment> = ArrayList()
        comments.add(Comment(R.drawable.editor_profile_1, "프로필1", "워낙 유명해서 봤는데 저는 그저그랬어요. 그래도 한 번은 볼만해요!"))
        comments.add(Comment(R.drawable.editor_profile_2, "프로필2", "부모님과 함께 보기 좋았어요! 누구와 봐도 좋을 공연이었습니다. 다른 글도 기다리고 있어요!"))
        comments.add(Comment(R.drawable.editor_profile_3, "프로필3", "우와 정말 도움이 많이 됐어요! 관련있는 다른 공연도 추천해주세요~"))

        return comments
    }
}
