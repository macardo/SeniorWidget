package com.macardo.seniorwidget;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import static com.macardo.seniorwidget.R.id.add;
import static com.macardo.seniorwidget.R.id.progressBar;

public class ProgressBarActivity extends AppCompatActivity implements View.OnClickListener {
    private ProgressBar progressBar;
    private TextView textView;
    private Button addBtn;
    private Button reduceBtn;
    private Button resetBtn;
    private Button progressDialogBtn;
    private ProgressDialog progressDialog;

    private TextView textView2;
    private TextView textView3;
    private SeekBar seekBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.textView2);
        addBtn = findViewById(R.id.addBtn);
        reduceBtn = findViewById(R.id.reduceBtn);
        resetBtn = findViewById(R.id.resetBtn);
        progressDialogBtn = findViewById(R.id.progressDialogBtn);
        seekBar = findViewById(R.id.seekBar);
        textView2 = findViewById(R.id.textView3);
        textView3 = findViewById(R.id.textView4);

        addBtn.setOnClickListener(this);
        reduceBtn.setOnClickListener(this);
        resetBtn.setOnClickListener(this);
        progressDialogBtn.setOnClickListener(this);
        int first = progressBar.getProgress();
        int second = progressBar.getSecondaryProgress();
        int max = progressBar.getMax();
        textView.setText("第一进度条百分比为："+(int)((int)first/(float)max*100) +"%,\n"+"第二进度条百分比为:"+(int)((int)second/(float)max*100)+"%");

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView2.setText("进度条进度："+progress);
                textView3.setText("进度条状态：正在拖动");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                textView3.setText("进度条状态：开始拖动");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView3.setText("进度条状态：停止拖动");
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addBtn:
                progressBar.incrementProgressBy(10);
                progressBar.incrementSecondaryProgressBy(10);
                textView.setText("第一进度条百分比为："+(int)((int)progressBar.getProgress()/(float)progressBar.getMax()*100) +"%,\n"+"第二进度条百分比为:"+(int)((int)progressBar.getSecondaryProgress()/(float)progressBar.getMax()*100)+"%");
                break;
            case R.id.reduceBtn:
                progressBar.incrementProgressBy(-10);
                progressBar.incrementSecondaryProgressBy(-10);
                textView.setText("第一进度条百分比为："+(int)((int)progressBar.getProgress()/(float)progressBar.getMax()*100) +"%,\n"+"第二进度条百分比为:"+(int)((int)progressBar.getSecondaryProgress()/(float)progressBar.getMax()*100)+"%");

                break;
            case R.id.resetBtn:
                progressBar.setProgress(20);
                progressBar.setSecondaryProgress(30);
                textView.setText("第一进度条百分比为："+(int)((int)progressBar.getProgress()/(float)progressBar.getMax()*100) +"%,\n"+"第二进度条百分比为:"+(int)((int)progressBar.getSecondaryProgress()/(float)progressBar.getMax()*100)+"%");
                break;
            case R.id.progressDialogBtn:
                progressDialog = new ProgressDialog(this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("对话框");
                progressDialog.setIcon(R.mipmap.ic_launcher);
                progressDialog.setMax(100);
                progressDialog.incrementProgressBy(50);
                progressDialog.setIndeterminate(false);
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ProgressBarActivity.this,"点击确定",Toast.LENGTH_SHORT).show();
                    }
                });
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;

        }

    }
}
