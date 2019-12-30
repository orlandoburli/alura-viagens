package br.com.orlandoburli.aluraviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.orlandoburli.aluraviagens.R;
import br.com.orlandoburli.aluraviagens.model.Pacote;
import br.com.orlandoburli.aluraviagens.utils.MoedaUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String APP_TITLE = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_resumo_compra );

        setTitle ( APP_TITLE );

        fillData ();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent ( this, ListaPacotesActivity.class );
        intent.addFlags ( Intent.FLAG_ACTIVITY_CLEAR_TOP );
        startActivity ( intent );
    }


    private void fillData() {
        Intent intent = getIntent ();

        if (intent.hasExtra ( "pacote" )) {

            final Pacote pacote = (Pacote) intent.getSerializableExtra ( "pacote" );

            fillImagem ( pacote );
            fillLocal ( pacote );
            fillDias ( pacote );
            fillPreco ( pacote );
        }
    }

    private void fillPreco(Pacote pacote) {
        TextView preco = findViewById ( R.id.resumo_compra_preco );
        preco.setText ( MoedaUtil.formataParaBrasileiro ( pacote.getPreco () ) );
    }

    private void fillDias(Pacote pacote) {
        TextView dias = findViewById ( R.id.resumo_compra_dias );
        dias.setText ( pacote.getDias () + " dia" + (pacote.getDias () > 1 ? "s" : "") );
    }

    private void fillLocal(Pacote pacote) {
        TextView local = findViewById ( R.id.resumo_compra_local );
        local.setText ( pacote.getLocal () );
    }

    private void fillImagem(Pacote pacote) {
        ImageView imagem     = findViewById ( R.id.resumo_compra_imagem_pacote );
        final int idDrawable = this.getResources ().getIdentifier ( pacote.getImagem (), "drawable", this.getPackageName () );
        Drawable  drawable   = this.getResources ().getDrawable ( idDrawable );
        imagem.setImageDrawable ( drawable );
    }

}
