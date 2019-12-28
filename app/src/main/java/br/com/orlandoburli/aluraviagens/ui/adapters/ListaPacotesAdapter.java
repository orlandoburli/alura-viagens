package br.com.orlandoburli.aluraviagens.ui.adapters;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import br.com.orlandoburli.aluraviagens.R;
import br.com.orlandoburli.aluraviagens.model.Pacote;
import br.com.orlandoburli.aluraviagens.ui.activity.ListaPacotesActivity;

public class ListaPacotesAdapter extends BaseAdapter {

    private final ListaPacotesActivity context;

    private final List<Pacote> pacotes;

    private final NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance (
            new Locale ( "pt", "br" ) );

    public ListaPacotesAdapter(ListaPacotesActivity context, List<Pacote> pacotes) {
        this.context = context;
        this.pacotes = pacotes;
    }

    @Override
    public int getCount() {
        return this.pacotes.size ();
    }

    @Override
    public Object getItem(int position) {
        return this.pacotes.get ( position );
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater
                .from ( this.context )
                .inflate ( R.layout.item_pacote, parent, false );

        Pacote pacote = this.pacotes.get ( position );

        ImageView imagem = view.findViewById ( R.id.item_pacote_imagem );
        TextView  local  = view.findViewById ( R.id.item_pacote_local );
        TextView  dias   = view.findViewById ( R.id.item_pacote_dias );
        TextView  preco  = view.findViewById ( R.id.item_pacote_preco );

        final int idDrawable = context.getResources ().getIdentifier ( pacote.getImagem (), "drawable", context.getPackageName () );

        Drawable drawable = context.getResources ().getDrawable ( idDrawable );

        local.setText ( pacote.getLocal () );
        imagem.setImageDrawable ( drawable );
        dias.setText ( pacote.getDias () + " dia" + (pacote.getDias () > 1 ? "s" : "") );
        preco.setText ( formatoBrasileiro.format ( pacote.getPreco () ) );

        return view;
    }
}
