package me.ruyeo.pageranimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.dingmouren.layoutmanagergroup.skidright.SkidRightLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var rightLayoutManager : SkidRightLayoutManager
    private val adapter by lazy { PagerAdapter() }
    private var pagerList: ArrayList<Pager> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
    }

    private fun setupUI() {
        recyclerView = findViewById(R.id.recycler_view)
        rightLayoutManager = SkidRightLayoutManager(1.5f,0.85f)
        recyclerView.layoutManager = rightLayoutManager
        setData()
        adapter.submitData(pagerList)
        recyclerView.adapter = adapter
    }

    private fun setData() {
        for (i in 0..10){
            pagerList.add(Pager(R.drawable.ic_launcher_background,"Something"))
        }
    }
}