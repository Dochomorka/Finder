package org.cursor.tech.finder

import android.app.Application
import android.content.pm.PackageManager
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.cursor.tech.finder.data.FinderApp

class SearchViewModel(application: Application): AndroidViewModel(application) {
    val app = application
    val TAG = SearchViewModel::class.simpleName

    private var _installedApps =  MutableLiveData<MutableList<FinderApp>>()
    val installedApps: LiveData<MutableList<FinderApp>> = _installedApps


    fun search(query: String) = viewModelScope.launch (Dispatchers.IO){
        val finderApps = mutableListOf<FinderApp>()
        val installed = app.packageManager.getInstalledApplications(PackageManager.MATCH_SYSTEM_ONLY)
        if (installed.isNotEmpty()){
            for( i in installed){
                val name = app.packageManager.getApplicationLabel(i)
                val icon = app.packageManager.getApplicationIcon(i.packageName)
                val finderApp = FinderApp(label = name.toString(),drawable = icon)
                finderApps.add(finderApp)
            }
            _installedApps.postValue(finderApps)
        }

    }
}