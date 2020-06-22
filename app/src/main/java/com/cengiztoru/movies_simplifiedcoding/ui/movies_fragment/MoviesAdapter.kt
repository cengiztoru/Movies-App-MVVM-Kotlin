package com.cengiztoru.movies_simplifiedcoding.ui.movies_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cengiztoru.movies_simplifiedcoding.R
import com.cengiztoru.movies_simplifiedcoding.data.models.Movie
import com.cengiztoru.movies_simplifiedcoding.databinding.RecyclerviewMovieBinding


/**     Code With 💗
 * Created by Cengiz TORU
 * cengiztoru@gmail.com
 */

class MoviesAdapter(private val movies: List<Movie>, private val listener: IMoviesClickListener) :
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MoviesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_movie,
                parent,
                false
            )
        )

    //Bind data to ViewHolder
    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.mBinding.movie = movies[position]

//        holder.mBinding.root.setOnClickListener {}

        holder.mBinding.buttonBook.setOnClickListener {
            listener.itemClicked(holder.mBinding.buttonBook, movies[position])
        }
        holder.mBinding.layoutLike.setOnClickListener {
            listener.itemClicked(holder.mBinding.layoutLike, movies[position])
        }
    }

    override fun getItemCount() = movies.size

    inner class MoviesViewHolder(
        val mBinding: RecyclerviewMovieBinding
    ) : RecyclerView.ViewHolder(mBinding.root)


}