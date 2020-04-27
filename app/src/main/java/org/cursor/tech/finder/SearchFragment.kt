package org.cursor.tech.finder

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class SearchFragment : Fragment() {
    private lateinit var viewModel: SearchViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ApplicationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_search, container, false)
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        recyclerView = view.findViewById<RecyclerView>(R.id.application_recycler_view)
        adapter = ApplicationAdapter(activity!!)
        recyclerView.layoutManager = GridLayoutManager(activity?.applicationContext,2)
        recyclerView.adapter = adapter

        viewModel.installedApps.observe(viewLifecycleOwner, Observer {
            adapter.setApplications(it)
        })


        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        val inflater = activity?.menuInflater
        inflater?.inflate(R.menu.search_item,menu)

        val menuItem = menu.findItem(R.id.search)
        val searchView = menuItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                if (!newText.isNullOrEmpty()){
                    viewModel.search(newText!!)
                }

                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
        })

    }

}
