package uca.edu.palmado;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static androidx.core.widget.TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration;
import static uca.edu.palmado.R.id.ImgPokemon;
import static uca.edu.palmado.R.id.content;
import static uca.edu.palmado.R.id.grid_item;
import static uca.edu.palmado.R.id.list_item;

public class MainActivity extends AppCompatActivity {

    private RecyclerView pokemonRV;
    private Adapter pokemonsAdapter;
    private GridLayoutManager gridLayoutManager;
    private Fragment pokemonFragment;
    private FragmentTransaction transaction;
    private CardView cvPokemon;
    private List<Pokemons> pokemon;

    private ImageButton imgFavorite;
    private Menu menu;
    //private TextView nombrePok;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                AppCompatDelegate.setDefaultNightMode(
                        AppCompatDelegate.MODE_NIGHT_NO);

        setContentView(R.layout.activity_main);

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.miHome);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.miHome:
                        return true;

                    case R.id.miAlarm:
                        startActivity(new Intent(getApplicationContext()
                                , Reminder.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.miProfile:
                        startActivity(new Intent(getApplicationContext()
                                , AboutUs.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.miMoney:
                        startActivity(new Intent(getApplicationContext()
                                , Presupuesto.class));
                        overridePendingTransition(0,0);
                        return true;
                }//Fin switch
                return false;
            }
        });

        loadAll();
    }

    public void loadAll() {
        //LE SETEAMOS EL VALOR DE NUESTRO BOTON DE FAVORITOS A imgFavorite
        imgFavorite = (ImageButton) findViewById(R.id.imgFav);
        //LINEA SIN IMPORTANCIA... ESO CREO
        //nombrePok = (TextView) findViewById(R.id.nombrePokemon);

        //SETEAMOS LA CANTIDAD DE COLUMNAS QUE TENDRA NUESTRA VISTA AL INICIAL EL ACTIVITY
        gridLayoutManager = new GridLayoutManager(this, 1);

        //SETEAMOS EL VALOR DE NUESTRO RECYCLER VIEW A pokemonRV
        pokemonRV = (RecyclerView) findViewById(R.id.pokemonsRV);
        //SETEAMOS EL LAYOUT QUE TENDRA EL RECYCLER VIEW, EN ESTE CASO EL QUE SETEAMOS ANTERIORMENTE
        pokemonRV.setLayoutManager(gridLayoutManager);

        //CREAMOS UNA LINEA ENTRE CADA ITEM DEL RECYCLER VIEW PARA QUE ESTOS SE PUEDAN DISTINGUIR
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        pokemonRV.addItemDecoration(dividerItemDecoration);

        //LE SETEAMOS AL ADAPTADOR LA LISTA DE POKEMONS QUE VAMOS A AÑADIR AL RECYCLER VIEW
        pokemonsAdapter = new Adapter(obtainPokemon());

        //SETEAMOS EL ADAPTADOR EN NUESTRO RECYCLER VIEW
        pokemonRV.setAdapter(pokemonsAdapter);

        //LE SETEAMOS EL VALOR AL OBJETO DE TIPO FRAGMENT
        //PARA QUE CONTENGA LOS ATRIBUTOS DE LA CLASE PokemonInfoFrament
        pokemonFragment = new PokemonInfoFragment();

        //getSupportFragmentManager().beginTransaction().add(R.id.CardPokemonFragment, pokemonFragment).commit();
    }

    //METODO QUE DEVUELVE LA LISTA DE OBJETOS DE TIPO POKEMONS
    public List<Pokemons> obtainPokemon() {
        List<Pokemons> pokemon = new ArrayList<>();
        //PIKACHU
        pokemon.add(new Pokemons("#1", "C$300",
                "Los Pikachu que pueden generar una poderosa electricidad tienen sacos en las mejillas que son extra suaves y súper elásticos."
                , R.drawable.___pikachu));
        //NINETALES
        pokemon.add(new Pokemons("#2", "C$1000",
                "Se dice que vive 1.000 años y cada una de sus colas está cargada de poderes sobrenaturales.",
                R.drawable.___ninetales));
        //JIGGLYPUFF
        pokemon.add(new Pokemons("#3", "C$200",
                "Jigglypuff tiene una capacidad pulmonar de primer nivel, incluso en comparación con otros Pokémon. No dejará de cantar sus canciones de cuna hasta que sus enemigos se duerman.",
                R.drawable.___jigglypuff));
        //MEOWTH
        pokemon.add(new Pokemons("#4", "C$150",
                "Le encanta coleccionar cosas brillantes. Si está de buen humor, incluso podría dejar que su entrenador eche un vistazo a su tesoro.",
                R.drawable.___meowth));
        //PSYDUCK
        pokemon.add(new Pokemons("#5", "C$500",
                "Psyduck es un pokemon el cual está constantemente acosado por dolores de cabeza. Si el Pokémon deja que su extraño poder brote, aparentemente el dolor cede por un tiempo.",
                R.drawable.___psyduck));
        //PONYTA
        pokemon.add(new Pokemons("#6", "C$270",
                "No puede correr bien cuando es recién nacido. A medida que corre con otros de su clase, sus piernas se fortalecen.",
                R.drawable.___ponyta));
        //GENGAR
        pokemon.add(new Pokemons("#7", "C$270",
                "En la noche de luna llena, si las sombras se mueven solas y ríen, debe ser obra de Gengar.",
                R.drawable.___gengar));
        //CUBONE
        pokemon.add(new Pokemons("#8", "C$170",
                "Cuando el recuerdo de su difunta madre lo hace llorar, sus gritos resuenan con tristeza dentro del cráneo que lleva en la cabeza.",
                R.drawable.___cubone));
        //CHANSEY
        pokemon.add(new Pokemons("#9", "C$300",
                "El huevo que lleva Chansey no solo es delicioso, sino que también está lleno de nutrientes. Se utiliza como ingrediente de cocina de primera clase.",
                R.drawable.___chansey));
        //SNORLAX
        pokemon.add(new Pokemons("#10", "C$1000",
                "No está satisfecho a menos que coma más de 880 libras de comida todos los días. Cuando termina de comer, se duerme rápidamente.",
                R.drawable._0__snorlax));
        return pokemon;
    }

    //METODO PARA CAMBIAR EL COLOR DEL ICONO DEL BOTON DE FAVORITOS --- UNUSED
//    public void changeIcon (View view){
//        imgFavorite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imgFavorite.setImageResource(R.drawable.corazonfill);
//            }
//        });
//    }

    //METODO USADO PARA INFLAR LAS ACCIONES DEL ACTION BAR
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;

        //INFLAMOS EL MENU
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //METODO QUE FUNCIONA PARA HACER ALGO AL MOMENTO DE SELECCIONAR
    //UNA DE LAS ACCIONES DEL ACTION BAR
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.grid_item:
                switchLayout();
                switchIcon(item);
                return true;
            case R.id.grid_item1:
                Intent intent = new Intent(this, Presupuesto.class);
                startActivity(intent);
                return true;
            case R.id.grid_item2:
                Intent intent1 = new Intent(this, Reminder.class);
                startActivity(intent1);
                return true;
        }
        return super.onOptionsItemSelected(item);

//        if( id == grid_item){
//            pokemonRV.setLayoutManager(new GridLayoutManager(this, 2));
//            menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.list_icon));
//        }

        //return super.onOptionsItemSelected(item);
    }

    public void act(View v) {
        HelpView();
    }

    private void HelpView() {
        Intent intent = new Intent(this, admin_gasto.class);
        startActivity(intent);
    }

    //METODO QUE FUNCIONA PARA CAMBIAR EL DISEÑO DEL GridLayourManager
    //QUE LE SETEAMOS AL RECYCLER VIEW EN EL METODO ONCREATE DE LA VISTA
    private void switchLayout() {
        if (gridLayoutManager.getSpanCount() == 1) {
            gridLayoutManager.setSpanCount(2);
        } else {
            gridLayoutManager.setSpanCount(1);
        }
        pokemonsAdapter.notifyItemRangeChanged(0, pokemonsAdapter.getItemCount());
    }

    //METODO QUE CAMBIA EL ICONO DE LA ACCION DEL ACTION BAR CADA VEZ QUE
    //SE TOCA
    private void switchIcon(MenuItem item) {
        if (gridLayoutManager.getSpanCount() == 2) {
            item.setIcon(getResources().getDrawable(R.drawable.list_icon));
        } else {
            item.setIcon(getResources().getDrawable(R.drawable.grid_icon));
        }
    }

    //@Override
    //public void onItemTap(View view, int position) {
    //    showPokemonDetailsFragment(position);
    //}

    private void showPokemonDetailsFragment(int position) {
        //Pokemons selectedItem = pokemon.get(position);
        PokemonInfoFragment pokemonInfoFragment = new PokemonInfoFragment();
        pokemonInfoFragment.show(getSupportFragmentManager(), "Pokemon");
    }
}



