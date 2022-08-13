package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    Button next;
    EditText name;
    EditText age;
    ImageButton dark;
    View layout;

    // One Button
    Button BSelectImage;

    // One Preview Image
    ImageView IVPreviewImage;

    // constant to compare
    // the activity result code
    int SELECT_PICTURE = 200;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();

        // register the UI widgets with their appropriate IDs
        BSelectImage = findViewById(R.id.upload);
        IVPreviewImage = findViewById(R.id.PreviewImage);

        next = findViewById(R.id.back);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        layout = findViewById(R.id.layout);

        // handle the Choose Image button to trigger
        // the image chooser function
        BSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "ResourceAsColor"})
            @Override
            public void onClick(View hew) {



                //if on section is empty
                if (name.getText().toString().isEmpty() || age.getText().toString().isEmpty()){



                    if(name.getText().toString().isEmpty()){
                        name.setError( "ادخل اسم الطالب!" );
                    }

                    if(age.getText().toString().isEmpty()){
                        age.setError( "ادخل عمر الطالب!" );
                    }



                }else {


                   // Image image = IVPreviewImage.setImageURI();ImageURI(selectedImageUri);
                    String nm = name.getText().toString();
                    int ag = Integer.parseInt(age.getText().toString());
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("name", nm);
                    intent.putExtra("age", ag);
                    startActivity(intent);

                }
            }
        });







    }

    // this function is triggered when
    // the Select Image Button is clicked
    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    // this function is triggered when user
    // selects the image from the imageChooser
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    IVPreviewImage.setImageURI(selectedImageUri);
                }
            }
        }
    }
}