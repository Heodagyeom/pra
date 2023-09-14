package com.example.andsu2view2

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.andsu2view2.databinding.ItemRecyclearBinding

//class MyAdapter(val mContext: Context, val mItems: MutableList<MyItem>) : BaseAdapter() {
//
//    // MyAdapter 클래스가 관리하는 항목의 총 개수를 반환
//    override fun getCount(): Int {
//        return mItems.size
//    }
//
//    // MyAdapter 클래스가 관리하는 항목의 중에서 position 위치의 항목을 반환
//    override fun getItem(position: Int): Any {
//        return mItems[position]
//    }
//
//    // 항목 id를 항목의 위치로 간주함
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    // position 위치의 항목에 해당되는 항목뷰를 반환하는 것이 목적임
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//
//        var convertView = convertView
//        if (convertView == null) convertView = LayoutInflater.from(parent?.context).inflate(R.layout.item, parent, false)
//
//        val item : MyItem = mItems[position]
//
//        // convertView 변수로 참조되는 항목 뷰 객체내에 포함된 객체를 id를 통해 얻어옴
//        val iconImageView = convertView?.findViewById<View>(R.id.iconItem) as ImageView
//        val tv_name = convertView.findViewById<View>(R.id.textItem1) as TextView
//        val tv_age = convertView.findViewById<View>(R.id.textItem2) as TextView
//
//        // 어댑터가 관리하는 항목 데이터 중에서 position 위치의 항목의 객체를 헤딩 힝목에 설정
//        iconImageView.setImageResource(item.aIcon)
//        tv_name.text = item.aName
//        tv_age.text = item.aAge
//
//        return convertView
//    }
//}


class MyAdapter(val mItems: MutableList<MyItem>, private val context: Context) :
    RecyclerView.Adapter<MyAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Holder { //뷰주머니를 만드는 onCreatViewHolder
//        val binding = ItemRecyclearviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return Holder(binding)
        val binding =
            ItemRecyclearBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) { //바꿔주고 보여주는 형태 위치에 맞는 정보만 보여준다.
        val item = mItems[position]
        Log.d("test", "onbindViewholder:" + position)
        holder.itemView.setOnClickListener {  //클릭이벤트추가부분
            val intent = Intent(context, TestActivity::class.java) //2
            context.startActivity(intent) //2
            itemClick?.onClick(it, position)
            holder.bind(item)
        }
//        holder.iconImageView.setImageResource(mItems[position].aIcon)
//        holder.name.text = mItems[position].aName
//        holder.age.text = mItems[position].aAge
        holder.bind(item) //위치에 맞는 것을 딱 넣어준다. 2
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    //이 밑을 홀더라고 부르셨다._내제클래스 그냥 클래스 로 선언하기
    inner class Holder(val binding: ItemRecyclearBinding) : RecyclerView.ViewHolder(binding.root) {
        val iconImageView = binding.iconItem
        val name = binding.textItem1
        val age = binding.textItem2
        fun bind(item: MyItem) { //2 fun 전부
            with(binding) {
                iconImageView.setImageResource(item.aIcon) // 이렇게 하면 아이템에서 갖고온 사진을 갖고 온다.
                name.text = item.aName // 이름 갖고오는 것 아이템에서 갖고온 이름
                age.text = item.aAge

            }
        }
    }
}


//class MyAdapter(val mItems: MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder>() {
//
//    interface ItemClick {
//        fun onClick(view : View, position : Int)
//    }
//
//    var itemClick : ItemClick? = null
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
//        Log.d("heo", "HowMany") //10개
//        val binding = ItemRecyclearBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return Holder(binding)
//    }
//
//    override fun onBindViewHolder(holder: Holder, position: Int) {
//        Log.d("dada","count") //10개
//        holder.itemView.setOnClickListener {  //클릭이벤트추가부분
//            itemClick?.onClick(it, position)
//        }
//        holder.iconImageView.setImageResource(mItems[position].aIcon)
//        holder.name.text = mItems[position].aName
//        holder.age.text = mItems[position].aAge
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getItemCount(): Int {
//        Log.d("gyeom", "listmany") //12개
//        return mItems.size
//    }
//
//    inner class Holder(val binding: ItemRecyclearBinding) : RecyclerView.ViewHolder(binding.root) {
//        val iconImageView = binding.iconItem
//        val name = binding.textItem1
//        val age = binding.textItem2
//    }
//}