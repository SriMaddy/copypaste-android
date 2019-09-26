package sri.copypaste.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import sri.copypaste.model.Clipping
import sri.copypaste.repository.DashboardRepository

class DashboardViewModel : ViewModel() {

    var clippings: MutableLiveData<List<Clipping>> = MutableLiveData(mutableListOf())

    fun loadAllClippings() : MutableLiveData<List<Clipping>> {
        return MutableLiveData(DashboardRepository.loadAllClippings(this))
    }

    fun setClippings(clippings: MutableList<Clipping>) {
        this.clippings.value = clippings
    }
}