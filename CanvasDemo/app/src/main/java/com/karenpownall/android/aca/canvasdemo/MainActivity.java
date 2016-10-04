package com.karenpownall.android.aca.canvasdemo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get reference to imageView in layout
        ImageView ourFrame = (ImageView) findViewById(R.id.imageView);

        //create bitmap object to use as canvas
        Bitmap ourBitmap = Bitmap.createBitmap(750,1500, Bitmap.Config.ARGB_8888);

        Canvas ourCanvas = new Canvas(ourBitmap);

        //paint object that does drawing on canvas
        Paint paint = new Paint();

        //set background color
        ourCanvas.drawColor(Color.BLACK);

        //change color of virtual paint brush
        paint.setColor(Color.argb(255, 255, 255, 255));

        //draw a bunch of random points
        Random random = new Random();
        for (int i = 0; i < 15000; i++){
            int x = random.nextInt(750); //keeps paint inside canvas
            int y = random.nextInt(1500);

            ourCanvas.drawPoint(x, y, paint);
        }

        //draw a line
        ourCanvas.drawLine(0, 0, 750, 1500, paint);

        //change color of paint brush
        paint.setColor(Color.argb(255, 0, 255, 0));

        //make text bigger
        paint.setTextSize(120f);

        //draw some text
        ourCanvas.drawText("Hello Canvas!", 10, 750, paint);

        //draw a circle (x, y, radius, paintbrush)
        ourCanvas.drawCircle(500, 500, 100, paint);

        //change color
        paint.setColor(Color.argb(255, 0, 0, 255));

        //draw a rectangle
        ourCanvas.drawRect(500, 10, 200, 200, paint);

        //put canvas in frame
        ourFrame.setImageBitmap(ourBitmap);
    }
}
