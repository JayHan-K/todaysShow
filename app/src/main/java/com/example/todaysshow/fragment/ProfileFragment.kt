package com.example.todaysshow.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.ItemClickListener
import com.example.todaysshow.R
import com.example.todaysshow.`object`.Show
import com.example.todaysshow.adapter.HomeShowAdapter
import com.example.todaysshow.adapter.RealReviewSearchSuggestionAdapter

class  ProfileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewGroup:ViewGroup = inflater.inflate(R.layout.activity_profile_fragment, null) as ViewGroup

        var profileMyShowRecyclerView : RecyclerView = viewGroup.findViewById(R.id.profile_my_show_rv)
        val layoutManager : LinearLayoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        profileMyShowRecyclerView.layoutManager = layoutManager
        val listener : ItemClickListener = object : ItemClickListener {
            override fun onItemClicked(vh: RecyclerView.ViewHolder, item: Any, pos: Int) {
                //
            }

            override fun onItemClicked(
                v: RealReviewSearchSuggestionAdapter.ViewHolder,
                item: Any,
                pos: Int
            ) {

            }
        }
        profileMyShowRecyclerView.adapter = HomeShowAdapter(getShow(),context!!, listener)

        return viewGroup
    }

    fun getShow() : ArrayList<Show>{
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
}
