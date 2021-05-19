package fr.myapp.selectionneurdejeuvideo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardHolder> {

    public CardViewAdapter(Context context, ArrayList<ItemCardView> cards) {
        this.context = context;
        this.cards = cards;
    }

    private Context context;
    private ArrayList<ItemCardView> cards;

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_item,parent,false);
        return new CardHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {
        ItemCardView card = cards.get(position);
        holder.setDetails(card);
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }


    class CardHolder extends  RecyclerView.ViewHolder{
        private TextView txtTitleCard,
//                txtDescriptionCard,
                txtNoteCard;
        ImageView txtImgCard;

        CardHolder(View itemView) {
            super(itemView);
            txtTitleCard = itemView.findViewById(R.id.cv_title0);
//            txtDescriptionCard = itemView.findViewById(R.id.cv_description0);
            txtImgCard = itemView.findViewById(R.id.cv_img);
            txtNoteCard = itemView.findViewById(R.id.cv_note0);

        }

        void setDetails(ItemCardView card) {
            txtTitleCard.setText(card.getTextTitleList());
//            txtDescriptionCard.setText(card.getTextDescription());
            Picasso.get().load(card.getImgList()).into(txtImgCard);
            txtNoteCard.setText(card.getTextNoteList());
        }
    }

}
