package com.example.mediassist_assignment;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.mediassist_assignment.database.Data;
import com.example.mediassist_assignment.database.DataDao;
import com.example.mediassist_assignment.database.DataRoomDatabase;

public class DataViewModel extends AndroidViewModel {

    private DataDao dataDao;
    private DataRoomDatabase dataDB;

    public DataViewModel(@NonNull Application application) {
        super(application);
        dataDB = DataRoomDatabase.getDataRoomDatabase(application);
        dataDao = dataDB.dataDao();
    }

    public void insert(Data data){
        new InsertAsyncTask(dataDao).execute(data);
    }


    public static class InsertAsyncTask extends AsyncTask<Data, Void, Void>{

        DataDao mDataDao;

        private InsertAsyncTask(DataDao mDataDao){
            this.mDataDao=mDataDao;
        }

        @Override
        protected Void doInBackground(Data... datas) {
            mDataDao.insert(datas[0]);
            return null;
        }
    }
}
