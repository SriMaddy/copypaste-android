package sri.copypaste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sri.copypaste.model.Clipping
import sri.copypaste.ui.adapter.ClipRecyclerViewAdapter
import sri.copypaste.viewmodel.DashboardViewModel

class MainActivity : AppCompatActivity() {

    lateinit var dashboardViewModel: DashboardViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ClipRecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()

        dashboardViewModel = ViewModelProviders.of(this)[DashboardViewModel::class.java]
        dashboardViewModel.loadAllClippings()
        dashboardViewModel.clippings.observe(this, Observer {
            setRecyclerView(it)
        })
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)
    }

    private fun setRecyclerView(it: List<Clipping>?) {
//        it?.forEach {
//            Log.i("clipping", it.toString())
//        }
//        println("clippingsSize=> ${it?.size}")

        adapter = ClipRecyclerViewAdapter(this.applicationContext, it!!)
        recyclerView.adapter = adapter
    }
}
