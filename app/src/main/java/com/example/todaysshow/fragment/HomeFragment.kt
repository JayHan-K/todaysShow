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
import com.example.todaysshow.`object`.HomeShow
import com.example.todaysshow.adapter.CommunityPagerAdapter
import com.example.todaysshow.adapter.HomeAdPagerAdapter
import com.example.todaysshow.adapter.HomeShowAdapter
import com.example.todaysshow.adapter.JournalAdapter
import com.example.todaysshow.fragment.search.SearchResultFragment

class HomeFragment : Fragment(){

    var journalList : ArrayList<Journal>? = null
    var personalizedShow : ArrayList<HomeShow>? = null
    var recommendedShow : ArrayList<HomeShow>? = null
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

                var homeShow :HomeShow = item as HomeShow
                Log.i("HomeFragment", homeShow.getShowName())

                homeFragmentMainScrollView!!.visibility = View.INVISIBLE
                homeFragmentChildFragment!!.visibility = View.VISIBLE
                homeFragmentTopTitleLinearLayout!!.visibility = View.INVISIBLE

                childFragmentManager.beginTransaction().replace(
                    R.id.home_fragment_child_fragment,
                    ShowDetailFragment("Home", homeShow.getShowName())
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
                "2020\n공연트렌트",
                R.drawable.empty_circle
            )
        )
        journals.add(
            Journal(
                "샤롯데 씨어\n첫! 방문기",
                R.drawable.empty_circle
            )
        )
        journals.add(
            Journal(
                "나는\n도대체 어디...?",
                R.drawable.empty_circle
            )
        )
        journals.add(
            Journal(
                "4대 뮤지컬\n오페라의 유령",
                R.drawable.empty_circle
            )
        )
        journals.add(
            Journal(
                "2020\n공연트렌트",
                R.drawable.empty_circle
            )
        )
        journals.add(
            Journal(
                "샤롯데 씨어\n첫! 방문기",
                R.drawable.empty_circle
            )
        )
        journals.add(
            Journal(
                "나는\n도대체 어디...?",
                R.drawable.empty_circle
            )
        )
        journals.add(
            Journal(
                "4대 뮤지컬\n오페라의 유령",
                R.drawable.empty_circle
            )
        )
        return journals
    }
    fun getPersonals() : ArrayList<HomeShow>{
        val shows = ArrayList<HomeShow>()
        shows.add(
            HomeShow(
                R.drawable.show_sample1,
                "Show1"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample2,
                "Show2"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample1,
                "Show3"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample2,
                "Show4"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample1,
                "Show5"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample2,
                "Show6"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample1,
                "Show7"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample2,
                "Show8"
            )
        )
        return shows
    }

    fun getRecommended() : ArrayList<HomeShow>{
        val shows = ArrayList<HomeShow>()
        shows.add(
            HomeShow(
                R.drawable.show_sample2,
                "RShow1"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample1,
                "RShow2"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample2,
                "RShow3"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample1,
                "RShow4"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample2,
                "RShow5"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample1,
                "RShow6"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample2,
                "RShow7"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample1,
                "RShow8"
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