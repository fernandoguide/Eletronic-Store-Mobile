package com.example.eletronicstore

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentTransaction
import com.example.eletronicstore.model.Categoria
import com.example.eletronicstore.services.ClientEletronicStore
import com.example.eletronicstore.storage.SessionManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.internal.ContextUtils.getActivity
import kotlinx.android.synthetic.main.fragment_carrinho.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Main : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var homeFragment: HomeFragment
    private lateinit var categoriaFragment: CategoriaFragment
    private lateinit var carrinhoFragment: CarrinhoFragment
    private lateinit var perfilFragment: PerfilFragment

    private lateinit var sessionManager: SessionManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)



        homeFragment = HomeFragment()
        supportFragmentManager
          .beginTransaction()
        .replace(R.id.frame_layout, homeFragment)
        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        .commit()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNav)
        //bottomNavigationView.getMenu().getItem(1).setChecked(true)
        bottomNavigationView.setSelectedItemId(R.id.inicio);

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId){

                R.id.categoria -> {
                    categoriaFragment = CategoriaFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, categoriaFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }
                R.id.inicio -> {
                    homeFragment = HomeFragment()
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.frame_layout, homeFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .commit()

                }
                R.id.carrinho -> {
                    carrinhoFragment = CarrinhoFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, carrinhoFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }

                R.id.perfil -> {
                    perfilFragment = PerfilFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, perfilFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }
            }
            true
        }

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_person
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        //getData()
    }

    private fun getData(){


        sessionManager = SessionManager(this)

        val token = sessionManager.fetchAuthToken()





        ClientEletronicStore.endpoint.categorias(token)
            .enqueue(
                object : Callback<List<Categoria>> {
                    override fun onResponse(call: Call<List<Categoria>>, response: Response<List<Categoria>>) {
                        val transacao = supportFragmentManager.beginTransaction()



                        Log.d("Body", response.body().toString())

                        response.body()?.forEach { item ->
                            Log.d("Nome item", item.nome.toString())
                            val params = Bundle()
                            params.putString("nome", item.nome.toString())
                            val fragmento = CategoriaFragment()
                            fragmento.arguments = params

                            transacao.add(R.id.frame_layout, fragmento)
                        }

                        //response.body()?.f {
                          // params.putString("id", response.body()?.get(0)?.id.toString())
                           // params.putString("nome", response.body()?.get(0)?.nome?.toString())
                        //}


                        transacao.commit()


                    }
                    override fun onFailure(call: Call<List<Categoria>>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }
                })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun finCompra(view: View) {
        btn_finalizarCompra.setOnClickListener() {

                startActivity(Intent(this, TelaPagamentoActivity::class.java))
                finish()


        }
    }
}