package com.rezajax.college.boy2.Downloader;

import android.os.AsyncTask;

import java.util.HashMap;

public class ImageDownloaderTask extends
        AsyncTask<HashMap<String, Object> , Void , HashMap<String, Object>> {
    @Override
    protected void onPostExecute(HashMap<String, Object> stringObjectHashMap) {
        super.onPostExecute(stringObjectHashMap);
    }

    @Override
    protected HashMap<String, Object> doInBackground(HashMap<String, Object>... hashMaps) {
        return null;
    }
}
