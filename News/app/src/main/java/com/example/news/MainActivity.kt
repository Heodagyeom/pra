package com.example.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.news.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

//    private lateinit var binding: MainActivityBinding
    private val binding by lazy {MainActivityBinding.inflate(layoutInflater) } // 10줄과 15줄을 합친형태같다. 그리고 늦게 초기화를 한다는 내용

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList = mutableListOf<NewsItem>() // 이미지 String() 하니깐 오류방생 Int 변경
        dataList.add(NewsItem(R.drawable.img01, "후쿠시마 오염수 홍보물? KTX 말고 신칸센에 하라 철도노조 발끈", "앞서 문화체육관광부는 지난 1일 KTX와 SRT 열차 좌석에 '후쿠시마 오염수 10가지 괴담'이라는 제목의 책자 총 7만5천여부를 비치했다.\n KTX에는 약 6만부, SRT에는 약 1만5000부가 각각 배포됐다."))
        dataList.add(NewsItem(R.drawable.img02, "팀과제와 개인과제 같이는", "왜이렇게 어렵운지 수강생 울고 있는 중입니다. 이해했던거라 생각했는데도 숙제를 자료보고 찾아서 해보는데도 오류가 연달아서 나오고"))
        dataList.add(NewsItem(R.drawable.img03, "저에게 무리인가봅니다.", "많이 힘드네요 하핫;;; 그래서 후발대도 최대한 열심히 듣고 따라해보고 직접 찾아보면서 공부를 하고 있는데 못 따라가고 있는걸 확실히 체감합니다."))
        dataList.add(NewsItem(R.drawable.img04, "그래서 혼자 결정을", "정예반 수업을 도강 하고 있습니다. 하핫;;; 나름 따라가는 방법을 찾아본거랍니다. 기초는 확실히 필요하다고 느"))
        dataList.add(NewsItem(R.drawable.img05, "나름 내려서 도강을", "정예반 수업을 도강 하고 있습니다. 하핫;;; 나름 따라가는 방법을 찾아본거랍니다. 기초는 확실히 필요하다고 껴"))
        dataList.add(NewsItem(R.drawable.img06, "했습니다. ", "정예반 수업을 도강 하고 있습니다. 하핫;;; 나름 따라가는 방법을 찾아본거랍니다. 기초는 확실히 필요하다고  서"))
        dataList.add(NewsItem(R.drawable.img07, "개발자 직종은 공유가", "정예반 수업을 도강 하고 있습니다. 하핫;;; 나름 따라가는 방법을 찾아본거랍니다. 기초는 확실히 필요하다고 살"))
        dataList.add(NewsItem(R.drawable.img08, "많다고 했으니깐 ", "정예반 수업을 도강 하고 있습니다. 하핫;;; 나름 따라가는 방법을 찾아본거랍니다. 기초는 확실히 필요하다고    아"))
        dataList.add(NewsItem(R.drawable.img09, "자기합리화를 하면서", "정예반 수업을 도강 하고 있습니다. 하핫;;; 나름 따라가는 방법을 찾아본거랍니다. 기초는 확실히 필요하다고  남"))
        dataList.add(NewsItem(R.drawable.img10, "당당하게 저는...", "정예반 수업을 도강 하고 있습니다. 하핫;;; 나름 따라가는 방법을 찾아본거랍니다. 기초는 확실히 필요하다고    기"))
        dataList.add(NewsItem(R.drawable.img11, "도강하고 숙제합니다.", "정예반 수업을 도강 하고 있습니다. 하핫;;; 나름 따라가는 방법을 찾아본거랍니다. 기초는 확실히 필요하다고"))

//        binding.run {
//            val articleDetail = "기사의 세부 내용"
//            val detailFragment = DetailFragment()
//            val bundle = Bundle()
//            bundle.putString("articleDetail", articleDetail)
//            detailFragment.arguments = bundle
//            } // 프래그먼트에서 프래그먼트로 데이터 전달시 필요한 작성법


        val fragment = TitleFragment()
        val bundle = Bundle()
        bundle.putString("key", mutableListOf<NewsItem>().toString() ) // "key"는 데이터를 식별하는 키입니다.
        fragment.arguments = bundle // 이부분이 번들인 장바구니 같은 것에 담는 것

//// 프래그먼트를 화면에 추가 또는 교체
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_container, fragment)
//            .commit() // 이부분이 왜 필요할까? 일단 GPT가 알려주긴 했는데...

        binding.apply{
            btnMainFrag1.setOnClickListener{
                setFragment(TitleFragment())
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .commit()
            }
            btnMainFrag2.setOnClickListener{
                setFragment(DetailFragment())
            } // 버튼없이 슬라이스로 넘기는 방법... pageview 코끼리, 실제에서는 버튼이 곧 한국경제, 동아일보 느낌이겠거니..
        }
        setFragment(TitleFragment()) // 앱을 실행했을 때 첫 화면으로 먼저 출력되게 되는 부분.

    }

    private fun setFragment(frog : Fragment) { // 설명 다시 듣자. 반복이라서 따로 fun으로 설정. 일단 프래그먼트 불러오는 법임.
        supportFragmentManager.commit{// 이 매니저를 사용할려면 코끼리에서 implementation("androidx.fragment:fragment-ktx: 라는 부분 추가
            replace(R.id.frameLayout, frog)
            setReorderingAllowed(true)
            addToBackStack("")


        }
    }
}

