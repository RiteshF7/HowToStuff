package tutorialslink.com.tutorialslinkwebview.adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import tutorialslink.com.tutorialslinkwebview.R;
import tutorialslink.com.tutorialslinkwebview.pojos.ModelHomeMRV;

public class HomeFragMultipleViewRvAdapter extends RecyclerView.Adapter {

    List<ModelHomeMRV> dataSet = new ArrayList<>();
    Context mContext;

    public static class TextTypeViewHolder extends RecyclerView.ViewHolder {

        TextView txtType;


        public TextTypeViewHolder(View itemView) {
            super(itemView);
            this.txtType = (TextView) itemView.findViewById(R.id.type);
        }
    }

    public static class ImageTypeViewHolder extends RecyclerView.ViewHolder {




        public ImageTypeViewHolder(View itemView) {
            super(itemView);

        }
    }

    public static class AudioTypeViewHolder extends RecyclerView.ViewHolder {


        public AudioTypeViewHolder(View itemView) {
            super(itemView);


        }
    }

    public HomeFragMultipleViewRvAdapter( Context context,List<ModelHomeMRV> dataSet) {
        this.dataSet=dataSet;
        this.mContext = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case ModelHomeMRV.TEXT_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_type, parent, false);
                return new TextTypeViewHolder(view);
            case ModelHomeMRV.IMAGE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_type, parent, false);
                return new ImageTypeViewHolder(view);
            case ModelHomeMRV.AUDIO_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.audio_type, parent, false);
                return new AudioTypeViewHolder(view);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {

        switch (dataSet.get(position).type) {
            case 0:
                return ModelHomeMRV.TEXT_TYPE;
            case 1:
                return ModelHomeMRV.IMAGE_TYPE;
            case 2:
                return ModelHomeMRV.AUDIO_TYPE;
            default:
                return -1;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {

        ModelHomeMRV object = dataSet.get(listPosition);
        if (object != null) {
            switch (object.type) {
                case ModelHomeMRV.TEXT_TYPE:
                    ((TextTypeViewHolder) holder).txtType.setText(object.text);

                    break;
                case ModelHomeMRV.IMAGE_TYPE:

                    break;
                case ModelHomeMRV.AUDIO_TYPE:

                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}


package tutorialslink.com.tutorialslinkwebview.pojos;

public class ModelHomeMRV {

    public static final int TEXT_TYPE=0;
    public static final int IMAGE_TYPE=1;
    public static final int AUDIO_TYPE=2;

    public int type;
    public int data;
    public String text;

    public ModelHomeMRV(int type, String text, int data)
    {
        this.type=type;
        this.data=data;
        this.text=text;
    }
}

//implementation

 ArrayList<Model> list= new ArrayList();
        list.add(new Model(Model.TEXT_TYPE,"Hello. This is the Text-only View Type. Nice to meet you",0));
        list.add(new Model(Model.IMAGE_TYPE,"Hi. I display a cool image too besides the omnipresent TextView.",R.drawable.wtc));
        list.add(new Model(Model.AUDIO_TYPE,"Hey. Pressing the FAB button will playback an audio file on loop.",R.raw.sound));
        list.add(new Model(Model.IMAGE_TYPE,"Hi again. Another cool image here. Which one is better?",R.drawable.snow));

        MultiViewTypeAdapter adapter = new MultiViewTypeAdapter(list,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);

