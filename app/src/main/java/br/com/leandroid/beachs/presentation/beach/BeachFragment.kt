package br.com.leandroid.beachs.presentation.beach

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.leandroid.beach.R
import br.com.leandroid.beach.databinding.BeachFragmentBinding
import br.com.leandroid.core.BindingFragment
import br.com.leandroid.core.observeResource
import org.koin.androidx.viewmodel.ext.android.viewModel

class BeachFragment : BindingFragment<BeachFragmentBinding>() {

    private val beachAdapter by lazy {
        BeachAdapter {
            //startDetailBeachActivity(it)
        }
    }

    private val viewModel by viewModel<BeachViewModel>()

    override fun getLayoutId(): Int = R.layout.beach_fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()

        setupRecyclerView()
        setupObserver()
        callBeach()
    }

    private fun callBeach() {
        viewModel.getBeachs()
    }

    private fun setupObserver() {
        viewModel.beachs.observeResource(this,
            onSuccess = {
                if (it.isNotEmpty()) {
                    beachAdapter.submitList(it)
                }
            }, onError = {

            }, onLoading = {

            }
        )
    }

    private fun setupRecyclerView() {
        binding.beachRecyclerview.apply {
            adapter = beachAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}