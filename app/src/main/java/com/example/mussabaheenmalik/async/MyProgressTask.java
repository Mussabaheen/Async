package com.example.mussabaheenmalik.async;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import static android.R.attr.value;
import static android.content.ContentValues.TAG;

/**
 * Created by mussabaheenmalik on 9/9/17.
 */

public class MyProgressTask extends AsyncTask<Void,Integer,String> {
    Context ctx;
    ProgressDialog pd;
    public MyProgressTask(Context ct){
        ctx = ct;


    }
    @Override
    protected void onPreExecute() {
        pd = new ProgressDialog(ctx);
        pd.setTitle("DOWNLOADER");
        pd.setMessage("KINDLY WAIT");
        pd.setMax(10);
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setButton(ProgressDialog.BUTTON_NEGATIVE, "cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        pd.show();
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            int num=1000;
            for (int i = 0; i <= 10; i++) {
                Thread.sleep(num);
                Log.i("THREAD", "Execute "+i);
                publishProgress(i,num);
            }
            return "Succesfull";
        }
        catch (Exception e){
            Log.i("Exception", e.getMessage());
            return "Failure";
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int myvalue = values[0];
        Toast.makeText(ctx, "Sleeping for "+values[1], Toast.LENGTH_LONG).show();
        pd.setProgress(myvalue);

    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(ctx, "MISSION SUCCESFULL : "+s, Toast.LENGTH_SHORT).show();

    }
}
