package com.example.todaysshow.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.todaysshow.CategoryActivity
import com.example.todaysshow.CircleIndicator
import com.example.todaysshow.ItemClickListener
import com.example.todaysshow.`object`.Journal
import com.example.todaysshow.R
import com.example.todaysshow.`object`.Show
import com.example.todaysshow.adapter.HomeAdPagerAdapter
import com.example.todaysshow.adapter.HomeShowAdapter
import com.example.todaysshow.adapter.JournalAdapter

class HomeFragment : Fragment(){

    var journalList : ArrayList<Journal>? = null
    var personalizedShow : ArrayList<Show>? = null
    var recommendedShow : ArrayList<Show>? = null
    var homeFragmentMainScrollView : ScrollView? = null
    var homeFragmentChildFragment : FrameLayout? = null
    var homeFragmentTopTitleLinearLayout : LinearLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewGroup: ViewGroup =
            inflater.inflate(R.layout.activity_home_fragment, null) as ViewGroup

        homeFragmentMainScrollView = viewGroup.findViewById(R.id.home_fragment_main_sv)
        homeFragmentChildFragment = viewGroup.findViewById(R.id.home_fragment_child_fragment)
        homeFragmentTopTitleLinearLayout = viewGroup.findViewById(R.id.home_fragment_top_title_ll)

        var homeViewPager = viewGroup.findViewById<ViewPager>(R.id.home_main_ad_vp)
        homeViewPager.adapter = HomeAdPagerAdapter(childFragmentManager)
        var homeViewPagerIndicator = viewGroup.findViewById<CircleIndicator>(R.id.home_main_ad_ci)

        homeViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                homeViewPagerIndicator.selectDot(position)
            }

        })

        homeViewPagerIndicator.createDotPanel(5, R.menu.indicator_dot_off, R.menu.indicator_dot_on, 0)



        val journalLayoutManager : LinearLayoutManager = LinearLayoutManager(context)
        journalLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        val personalLayoutManger : LinearLayoutManager = LinearLayoutManager(context)
        personalLayoutManger.orientation = LinearLayoutManager.HORIZONTAL
        val recommendedLayoutManager : LinearLayoutManager = LinearLayoutManager(context)
        recommendedLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        journalList = getJournals()
        personalizedShow = getPersonals()
        recommendedShow = getRecommended()
        val homeJournalRV = viewGroup.findViewById<RecyclerView>(R.id.home_journal_rv) as RecyclerView
        val listener : ItemClickListener = object : ItemClickListener {
            override fun onItemClicked(vh: RecyclerView.ViewHolder, item: Any, pos: Int) {
                Toast.makeText(context, "Home Fragment", Toast.LENGTH_SHORT).show()
            }
        }
        val journalAdapter = JournalAdapter(journalList!!, context!!, listener )
        homeJournalRV.layoutManager = journalLayoutManager
        homeJournalRV.adapter = journalAdapter

        val homePersonalRV = viewGroup.findViewById<RecyclerView>(R.id.personalizedShowRV)
        val homeRecommendedRV = viewGroup.findViewById<RecyclerView>(R.id.recommendShowRV)

        val mListener : ItemClickListener = object : ItemClickListener {
            override fun onItemClicked(vh: RecyclerView.ViewHolder, item: Any, pos: Int) {

                var show :Show = item as Show
                Log.i("HomeFragment", show.getShowName())

                homeFragmentMainScrollView!!.visibility = View.INVISIBLE
                homeFragmentChildFragment!!.visibility = View.VISIBLE
                homeFragmentTopTitleLinearLayout!!.visibility = View.INVISIBLE

                childFragmentManager.beginTransaction().replace(
                    R.id.home_fragment_child_fragment,
                    ShowDetailFragment("Home", show.getShowName())
                ).commitAllowingStateLoss()

            }
        }

        val personalAdapter = HomeShowAdapter(
            personalizedShow!!,
            context!!,
            mListener
        )
        val recommandedAdapter = HomeShowAdapter(
            recommendedShow!!,
            context!!,
            mListener
        )
        homePersonalRV.layoutManager = personalLayoutManger
        homeRecommendedRV.layoutManager = recommendedLayoutManager
        homePersonalRV.adapter = personalAdapter
        homeRecommendedRV.adapter = recommandedAdapter

        var homeFragmentCategoryButton = viewGroup.findViewById<Button>(R.id.home_fragment_category_bt)
        homeFragmentCategoryButton.setOnClickListener(View.OnClickListener {
            var intent: Intent = Intent(context, CategoryActivity::class.java)
            startActivity(intent)
        })

        return viewGroup
    }

    fun getJournals() : ArrayList<Journal> {
        val journals = java.util.ArrayList<Journal>()
        journals.add(
            Journal(
                "2020\n공연트렌드",
                R.drawable.editors_sample1
            )
        )
        journals.add(
            Journal(
                "디큐브아트센터,\n미로같은 ...",
                R.drawable.family
            )
        )
        journals.add(
            Journal(
                "모든 이야기의\n시작, 오이디...?",
                R.drawable.editors_sample2
            )
        )
        journals.add(
            Journal(
                "세계 4대\n뮤지컬을 알...",
                R.drawable.alone
            )
        )
        journals.add(
            Journal(
                "공연 좀 많이봤니?",
                R.drawable.family
            )
        )
        journals.add(
            Journal(
                "집순이도\n볼 수 있어",
                R.drawable.editors_sample3
            )
        )
        journals.add(
            Journal(
                "해외가면 꼭 봐!",
                R.drawable.editors_sample4
            )
        )
        journals.add(
            Journal(
                "공연 후기 & 꿀팁",
                R.drawable.tip
            )
        )
        return journals
    }
    fun getPersonals() : ArrayList<Show>{
        val shows = ArrayList<Show>()
        shows.add(
            Show(
                R.drawable.poster_sample6,
                "마리퀴리"
            )
        )
        shows.add(
            Show(
                R.drawable.poster_sample5,
                "렌트"
            )
        )
        shows.add(
            Show(
                R.drawable.poster_sample4,
                "레미제라블"
            )
        )
        shows.add(
            Show(
                R.drawable.poster_sample2,
                "라스트 세션"
            )
        )
        shows.add(
            Show(
                R.drawable.poster_sample9,
                "쉬어매드니스"
            )
        )
        shows.add(
            Show(
                R.drawable.poster_sample15,
                "파우스트"
            )
        )
        shows.add(
            Show(
                R.drawable.poster_sample10,
                "썸씽로튼"
            )
        )
        shows.add(
            Show(
                R.drawable.poster_sample12,
                "제이미"
            )
        )
        return shows
    }

    fun getRecommended() : ArrayList<Show>{
        val shows = ArrayList<Show>()
        shows.add(
            Show(
                R.drawable.poster_sample11,
                "오페라의 유령"
            )
        )
        shows.add(
            Show(
                R.drawable.poster_sample14,
                "킹키부츠"
            )
        )
        shows.add(
            Show(
                R.drawable.poster_sample13,
                "캣츠"
            )
        )
        shows.add(
            Show(
                R.drawable.poster_sample12,
                "제이미"
            )
        )
        shows.add(
            Show(
                R.drawable.poster_sample15,
                "파우스트"
            )
        )
        shows.add(
            Show(
                R.drawable.poster_sample16,
                "행오버"
            )
        )
        shows.add(
            Show(
                R.drawable.poster_sample17,
                "라흐마니노프"
            )
        )
        shows.add(
            Show(
                R.drawable.poster_sample8,
                "브로드웨이 42번가"
            )
        )
        return shows
    }

    fun BackToHome(){
        homeFragmentMainScrollView!!.visibility = View.VISIBLE
        homeFragmentChildFragment!!.visibility = View.INVISIBLE
        homeFragmentTopTitleLinearLayout!!.visibility = View.VISIBLE
    }

}