package mypetalbum.cbc.android.ca.mypetalbum;

import android.app.ActivityOptions;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements PetAdapter.OnItemCLickListener{

    @InjectView(mypetalbum.cbc.android.ca.mypetalbum.R.id.recyclerview)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        ArrayList<PetItemData> imageList = new ArrayList();
        imageList.add(new PetItemData(R.drawable.pic1));
        imageList.add(new PetItemData(R.drawable.pic2));


        final RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(layoutManager);

        final PetAdapter adapter = new PetAdapter(imageList);
        mRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View imageView, int imageRefId, String imageTransitionName) {
        PetImageIntent intent = new PetImageIntent(this, imageRefId, imageTransitionName);
        final ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, imageView, imageTransitionName);
        startActivity(intent, options.toBundle());
    }
}
