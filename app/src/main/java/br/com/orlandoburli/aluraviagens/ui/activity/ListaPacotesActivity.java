package br.com.orlandoburli.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.orlandoburli.aluraviagens.R;
import br.com.orlandoburli.aluraviagens.dao.PacoteDAO;
import br.com.orlandoburli.aluraviagens.ui.adapters.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String APP_BAR_TITLE = "Pacotes";
    private final PacoteDAO dao = new PacoteDAO ();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_lista_pacotes );

        setTitle ( APP_BAR_TITLE );

        configureListView ();

        Intent intent = new Intent ( this, ResumoPacoteActivity.class );
        startActivity ( intent );
    }

    private void configureListView() {
        ListView listaDePacotes = findViewById ( R.id.lista_pacotes_listview );
        listaDePacotes.setAdapter ( new ListaPacotesAdapter ( this, dao.lista () ) );
    }
}