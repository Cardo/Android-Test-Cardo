package com.cardo.bairesdevtest.ui.slideshow;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.cardo.bairesdevtest.R;
import com.cardo.bairesdevtest.helpers.JsonPlaceHolderApi;
import com.cardo.bairesdevtest.models.Proyectos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProyectosFragment extends Fragment {

    private TextView textView;
    private LinearLayout lv;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_proyectos, container, false);

        //Localiza LinearLayout que se alimentará de entries
        lv = root.findViewById(R.id.githubll);

        //Inicializa URL para GET
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/orgs/kotlin/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Inicializa API
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        //Asigna parsing
        Call<List<Proyectos>> listCall = jsonPlaceHolderApi.getPosts();
        //Ejecuta rendering
        listCall.enqueue(new Callback<List<Proyectos>>() {
            @Override
            public void onResponse(Call<List<Proyectos>> call, Response<List<Proyectos>> response) {
                if (!response.isSuccessful()) {
                    //textView.setText("Code " + response.code());
                    return;
                }

                List<Proyectos> posts = response.body();

                //Construye entries de lista lineal simple incluyendo click, en caso de algo más demandante se hubiera usado un RecyclerView o similar

                for (Proyectos post : posts) {

                    String content = "";
                    final String dir = post.getDireccion();
                    content += "ID: " + post.getId() + "\n";

                    content += "Nombre: " + post.getNombre() + "\n";
                    content += "URL: " + post.getDireccion() + "\n\n";

                    ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    TextView tv=new TextView(getActivity());
                    tv.setLayoutParams(lparams);
                    tv.setText(content);
                    tv.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            Intent repo = new Intent( Intent.ACTION_VIEW , Uri.parse(dir) );
                            startActivity(repo);

                        }
                    });

                    lv.addView(tv);

                }

            }

            @Override
            public void onFailure(Call<List<Proyectos>> call, Throwable t) {
                //textView.setText(t.getMessage());
            }
        });
        return root;
    }
}
