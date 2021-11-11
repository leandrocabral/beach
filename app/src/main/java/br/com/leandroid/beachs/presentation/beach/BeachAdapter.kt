package br.com.leandroid.beachs.presentation.beach

import br.com.leandroid.beach.R
import br.com.leandroid.beach.databinding.ItemBeachBinding
import br.com.leandroid.core.BindingAdapter
import br.com.leandroid.domain.model.BeachDomain

class BeachAdapter (private val onClick: (BeachDomain) -> Unit) :
    BindingAdapter<BeachDomain, ItemBeachBinding>() {

    override fun getLayoutId(): Int = R.layout.item_beach

    override fun onBindViewHolder(binding: ItemBeachBinding, position: Int) {
        binding.run {
            item = getItem(position)
        }
    }
}
