package com.example.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

    Button toFinishTask, toCurrentTask;
    Fragment fragment2, fragment;
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        fragment = fm.findFragmentById(R.id.container_fragm);
        if(fragment == null){
            fragment = new CurrentTaskFragment();
            fm.beginTransaction().add(R.id.container_fragm, fragment)
                    .commit();
        }

        toCurrentTask = findViewById(R.id.currentTask);
        toFinishTask = findViewById(R.id.finishTask);
        toFinishTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fragment2 == null){
                    fragment2 = new FinishTaskFragment();
                }
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container_fragm, fragment2);
                ft.commit();
            }
        });
        //TODO написать возврат на первый фрагмент
        //TODO добавить третий фрагмент "Повторяющиеся задачи"
        //TODO придумать способ хранения введенных задач
    }
}