package br.com.orlandoburli.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        Intent intent = getIntent ();

        if (intent.hasExtra ( "pacote" )) {

            final Pacote pacote = (Pacote) intent.getSerializableExtra ( "pacote" );

            mostraPreco ( pacote );

            final Button botaoFinalizaCompra = findViewById ( R.id.pagamento_botao_finaliza_compra );

            botaoFinalizaCompra.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent ( PagamentoActivity.this, ResumoCompraActivity.class );
                    intent.putExtra ( "pacote", pacote );
                    startActivity ( intent );
                }
            } );
        }
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById ( R.id.pagamento_preco_pacote );
        preco.setText ( MoedaUtil.formataParaBrasileiro ( pacote.getPreco () ) );
    }
}
