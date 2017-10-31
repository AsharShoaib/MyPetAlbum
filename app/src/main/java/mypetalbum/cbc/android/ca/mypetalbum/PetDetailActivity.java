package mypetalbum.cbc.android.ca.mypetalbum;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class PetDetailActivity extends Activity{

    @InjectView(mypetalbum.cbc.android.ca.mypetalbum.R.id.view_dog_imageview)
    ImageView mImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_image);
        ButterKnife.inject(this);

        PetImageIntent intent = new PetImageIntent(getIntent());
        mImageView.setTransitionName(intent.getTransitionName());
        mImageView.setImageResource(intent.getImageId());

    }
}
