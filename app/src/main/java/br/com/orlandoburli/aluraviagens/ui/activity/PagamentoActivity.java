package br.com.orlandoburli.aluraviagens.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

import br.com.orlandoburli.aluraviagens.R;
import br.com.orlandoburli.aluraviagens.model.Pacote;
import br.com.orlandoburli.aluraviagens.utils.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITLE_APP_BAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_pagamento );

        setTitle ( TITLE_APP_BAR );

        fillData ();
    }

    private void fillData() {
        Pacote pacote = new Pacote ( "São Paulo - SP", "sao_paulo_sp", 2, new BigDecimal ( 243.99 ) );

        mostraPreco ( pacote );
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById ( R.id.pagamento_preco_pacote );
        preco.setText ( MoedaUtil.formataParaBrasileiro ( pacote.getPreco () ) );
    }
}
