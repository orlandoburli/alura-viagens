package br.com.orlandoburli.aluraviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import br.com.orlandoburli.aluraviagens.R;
import br.com.orlandoburli.aluraviagens.model.Pacote;
import br.com.orlandoburli.aluraviagens.utils.DataUtil;
import br.com.orlandoburli.aluraviagens.utils.MoedaUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    private static final String APP_TITLE = "Resumo do Pacote";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_resumo_pacote );

        setTitle ( APP_TITLE );

        fillData ();

        startActivity ( new Intent ( this, PagamentoActivity.class ) );
    }

    private void fillData() {
        Pacote pacote = new Pacote ( "São Paulo - SP", "sao_paulo_sp", 2, new BigDecimal ( 243.99 ) );

        fillImagem ( pacote );
        fillLocal ( pacote );
        fillDias ( pacote );
        fillPreco ( pacote );
        fillPeriodo ( pacote );
    }

    private void fillPeriodo(Pacote pacote) {
        TextView periodo = findViewById ( R.id.resumo_pacote_data );

        periodo.setText ( DataUtil.periodoEmTexto ( pacote.getDias () ) );
    }

    private void fillPreco(Pacote pacote) {
        TextView preco = findViewById ( R.id.resumo_pacote_preco );
        preco.setText ( MoedaUtil.formataParaBrasileiro ( pacote.getPreco () ) );
    }

    private void fillDias(Pacote pacote) {
        TextView dias = findViewById ( R.id.resumo_pacote_dias );
        dias.setText ( pacote.getDias () + " dia" + (pacote.getDias () > 1 ? "s" : "") );
    }

    private void fillLocal(Pacote pacote) {
        TextView local = findViewById ( R.id.resumo_pacote_local );
        local.setText ( pacote.getLocal () );
    }

    private void fillImagem(Pacote pacote) {
        ImageView imagem     = findViewById ( R.id.resumo_pacote_imagem );
        final int idDrawable = this.getResources ().getIdentifier ( pacote.getImagem (), "drawable", this.getPackageName () );
        Drawable  drawable   = this.getResources ().getDrawable ( idDrawable );
        imagem.setImageDrawable ( drawable );
    }


}
