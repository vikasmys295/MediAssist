package com.example.mediassist_assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mediassist_assignment.Api.JsonPlaceHolderApi;
import com.example.mediassist_assignment.Api.RetrofitInstance;
import com.example.mediassist_assignment.model.Example;
import com.example.mediassist_assignment.model.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    private List<Result> results = new ArrayList<>();
    private DataViewModel dataViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textview_result);

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

         getResponseData();
    }
    public void getResponseData(){JsonPlaceHolderApi jsonPlaceHolderApi = RetrofitInstance.getService();
        Call<Example> call = jsonPlaceHolderApi.getData("LaksqnjhxBtkEpfkNf038nwMZ072eaeNiOeY");
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                String id, firstname, lastname, gender;

                Example result = response.body();
                results = result.getResult();
                for (Result r : results) {
                    firstname = r.getFirstName();
                    lastname = r.getLastName();
                    gender = r.getGender();

                    String content = "";
                    content += "FirstName: " + r.getFirstName() + "\n";
                    content += "LastName: " + r.getLastName() + "\n";
                    content += "Gender:  " + r.getGender() + "\n\n";

                    textView.append(content);
                    // Data userData = new Data(firstname,lastname,gender);
                    // dataViewModel.insert(userData);
                }
            }
            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                textView.setText("please turn on your mobile network");
                Toast.makeText(getApplicationContext(), "check internet connection", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
