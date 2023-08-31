package com.example.applemarket

import android.content.ClipData.Item
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.applemarket.databinding.ItemRecyclearBinding

//class ItemAdapter() : RecyclerView.Adapter<ItemAdapter.Holder>() {
//
//    interface ItemClick {
//        fun onClick(view: View, position: Int)
//    } // 이부분들이 onBindViewHolder 을 위해 적기는 했는데.. 무슨일 하는지 모르겠다.
//
//    val mItems = mutableListOf<DummyItem>() // 이공간이 비어있게끔 설정이 되어있어서 계속 흰 화면이 떴다.
//
//    var itemClick: ItemClick? = null
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
//        Log.d("heo", "레이아웃이 몇개나 될까") // 이것도 안됨.
//        val view = ItemRecyclearBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return Holder(view)
//    } // 한 화면에 그려지는 아이템 개수만큼 레이아웃 생성.
//
//    override fun getItemCount(): Int {
//        Log.d("dada", "list view") // 2번 실행은 되긴한다.
//        return mItems.size // var listData 변수선언을 하여 무엇인지 알려주고 size를 적어야 한다.
//    } // 목록에 보여줄 아이템 갯수
//
//    override fun onBindViewHolder(holder: Holder, position: Int) {
//        Log.d("gyeom", "view") // 아예보이지 않음.
//        holder.itemView.setOnClickListener {
//            itemClick?.onClick(it, position)
//        }
//        holder.itemImage.setImageResource(mItems[position].Image)
//        holder.itemTitle.text = mItems[position].ItemTitle
//        holder.itemAdress.text = mItems[position].Address
//        holder.itemPrice.inputType = mItems[position].Price
//
//
//    } // 생성된 아이템 레이아웃에 값 입력 후 목록에 출력
//
//    inner class Holder(val binding: ItemRecyclearBinding) : RecyclerView.ViewHolder(binding.root) {
//        val itemImage = binding.itemIvIconItem
//        val itemTitle = binding.itemTvTitle
//        val itemAdress = binding.itemTvAddress
//        val itemPrice = binding.itemTvPrice
//
//    }
//} //18번째줄이 빈공간을 주어서 계속 빈화면 + 레이아웃에서만 임시로 합쳐진상태를 봤는데. 내가 레이아웃을 높이조절을 화면 전체로 해서 하나만 보였었다.

//class Holder(val binding : ItemRecyclearBinding) : RecyclerView.ViewHolder(binding.root){
//    val itemImage = binding.itemIvIconItem
//    val itemTitle = binding.itemTvTitle
//    val itemAdress = binding.itemTvAddress
//    val itemPrice = binding.itemTvPrice
//
//} // 밖이 아니라 class 안에 inner 은 내부클래스
// 홀더 먼저 만들고 클래스에서 첫번째꺼.. 추가하는 기능 하니깐 자동으로 추상화이 todo로 들어 왔다. 강의실습으로 황성희튜터님에게 설명듣고 adapter 만들어봄.

class ItemAdapter(private val context : Context) : RecyclerView.Adapter<ItemAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var mItems = mutableListOf<DummyItem>()

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        Log.d("heo", "레이아웃이 몇개나 될까") // 이것도 안됨.
        val view = ItemRecyclearBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(view)
    } // 한 화면에 그려지는 아이템 개수만큼 레이아웃 생성.

    override fun getItemCount(): Int {
        Log.d("dada", "list view") // 2번 실행은 되긴한다.
        return mItems.size // var listData 변수선언을 하여 무엇인지 알려주고 size를 적어야 한다.
    } // 목록에 보여줄 아이템 갯수

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Log.d("gyeom", "view") // 아예보이지 않음.

        holder.itemImage.setImageResource(mItems[position].Image)
        holder.itemTitle.text = mItems[position].ItemTitle
        holder.itemAdress.text = mItems[position].Address
//        holder.itemPrice.text = mItems[position].Price  // 이부분을 빼면 같은 정보만 리스트된다.
        holder.itemPrice.text = mItems[position].Price.toString()+"원" //메인화면에는 성공 천자리 , 아직.
        holder.itemView.setOnClickListener {
           itemClick?.onClick(it, position) // 이동이 되지 않는다.
//            val intent = Intent(context, DetailActivity::class.java)
//            context.startActivity(intent) //고정값으로 지정이 된다. 디테일 페이지가 나온다.
//            val intent = Intent(context, DetailActivity::class.java)
//            context.startActivity(intent)

        }

    }

    inner class Holder(binding: ItemRecyclearBinding) : RecyclerView.ViewHolder(binding.root) {
        val itemImage = binding.itemIvIconItem
        val itemTitle = binding.itemTvTitle
        val itemAdress = binding.itemTvAddress
        val itemPrice = binding.itemTvPrice

    }

    fun setItems (list : MutableList<DummyItem>){
        mItems.addAll(list) // 리스트에 넣는 방법. main에서 기존 data 추가한 것 54번째줄도 작성해줘야 한다.
        notifyDataSetChanged() // 변화감지 새로고침
    }

    fun findPosition (){

    }
} //이동준튜터님과 리스트를 추가하는 방식을 넣었다. setItems 를 추가하고 안에 작석하고 처음에 adapter에 파라미터 넣었던 부분을 삭제하고 밑에서 리스트 추가하는 메소드 추가.