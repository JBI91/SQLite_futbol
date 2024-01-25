package View;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlite_futbol.R;

import java.util.List;

import Controller.CtrlFutbol;
import Model.Equipo;

public class EquipoAdapter extends RecyclerView.Adapter<EquipoAdapter.ViewHolder> {

    private Context con;
    private static List<Equipo> EquipoList;

    public EquipoAdapter(Context con) {
        this.EquipoList = CtrlFutbol.getListaEquipo(con);
    }

    @NonNull
    @Override
    public EquipoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        con = parent.getContext();
        View view = LayoutInflater.from(con).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EquipoAdapter.ViewHolder holder, int position) {
        holder.txtNombre.setText((EquipoList.get(position).getNombre()));
        holder.txtEstadio.setText((EquipoList.get(position).getEstadio()));
        holder.cv.setOnClickListener(v -> {
            Intent i = new Intent(con, MainJugadores.class);
            i.putExtra("id_equipo", EquipoList.get(position).getId());
            con.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return EquipoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        TextView txtNombre, txtEstadio;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtEstadio = itemView.findViewById(R.id.txtEstadio);
        }
    }


}

