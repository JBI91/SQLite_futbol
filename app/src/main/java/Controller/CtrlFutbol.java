package Controller;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Model.Equipo;
import Model.Jugador;

public class CtrlFutbol {
    private List<Equipo> listaEquipos = new ArrayList<>();
    private List<Jugador> listaJugadores = new ArrayList<>();

    static long idEquipo;

    public static List<Equipo> getListaEquipo(Context context) {
        List<Equipo> list = new ArrayList<>();
        SQLiteDatabase db = new DBSQLite(context).getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Equipo", null);

        if (cursor.getCount() == 0) {
            Log.e("PMDM", "NO DATA FOUND.");
        } else {
            cursor.moveToFirst();
            do {
                long id = cursor.getLong(cursor.getColumnIndexOrThrow("id"));
                String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
                String estadio = cursor.getString(cursor.getColumnIndexOrThrow("estadio"));
                Equipo e = new Equipo(id, nombre, estadio);
                list.add(e);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return list;
    }

    public static List<Jugador> getListaJugador(Context context) {
        List<Jugador> listJ = new ArrayList<>();
        SQLiteDatabase db = new DBSQLite(context).getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Jugador", null);

        if (cursor.getCount() == 0) {
            Log.e("PMDM", "NO DATA FOUND.");
        } else {
            cursor.moveToFirst();
            do {
                if (cursor.getInt(cursor.getColumnIndexOrThrow("equipo_id")) == idEquipo) {
                    long id = cursor.getLong(cursor.getColumnIndexOrThrow("id"));
                    String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
                    String apellidos = cursor.getString(cursor.getColumnIndexOrThrow("apellidos"));
                    int equipo = cursor.getInt(cursor.getColumnIndexOrThrow("equipo_id"));
                    Jugador j = new Jugador(id, nombre, apellidos, equipo);
                    listJ.add(j);
                }

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return listJ;
    }
}
