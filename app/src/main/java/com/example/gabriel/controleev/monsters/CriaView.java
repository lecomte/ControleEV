package com.example.gabriel.controleev.monsters;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gabriel.controleev.activities.MainActivity;

/**
 * Created by gabriel on 23/10/16.
 */

public class CriaView {

    public static LinearLayout imprime(PokedexEntry pokedexEntry, Context context) {
            DisplayMetrics metrics = context.getResources().getDisplayMetrics();
            LinearLayout l = new LinearLayout(context);
            l.setGravity(Gravity.CENTER);
            l.setOrientation(LinearLayout.HORIZONTAL);
            l.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, (int) (56 * metrics.density + 0.5f)));
            ImageView image = new ImageView(context);
            image.setLayoutParams(new FrameLayout.LayoutParams((int) (56 * metrics.density + 0.5f), (int) (56 * metrics.density + 0.5f)));
            int resId = context.getResources().getIdentifier("sprite" + String.valueOf(pokedexEntry.getDexId()), "drawable", context.getPackageName());
            image.setImageResource(resId);
            l.addView(image);
            TextView text = new TextView(context);
            text.setGravity(Gravity.CENTER);
            text.setText(pokedexEntry.toString());
            text.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
            l.addView(text);
            return l;
    }
}
