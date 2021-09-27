package com.example.roomwordssample;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    private WordDAO mWordDAO;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDAO = db.WordDAO();
        mAllWords = mWordDAO.getAlphabetizedWords();
    }

    LiveData<List<Word>> getmAllWords(){
        return mAllWords;
    }

    void insert(Word word){
        WordRoomDatabase.databaseWriteExecutor.execute(()->{
            mWordDAO.insert(word);
        });
    }

}
