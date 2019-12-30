package br.com.orlandoburli.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.orlandoburli.aluraviagens.R;
import br.com.orlandoburli.aluraviagens.dao.PacoteDAO;
import br.com.orlandoburli.aluraviagens.model.Pacote;
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
    }

    private void configureListView() {
        ListView           listaDePacotes = findViewById ( R.id.lista_pacotes_listview );
        final List<Pacote> pacotes        = dao.lista ();
        listaDePacotes.setAdapter ( new ListaPacotesAdapter ( this, pacotes ) );

        listaDePacotes.setOnItemClickListener ( new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent ( ListaPacotesActivity.this, ResumoPacoteActivity.class );
                intent.putExtra ( "pacote", pacotes.get ( position ) );
                startActivity ( intent );
            }
        } );
    }
}