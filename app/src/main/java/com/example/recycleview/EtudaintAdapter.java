package com.example.recycleview;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.annotation.Native;
import java.util.List;

public class EtudaintAdapter extends RecyclerView.Adapter<EtudaintAdapter.EtudaintViewHolder>
{
    public Context context;
    public List<Etudaint> listeEtudaint;

    public EtudaintAdapter(Context context, List<Etudaint> listeEtudaint) {
        this.context = context;
        this.listeEtudaint = listeEtudaint;
    }

    @NonNull
    @Override
    public EtudaintViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleviewitem,parent,false);
        EtudaintViewHolder etudaintViewHolder = new EtudaintViewHolder(view);
        return etudaintViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EtudaintViewHolder holder,@SuppressLint("RecyclerView") int position) {
        Etudaint etudaint = listeEtudaint.get(position);
        holder.Matricule.setText(etudaint.getMatricule());
        holder.Nom.setText(etudaint.getNom());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,listeEtudaint.get(position).getNom(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemView.setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle("Confirmation suppression");
                        builder.setMessage("Voulez vous vraiement supprimer définetivement les infos de ce etduaint");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                listeEtudaint.remove(position);
                                notifyItemRemoved(position);
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.show();
                        return false;
                    }
                });
    }

    @Override
    public int getItemCount() {
        return listeEtudaint.size();
    }

    public static class EtudaintViewHolder extends RecyclerView.ViewHolder{

    TextView Matricule;
    TextView Nom;
    public EtudaintViewHolder(@NonNull View itemView){
        super(itemView);
        Matricule=itemView.findViewById(R.id.txtmatricule);
        Nom = itemView.findViewById(R.id.txtname);
    }
}
}
