package com.example.e_commerce_application.ui.fragments.favorite

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_commerce_application.R
import com.example.e_commerce_application.data.adapter.FavoritesAdapter
import com.example.e_commerce_application.databinding.FragmentFavoriteBinding
import com.example.e_commerce_application.viewmodel.FavoritesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {
    private var _binding: FragmentFavoriteBinding? = null

    private val binding get() = _binding!!

    private lateinit var favadapter:FavoritesAdapter

    private lateinit var favoritesViewModel:FavoritesViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        val view = binding.root

        return view

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        favoritesViewModel= ViewModelProvider(this)[FavoritesViewModel::class.java]
        favadapter=FavoritesAdapter(favoritesViewModel)

        // setting up recyclerview
        setupRv()

        // observe live data and update ui
        observeFavoriteLiveData()


        // set menu
        setHasOptionsMenu(true)

        super.onViewCreated(view, savedInstanceState)
    }
    private fun observeFavoriteLiveData() {
        favoritesViewModel.getAllFavorites.observe(viewLifecycleOwner, Observer {
            favadapter.setData(it)
        })
    }

    private fun setupRv() {
        binding.favRv.layoutManager=LinearLayoutManager(requireContext())
        binding.favRv.adapter=favadapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.favoritesmenu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.FavdeleteAll){

            val builder = AlertDialog.Builder(requireContext())

// Set the alert dialog title and message
            builder.setTitle("Delete All Favorite Products")
            builder.setMessage("Are you sure you want to delete all favorite products?")

// Add the buttons
            builder.setPositiveButton("Yes") { dialog, which ->
                favoritesViewModel.deletAllFavorites()
                findNavController().navigate(R.id.action_favoriteFragment_to_listFragment)
            }
            builder.setNegativeButton("No") { dialog, which ->
                dialog.dismiss()
            }

// Create and show the dialog
            val dialog = builder.create()
            dialog.show()


        }
        return super.onOptionsItemSelected(item)
    }

}