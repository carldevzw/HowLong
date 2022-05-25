package com.grpprj.howlong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CampsAdapter extends RecyclerView.Adapter<CampsAdapter.Viewholder> {

    private Context context;
    private ArrayList<CampusModel> campusModelArrayList;

    // Constructor
    public CampsAdapter(Context context, ArrayList<CampusModel> campusModelArrayList) {
        this.context = context;
        this.campusModelArrayList = campusModelArrayList;
    }

    @NonNull
    @Override
    public CampsAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.campuses_details_layout, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CampsAdapter.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout

        CampusModel model = campusModelArrayList.get(position);
        holder.tvCampName.setText(model.getName());
        holder.tvCampFacul.setText(context.getString(R.string.fuculties) + model.getFaculty());
        holder.tvCampService.setText(context.getString(R.string.services) + model.getServices());

        holder.btnNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return campusModelArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder {
        public TextView tvCampName, tvCampFacul, tvCampService;
        private ImageButton btnNavigate;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            this.tvCampName = itemView.findViewById(R.id.tvCampName);
            this.tvCampFacul = itemView.findViewById(R.id.tvFaculties);
            this.tvCampService = itemView.findViewById(R.id.tvServices);
            this.btnNavigate= itemView.findViewById(R.id.btnNavigate);

        }

    }
}
