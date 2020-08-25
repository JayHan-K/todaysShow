package com.example.todaysshow.fragment.community;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaysshow.R;
import com.example.todaysshow.adapter.CommunityQnAAdapter;

import java.util.ArrayList;
import java.util.List;

public class CommunityQNA extends Fragment {
    public CommunityQNA() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.activity_community_qna_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.qna_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));
        List<CommunityQnAAdapter.Item> data = new ArrayList<>();

        data.add(new CommunityQnAAdapter.Item(CommunityQnAAdapter.QUESTION,"공연 병아리 입니다. 공연 추천 부탁드려요", "2020.07.09","공연 추천","관리자님 도와줘요","마스터",5,47));
        data.add(new CommunityQnAAdapter.Item(CommunityQnAAdapter.ANSWER,"뮤지컬을 선호하신다면 ~~~을 추천드리고, 연극을 보고싶으시다면, ~~~~~을 추천드립니다! 이외에 장르별로도 다양하게 있어서 참고해 공연을 선택해주시면....","2020.07.09"));

        data.add(new CommunityQnAAdapter.Item(CommunityQnAAdapter.QUESTION,"디큐브에서 길을 잃었어요ㅠㅠ 도와주세요ㅜ", "2020.07.09","공연 추천","관리자님 도와줘요","마스터",5,47));
        data.add(new CommunityQnAAdapter.Item(CommunityQnAAdapter.ANSWER,"2뮤지컬을 선호하신다면 ~~~을 추천드리고, 연극을 보고싶으시다면, ~~~~~을 추천드립니다! 이외에 장르별로도 다양하게 있어서 참고해 공연을 선택해주시면....","2020.07.09"));

        data.add(new CommunityQnAAdapter.Item(CommunityQnAAdapter.QUESTION,"세종문화회관 근처 맛집 있을까요?", "2020.07.09","공연 추천","관리자님 도와줘요","마스터",5,47));
        data.add(new CommunityQnAAdapter.Item(CommunityQnAAdapter.ANSWER,"3뮤지컬을 선호하신다면 ~~~을 추천드리고, 연극을 보고싶으시다면, ~~~~~을 추천드립니다! 이외에 장르별로도 다양하게 있어서 참고해 공연을 선택해주시면....","2020.07.09"));

        data.add(new CommunityQnAAdapter.Item(CommunityQnAAdapter.QUESTION,"요번달 할인 되는 공연이 있나요?", "2020.07.09","공연 추천","관리자님 도와줘요","마스터",5,47));
        data.add(new CommunityQnAAdapter.Item(CommunityQnAAdapter.ANSWER,"4뮤지컬을 선호하신다면 ~~~을 추천드리고, 연극을 보고싶으시다면, ~~~~~을 추천드립니다! 이외에 장르별로도 다양하게 있어서 참고해 공연을 선택해주시면....","2020.07.09"));

        data.add(new CommunityQnAAdapter.Item(CommunityQnAAdapter.QUESTION,"공연 예매취소 하고 싶은데 어떻게 해야하나요ㅠㅠ?", "2020.07.09","공연 추천","관리자님 도와줘요","마스터",5,47));
        data.add(new CommunityQnAAdapter.Item(CommunityQnAAdapter.ANSWER,"5뮤지컬을 선호하신다면 ~~~을 추천드리고, 연극을 보고싶으시다면, ~~~~~을 추천드립니다! 이외에 장르별로도 다양하게 있어서 참고해 공연을 선택해주시면....","2020.07.09"));

        data.add(new CommunityQnAAdapter.Item(CommunityQnAAdapter.QUESTION,"남자친구랑 같이 보면 좋을것 같은 공연 추천해주세요!!", "2020.07.09","공연 추천","관리자님 도와줘요","마스터",5,47));
        data.add(new CommunityQnAAdapter.Item(CommunityQnAAdapter.ANSWER,"6뮤지컬을 선호하신다면 ~~~을 추천드리고, 연극을 보고싶으시다면, ~~~~~을 추천드립니다! 이외에 장르별로도 다양하게 있어서 참고해 공연을 선택해주시면....","2020.07.09"));

        data.add(new CommunityQnAAdapter.Item(CommunityQnAAdapter.QUESTION,"디큐브 근처 괜찮은 카페 추천해주세요~~", "2020.07.09","공연 추천","관리자님 도와줘요","마스터",5,47));
        data.add(new CommunityQnAAdapter.Item(CommunityQnAAdapter.ANSWER,"7뮤지컬을 선호하신다면 ~~~을 추천드리고, 연극을 보고싶으시다면, ~~~~~을 추천드립니다! 이외에 장르별로도 다양하게 있어서 참고해 공연을 선택해주시면....","2020.07.09"));
        recyclerView.setAdapter(new CommunityQnAAdapter(data));
        return rootView;

    }

}