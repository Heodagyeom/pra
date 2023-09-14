package com.example.pralifecycle

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
val Tag = "DaGyeom"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(Tag,"Frg onCreate 실행") //프래그먼트 누르니 실행1~1-4 까지 자동실행 메인변화 x
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(Tag,"Frg onCreateView 실행됨.") //실행1-2
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

//    override fun onViewCreated(){
//        super.onViewCreated()
//        Log.d(Tag,"Frg onViewCreated 왜 넌 파라미너가 있는거니?") //뭔가 프래그먼트에서 구현하는 부분이 있어야 할 것 같다. 함수선언도 못함.
//    }
//
//    override fun onViewRestored(){
//        super.onViewCreated()
//        Log.d(Tag, "Frg on ")
//    }

    override fun onStart(){
        super.onStart()
        Log.d(Tag, "Frg onstart 실행됨.") //실행1-3
    }
    override fun onResume(){
        super.onResume()
        Log.d(Tag, "Frg onResume ") //실행1-4
    }

    override fun onPause(){
        super.onPause()
        Log.d(Tag, "Frg onPause ") //뒤로가기 누른뒤 2-1~2-3 까지 실행
    }

    override fun onStop(){
        super.onStop()
        Log.d(Tag, "Frg onstop") //실행2-2
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(Tag, "Frg onDestory") //실행2-3 끝 메인 여전히 변화없음.
    }

}
