package br.com.leandroid.beachs.presentation.beach

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.leandroid.beach.R
import br.com.leandroid.beach.databinding.BeachActivityBinding
import br.com.leandroid.core.BindingActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import br.com.leandroid.core.observeResource

class BeachActivity : BindingActivity<BeachActivityBinding>() {

    private val beachAdapter by lazy {
        BeachAdapter {
            //startDetailBeachActivity(it)
        }
    }

    private val viewModel by viewModel<BeachViewModel>()

    override fun getLayoutId(): Int = R.layout.beach_activity

    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
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