package uca.edu.palmado;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;

public class PokemonInfoFragment extends DialogFragment {
    private MaterialButton exit;
    private View nombre, descripcion, pokemon;

    public PokemonInfoFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle SavedInstance){return crearDialogo();}

    @Override
    public void onAttach(@NonNull Context context) {super.onAttach(context);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon_info, container, false);
    }

    private AlertDialog crearDialogo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.fragment_pokemon_info, null);
        builder.setView(v);

        exit = v.findViewById(R.id.cerrarFragment);
        nombre = v.findViewById(R.id.nombrePokemonFragment);
        descripcion = v.findViewById(R.id.descPokemonFragment);
        pokemon = v.findViewById(R.id.ImgPokemonFragment);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return builder.create();
    }
}