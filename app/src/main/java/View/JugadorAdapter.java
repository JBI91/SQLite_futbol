package View;

import android.content.Context;
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
import Model.Jugador;

public class JugadorAdapter extends RecyclerView.Adapter<JugadorAdapter.ViewHolder> {

    private Context con;
    private static List<Jugador> JugadorList;

    public JugadorAdapter(Context con) {
        this.JugadorList = CtrlFutbol.getListaJugador(con);
    }

    @NonNull
    @Override
    public JugadorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        con = parent.getContext();
        View view = LayoutInflater.from(con).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JugadorAdapter.ViewHolder holder, int position) {
        holder.txtNombre.setText((JugadorList.get(position).getNombre()));
        holder.txtApellidos.setText((JugadorList.get(position).getApellidos()));
    }

    @Override
    public int getItemCount() {
        return JugadorList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView txtNombre, txtApellidos, txtEquipo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtApellidos = itemView.findViewById(R.id.txtApellidos);
            txtEquipo = itemView.findViewById(R.id.txtEquipo);
        }
    }
}
