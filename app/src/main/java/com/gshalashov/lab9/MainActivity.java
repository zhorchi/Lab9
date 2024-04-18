package com.gshalashov.lab9;

import static android.graphics.Color.parseColor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setSupportActionBar(findViewById(R.id.toolbar));

        findViewById(R.id.text_view).setOnCreateContextMenuListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.preferences) {
            Toast.makeText(this, "Фон изменен на белый", Toast.LENGTH_SHORT).show();
            findViewById(R.id.main).setBackgroundColor(parseColor("#FFFFFF"));
            return true;
        } else if (itemId == R.id.second) {
            Toast.makeText(this, "Фон изменен на синий", Toast.LENGTH_SHORT).show();
            findViewById(R.id.main).setBackgroundColor(parseColor("#0099FF"));
            return true;
        } else if (itemId == R.id.home) {
            Toast.makeText(this, "Фон изменен на красный", Toast.LENGTH_SHORT).show();
            findViewById(R.id.main).setBackgroundColor(parseColor("#C83F49"));
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(1, 1, 0, "Круг");
        menu.add(1, 2, 1, "Квадрат");
    }

    public boolean onContextItemSelected(MenuItem item) {

        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        switch (item.getItemId()) {
            case 1:
                ImageView circle = new ImageView(MainActivity.this);

                Drawable cicleDrawable = getResources().getDrawable(R.drawable.circle);
                circle.setImageDrawable(cicleDrawable);

                circle.setLayoutParams(new ViewGroup.LayoutParams(100, 100));

                ll.addView(circle);
                Toast.makeText(this, "Добавлен круг", Toast.LENGTH_SHORT).show();

                return true;
            case 2:

                ImageView square = new ImageView(MainActivity.this);

                Drawable squareDrawable = getResources().getDrawable(R.drawable.square);
                square.setImageDrawable(squareDrawable);

                square.setLayoutParams(new ViewGroup.LayoutParams(100, 100));
                Toast.makeText(this, "Добавлен квадрат", Toast.LENGTH_SHORT).show();
                ll.addView(square);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}