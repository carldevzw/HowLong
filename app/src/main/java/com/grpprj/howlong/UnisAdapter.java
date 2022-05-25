package com.grpprj.howlong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UnisAdapter extends RecyclerView.Adapter<UnisAdapter.Viewholder> {

    private OnUnisListener mOnUnisListener;
    private Context context;
    private ArrayList<UnisModel> courseModelArrayList;

    // Constructor
    public UnisAdapter(Context context, ArrayList<UnisModel> courseModelArrayList, OnUnisListener onUnisListener) {
        this.context = context;
        this.courseModelArrayList = courseModelArrayList;
        this.mOnUnisListener= onUnisListener;
    }

    @NonNull
    @Override
    public UnisAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.university_layout, parent, false);
        return new Viewholder(view, mOnUnisListener);
    }

    @Override
    public void onBindViewHolder(@NonNull UnisAdapter.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        UnisModel model = courseModelArrayList.get(position);
        holder.tvUniName.setText(model.getUniName());
        holder.tvUniNumCampuses.setText("Campuses:" + model.getNumOfCamps());
        holder.uniLogo.setImageResource(model.getUniLogo());
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return courseModelArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView uniLogo;
        private TextView tvUniName, tvUniNumCampuses;
        OnUnisListener onUnisListener;

        public Viewholder(@NonNull View itemView, OnUnisListener onUnisListener) {
            super(itemView);
            uniLogo = itemView.findViewById(R.id.ivSchoolLogo);
            tvUniName = itemView.findViewById(R.id.tvUniName);
            tvUniNumCampuses = itemView.findViewById(R.id.tvNumCampuses);
            this.onUnisListener= onUnisListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onUnisListener.onUniClick(getAdapterPosition());

        }
    }

    public interface OnUnisListener{
        void onUniClick(int position);
    }
}
