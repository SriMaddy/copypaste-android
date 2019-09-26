package sri.copypaste.repository

import android.util.Log
import com.google.firebase.database.*
import sri.copypaste.model.Clipping
import sri.copypaste.viewmodel.DashboardViewModel

object DashboardRepository {

    private val fireBaseDatabase = FirebaseDatabase.getInstance()
    private val itemsRef = fireBaseDatabase.reference.child("items")
    private var clippings = mutableListOf<Clipping>()

    fun loadAllClippings(viewModel: DashboardViewModel) : List<Clipping> {

        val singleValueEventListener = object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                for (dataSnapShot in p0.children) {
                    val clipping = dataSnapShot.getValue(Clipping::class.java)
//                    Log.i("clipping", clipping.toString())
                    clippings.add(clipping!!)
                }

                viewModel.setClippings(clippings)
            }
        }

        val childEventListener = object : ChildEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {
            }

            override fun onChildRemoved(p0: DataSnapshot) {
            }

            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                Log.i("onChildAdded", p0.key)
                val clipping = p0.getValue(Clipping::class.java)
                Log.i("clipping", clipping?.toString())
                clipping?.let { clippings.add(it) }
            }
        }

        itemsRef.addListenerForSingleValueEvent(singleValueEventListener)
//        itemsRef.addChildEventListener(childEventListener)

        return clippings
    }
}