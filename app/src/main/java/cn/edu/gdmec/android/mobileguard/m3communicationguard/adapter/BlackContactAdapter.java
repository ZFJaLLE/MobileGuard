package cn.edu.gdmec.android.mobileguard.m3communicationguard.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cn.edu.gdmec.android.mobileguard.R;
import cn.edu.gdmec.android.mobileguard.m3communicationguard.db.dao.BlackNumberDao;
import cn.edu.gdmec.android.mobileguard.m3communicationguard.entity.BlackContactInfo;

/**
 * Created by 郭钦锋 on 2017/11/4.
 */

public class BlackContactAdapter extends BaseAdapter {
    private List<BlackContactInfo>contactInfos;
    private Context context;
    private BlackNumberDao dao;
    private  BlackConactCallBack callBack;
    class ViewHolder{
        TextView mNameTV;
        TextView mModeTV;
        TextView mContactTmgv;
        TextView mDeleteView;

    }
    public interface BlackConactCallBack{
        void DataSizeChanged();

    }
    public void setCallBack(BlackConactCallBack callBack){
        this.callBack=callBack;

    }
    public BlackContactAdapter(List<BlackContactInfo>systemContacts,Context context){
        super();
        this.contactInfos= systemContacts;
        this.context= context;
        dao =new BlackNumberDao(context);
    }
    public int getCount(){
        return contactInfos.size();

    }
    public Object getItem(int i){
        return contactInfos.get(i);

    }
    public long getItemId(int i){
        return i;
    }
    public View getView(final  int i, View view , ViewGroup viewGroup){
        ViewHolder holder= null;
        if(view ==null){
            view= View.inflate(context,
                    R.layout.item_list_blackcontact,null);
            holder =new ViewHolder();
            holder.mNameTV= (TextView) view.findViewById(R.id.tv_black_name);
            holder.mModeTV=(TextView) view.
                    findViewById(R.id.tv_black_mode);


            view.setTag(holder);



        }else{
            holder = (ViewHolder) view.getTag();

        }
return view;
    }
}
