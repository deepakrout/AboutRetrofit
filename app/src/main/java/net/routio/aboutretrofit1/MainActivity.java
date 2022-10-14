package net.routio.aboutretrofit1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView mainParaElem;
    private TextView mainTitleElem;
    private static final String TAG = "TextMainActivity";
    private ListView aboutContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainParaElem = findViewById(R.id.mainPara);
        mainTitleElem = findViewById(R.id.mainTitle);
        aboutContents = findViewById(R.id.aboutContent);
       fetchAbouts();
    }

    private void fetchAbouts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://connectprdnyp.azureedge.net/data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AboutService aboutService = retrofit.create(AboutService.class);

        Call<About> call = aboutService.getAbouts("NypAdvanceAbout.json");

        call.enqueue(new Callback<About>() {
            @Override
            public void onResponse(Call<About> call, Response<About> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "Call to server is not successful "+response.code());
                }

                About about = response.body();
                mainParaElem.setText(about.getMainParagraph());
                mainTitleElem.setText(about.getMainHeader());
                AboutContentAdapter contentAdapter = new AboutContentAdapter(getApplication(),about.getContents());
                aboutContents.setAdapter(contentAdapter);
            }

            @Override
            public void onFailure(Call<About> call, Throwable t) {
                Log.d(TAG, "From: " + t.getMessage());
            }
        });
    }
}