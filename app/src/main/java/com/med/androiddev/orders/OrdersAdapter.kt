package com.med.androiddev.orders

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.med.androiddev.R
import com.med.domain.orders.model.Order
import java.text.SimpleDateFormat


class OrdersAdapter(private val context: Context, private val orders: List<Order>) :
    RecyclerView.Adapter<OrdersAdapter.OrdersViewHolder>() {


    class OrdersViewHolder(view: View, context: Context) : RecyclerView.ViewHolder(view) {

        val dateText: TextView = view.findViewById(R.id.dateText)
        val monthText: TextView = view.findViewById(R.id.monthText)
        val marketNameText: TextView = view.findViewById(R.id.marketNameText)
        val orderNameText: TextView = view.findViewById(R.id.orderNameText)
        val productStateText: TextView = view.findViewById(R.id.productStateText)
        val productPriceText: TextView = view.findViewById(R.id.productPriceText)
        val orderDetail: TextView = view.findViewById(R.id.orderDetail)
        val summaryPrice: TextView = view.findViewById(R.id.summaryPrice)
        val productStateIcon: ImageView = view.findViewById(R.id.productStateIcon)
        val productDetail: ConstraintLayout = view.findViewById(R.id.productDetail)

        // Siparis detayinin goruntulenme durumunu tutan degiskene renkleri atama.

        init {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                colorMap["Yolda"] = context.getColor(R.color.siparisYolda)
                colorMap["Onay Bekliyor"] = context.getColor(R.color.siparisOnayBeyliyor)
                colorMap["Hazırlanıyor"] = context.getColor(R.color.siparisHazirlaniyor)
            } else {
                colorMap["Yolda"] = context.resources.getColor(R.color.siparisYolda)
                colorMap["Onay Bekliyor"] = context.resources.getColor(R.color.siparisOnayBeyliyor)
                colorMap["Hazırlanıyor"] = context.resources.getColor(R.color.siparisHazirlaniyor)
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersViewHolder {
        return OrdersViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_order_list, parent, false), context
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: OrdersViewHolder, position: Int) {

        // Siparis detayinin goruntulenme durumunu varsayılan olarak false atar.

        if (expandMap[position] == null) expandMap[position] = false

        // Siparis öğesine tıklanma durumunda tetiklenir.

        holder.itemView.setOnClickListener {

            // Siparis detayinin goruntulenme durumunu tersine cevirir.

            expandMap[position]?.let { em ->
                expandMap[position] = !em
                holder.productDetail.visibility = if (!em) View.VISIBLE else View.GONE
            }
        }

        // Siparis öğesinin bilgileri doldurulur.

        val order = orders[position]

        order.let {
            holder.dateText.text = it.date
            holder.monthText.text = toMonthString(it.month.toString())
            holder.marketNameText.text = "${it.marketName}"
            holder.orderNameText.text = "${it.orderName}"
            holder.productStateText.text = it.productState
            holder.productPriceText.text = "${it.productPrice}₺"

            it.productDetail?.let { pd ->
                holder.orderDetail.text = "${pd.orderDetail}"
                holder.summaryPrice.text = "${pd.summaryPrice}₺"
            }

            it.productState.let { ps ->
                colorMap[ps]?.let { it1 -> holder.productStateIcon.setColorFilter(it1) }
                colorMap[ps]?.let { it1 -> holder.productStateText.setTextColor(it1) }
            }

            holder.productDetail.visibility = if (expandMap[position]!!) View.VISIBLE else View.GONE

        }

    }

    // Ay isimlerini geri dondurur.

    @SuppressLint("SimpleDateFormat")
    fun toMonthString(date: String): String {
        val parser = SimpleDateFormat("MM")
        val formatter = SimpleDateFormat("MMMM")
        return formatter.format(parser.parse(date)!!)
    }

    override fun getItemCount(): Int = orders.size

    companion object {

        // Siparis durumunun renklerini tutan degisken.

        private val colorMap = HashMap<String, Int>()

        // Siparis detayinin goruntulenme durumunu tutan degisken.

        private val expandMap = HashMap<Int, Boolean>()
    }
}