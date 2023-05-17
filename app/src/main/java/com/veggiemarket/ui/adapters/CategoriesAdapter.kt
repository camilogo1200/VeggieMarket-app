package com.veggiemarket.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.veggiemarket.R
import com.veggiemarket.databinding.CategoriesLayoutBinding
import com.veggiemarket.domain.models.Category

data class CategoriesAdapter(
    val items: List<Category>
) : RecyclerView.Adapter<CategoriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<CategoriesLayoutBinding>(
            inflater,
            R.layout.categories_layout,
            parent,
            false
        )
        return CategoriesViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bindItem(items[position])
    }
}


data class CategoriesViewHolder(val binding: CategoriesLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindItem(category: Category) {
        binding.categoryText.text = category.name
        val resource = bindImage(category.name)

        Picasso.get().load(resource).into(binding.image);
    }

    private fun bindImage(name: String): Int {
        return when (name) {
            "Vegetables" -> R.drawable.carrot
            "Fruits" -> R.drawable.ic_fruits_category
            "Fish" -> R.drawable.ic_fish_category
            "Milk" -> R.drawable.ic_milk_category
            "Eggs" -> R.drawable.ic_eggs_category
            "Meats" -> R.drawable.ic_meats_category
            else -> R.drawable.carrot
        }
    }

}

