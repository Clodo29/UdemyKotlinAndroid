package com.devmasterteam.loginmvvm

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mContext: Context
    private lateinit var mMainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Variáveis
        this.mContext = this
        this.mMainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        // Eventos
        buttonLogin.setOnClickListener(this)

        // Inicializa observers
        this.createObservers()
    }

    override fun onClick(view: View?) {
        val name = editName.text.toString()
        this.mMainViewModel.doLogin(name)
    }

    fun createObservers() {
        mMainViewModel.getWelcome().observe(this, Observer {
            textWelcome.text = it
        })
        mMainViewModel.getToastNotification().observe(this, Observer {
            Toast.makeText(mContext, it, Toast.LENGTH_SHORT).show()
        })
    }

}
