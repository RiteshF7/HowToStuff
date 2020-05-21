package tutorialslink.com.tutorialslinkwebview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tutorialslink.com.tutorialslinkwebview.R;
import tutorialslink.com.tutorialslinkwebview.pojos.editprofilemodles.EditInfoHeader;
import tutorialslink.com.tutorialslinkwebview.pojos.editprofilemodles.EditInfoModel;
import tutorialslink.com.tutorialslinkwebview.pojos.editprofilemodles.EditPhotoModel;
import tutorialslink.com.tutorialslinkwebview.pojos.editprofilemodles.EditProfileModel;


public class AdapterEditProfileMultipleRV extends RecyclerView.Adapter{

    static final int EDIT_PHOTO_VIEW = R.layout.rv_layout_edit_photo;
    static final int EDIT_INFO_VIEW = R.layout.rv_layout_edit_info;
    static final int INFO_HEADER_VIEW = R.layout.rv_layout_edit_info_header;

    List<EditProfileModel> dataSet = new ArrayList<>();
    Context context;
    LayoutInflater layoutInflater;
    public AdapterEditProfileMultipleRV(List<EditProfileModel> dataSet, Context context) {
        this.dataSet = dataSet;
        this.context = context;
        layoutInflater =LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case EDIT_PHOTO_VIEW:
                 view =layoutInflater.inflate(EDIT_PHOTO_VIEW,parent,false);
                return new EditPhotoViewHolder(view);
            case EDIT_INFO_VIEW:
                 view =layoutInflater.inflate(EDIT_INFO_VIEW,parent,false);
                return new EditPhotoViewHolder(view);
            case INFO_HEADER_VIEW:
                 view =layoutInflater.inflate(INFO_HEADER_VIEW,parent,false);
                return new EditPhotoViewHolder(view);
            default:
                view = layoutInflater.inflate(R.layout.default_rv_view_null,parent,false);
                return new DefaultView(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Object currentObject = dataSet.get(position);
        if(holder instanceof EditPhotoViewHolder){
            EditPhotoModel editPhotoModel = (EditPhotoModel) currentObject;
        }
        else if (holder instanceof EditInfoViewHolder){
            EditInfoModel editPhotoModel = (EditInfoModel) currentObject;
        }
        else if (holder instanceof InfoHeaderViewHolder){
            EditInfoHeader editPhotoModel = (EditInfoHeader) currentObject;
        }

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (dataSet.get(position).getType()){
            case 0:
                return EDIT_PHOTO_VIEW;
            case 1:
                return INFO_HEADER_VIEW;
            case 2:
                return  EDIT_INFO_VIEW;
            default:
                return -1;
        }
    }



    public class DefaultView extends RecyclerView.ViewHolder{

        public DefaultView(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class EditPhotoViewHolder extends RecyclerView.ViewHolder{

        public EditPhotoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    public class EditInfoViewHolder extends RecyclerView.ViewHolder{

        public EditInfoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    public class InfoHeaderViewHolder extends RecyclerView.ViewHolder{

        public InfoHeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
