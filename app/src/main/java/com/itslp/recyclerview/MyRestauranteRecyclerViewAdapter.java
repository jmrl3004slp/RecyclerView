package com.itslp.recyclerview;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.itslp.recyclerview.RestauranteFragment.OnListFragmentInteractionListener;

import java.util.List;
import com.squareup.picasso.*;
/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyRestauranteRecyclerViewAdapter extends RecyclerView.Adapter<MyRestauranteRecyclerViewAdapter.ViewHolder> {

    private final List<Restaurante> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyRestauranteRecyclerViewAdapter(List<Restaurante> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_restaurante, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.textViewNombre.setText(holder.mItem.getNombre());
        holder.textViewDireccion.setText(holder.mItem.getDireccion());
        holder.ratingBarValoracion.setRating(holder.mItem.getValoracion());

        Picasso.get().load(holder.mItem.getUrlFoto()).resize(400, 150).centerCrop().into(holder.imageViewFoto);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewNombre;
        public final TextView textViewDireccion;
        public final ImageView imageViewFoto;
        public final RatingBar ratingBarValoracion;
        public Restaurante mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;

            this.textViewNombre = (TextView) view.findViewById(R.id.txNombre);
            this.textViewDireccion = (TextView) view.findViewById(R.id.tvDireccion);
            this.ratingBarValoracion = (RatingBar) view.findViewById(R.id.ratingBarValoracion);
            this.imageViewFoto = (ImageView) view.findViewById(R.id.imageViewFoto);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + "'";
        }
    }
}
