package com.souptik.maiti.souptikappinesstask.ui.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.souptik.maiti.souptikappinesstask.R
import com.souptik.maiti.souptikappinesstask.di.components.FragmentComponent
import com.souptik.maiti.souptikappinesstask.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : BaseFragment<HomeViewModel>() {

    companion object {
        const val TAG = "HomeFragment"

        fun newInstance(): HomeFragment {
            val args = Bundle()
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var itemAdapter: ItemAdapter

    override fun provideLayoutId(): Int = R.layout.fragment_home

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun setupView(view: View) {
        //setMenuVisibility(true)
        setHasOptionsMenu(true)
        rv_items.layoutManager = linearLayoutManager
        rv_items.adapter = itemAdapter

    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.itemList.observe(this, Observer { list->
            if(list!= null){
                var sortedList = list.sortedBy { it.title.toLowerCase() }
                itemAdapter.appendData(sortedList)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.appiness_menu, menu)
        var searchItem = menu.findItem(R.id.search_menu)
        var searchView = searchItem.actionView as SearchView
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                itemAdapter.getFilter().filter(newText)
                itemAdapter.notifyDataSetChanged()
                return false
            }
        })
    }
}
