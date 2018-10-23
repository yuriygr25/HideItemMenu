package com.example.yura.hideitemmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Menu menu;
    Boolean savedMenuDogIsVisible;
    private Button mInfoTextView;
    final static String KEY_MENU_DOG = "KEY_MENU_DOG";
    Boolean dogVisible=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // извлекаем данные о видимости пункта меню
        if (savedInstanceState != null) {
            savedMenuDogIsVisible = savedInstanceState.getBoolean(KEY_MENU_DOG,
                    true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        this.menu = menu;
        getMenuInflater().inflate(R.menu.test, menu);
        return true;
    }

    public void onClick(View v) {

        if (dogVisible) {
            MenuItem item_dog = menu.findItem(R.id.action_dog);
            // прячем пункт меню
            item_dog.setVisible(false);
            mInfoTextView = (Button) findViewById(R.id.button1);
            mInfoTextView.setText("Сделать видимым");
            dogVisible=false;
        } else
        {
            MenuItem item_dog = menu.findItem(R.id.action_dog);
            item_dog.setVisible(true);
            mInfoTextView = (Button) findViewById(R.id.button1);
            mInfoTextView.setText("Сделать невидимым");
            dogVisible=true;

        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // TODO Auto-generated method stub
        super.onSaveInstanceState(outState);

        if (menu != null) {
            MenuItem item_dog = menu.findItem(R.id.action_dog);
            // сохраняем текущее состояние пункта меню - true или false
            outState.putBoolean(KEY_MENU_DOG, item_dog.isVisible());
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        if (savedMenuDogIsVisible != null) {
            MenuItem item_dog = menu.findItem(R.id.action_dog);
            // перед выводом на экран узнаём нужное состоятние пункта меню
            item_dog.setVisible(savedMenuDogIsVisible);
        }
        return super.onPrepareOptionsMenu(menu);
    }
}
