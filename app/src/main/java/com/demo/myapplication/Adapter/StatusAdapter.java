package com.demo.myapplication.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.demo.myapplication.Model.Statuspg;
import com.demo.myapplication.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.StatusViewHolder> {

    Context context;
    ArrayList<Statuspg> statuspgArrayList;

    public StatusAdapter(Context context, ArrayList<Statuspg> statuspgArrayList) {
        this.context = context;
        this.statuspgArrayList = statuspgArrayList;
    }

    @NonNull
    @Override
    public StatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StatusViewHolder(LayoutInflater.from(context).inflate(R.layout.item_status, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StatusViewHolder holder, int position) {
        Statuspg statuspg = statuspgArrayList.get(position);

        Glide.with(context)
                .load(statuspg.getStatus_Image())
                .into(holder.imageView);
        holder.nameofuser.setText(statuspg.getStatus_name());
        holder.time.setText(statuspg.getStatus_time());


    }

    @Override
    public int getItemCount() {
        return statuspgArrayList.size();
    }

    public class StatusViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView time, nameofuser;
        RelativeLayout sts_layout;

        public StatusViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.status_image);
            time = itemView.findViewById(R.id.status_timer);
            nameofuser = itemView.findViewById(R.id.status_username);
            sts_layout = itemView.findViewById(R.id.sts_layout);

            sts_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Dialog dialog = new Dialog(context, android.R.style.Theme_Translucent_NoTitleBar);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.loading_screen);
                    Window window = dialog.getWindow();
                    WindowManager.LayoutParams wlp = window.getAttributes();

                    ImageView img = dialog.findViewById(R.id.show_stsimg);
                    ImageView img_open = dialog.findViewById(R.id.opensts_image);
                    TextView opensts_name = dialog.findViewById(R.id.opensts_username);
                    TextView opensts_time = dialog.findViewById(R.id.opensts_time);

                    img_open.setImageResource(statuspgArrayList.get(getAdapterPosition()).getStatus_Image());
                    img.setImageResource(statuspgArrayList.get(getAdapterPosition()).getStatus_Image());
                    opensts_name.setText(statuspgArrayList.get(getAdapterPosition()).getStatus_name());
                    opensts_time.setText(statuspgArrayList.get(getAdapterPosition()).getStatus_time());

                    wlp.gravity = Gravity.CENTER;
                    wlp.flags &= ~WindowManager.LayoutParams.FLAG_BLUR_BEHIND;
                    window.setAttributes(wlp);
                    dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    dialog.show();

                    final Dialog alert = dialog;
                    alert.show();

// Hide after some seconds
                    final Handler handler = new Handler();
                    final Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            if (alert.isShowing()) {
                                Toast.makeText(context, "10 Sec Finish!", Toast.LENGTH_SHORT).show();
                                alert.dismiss();
                            }
                        }
                    };

                    alert.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            handler.removeCallbacks(runnable);
                        }
                    });
                    handler.postDelayed(runnable, 10000);
                }
            });

        }
    }
}
