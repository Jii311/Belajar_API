package com.example.belajarapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.belajarapi.api_content.Team;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterTeam extends RecyclerView.Adapter<AdapterTeam.MyViewHolder> {

    List<Team> teammodel;

    public AdapterTeam(List<Team>teammodel) {
        this.teammodel = teammodel;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_layout, parent, false);

        return new AdapterTeam.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTeam.MyViewHolder holder, int position) {
        Team team = teammodel.get(position);
        holder.tvTeamName.setText(team.getStrTeam());
        Picasso.get().load(team.getStrTeamBadge()).into(holder.ivTeamBadge);
    }

    @Override
    public int getItemCount() {
        return teammodel.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvTeamName;
        ImageView ivTeamBadge;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTeamName = itemView.findViewById(R.id.tvTeamName);
            ivTeamBadge = itemView.findViewById(R.id.ivTeamBadge);
        }
    }
}
