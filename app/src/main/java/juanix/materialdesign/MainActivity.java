package juanix.materialdesign;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageButton;

public class MainActivity extends Activity{

    ImageButton btnAdd, btnLess;
    View miEncabezado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (ImageButton)findViewById(R.id.btnAdd);
        btnLess = (ImageButton) findViewById(R.id.btnLess);
        miEncabezado = (View) findViewById(R.id.view);
    }

    public void OcultarPantalla(View view){

            if(miEncabezado.getVisibility() == View.VISIBLE)
            {
                int cx = (miEncabezado.getLeft() + miEncabezado.getRight()) / 2;
                int cy = (miEncabezado.getTop() + miEncabezado.getBottom()) / 2;

                int radioInicial = miEncabezado.getWidth();

                Animator anim = ViewAnimationUtils.createCircularReveal(miEncabezado, cx, cy, radioInicial, 0);

                anim.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        miEncabezado.setVisibility(View.INVISIBLE);
                    }
                });
                anim.start();
            }
    }

    public void MostrarPantalla(View view){

        if(miEncabezado.getVisibility() == View.INVISIBLE)
        {
            int cx = (miEncabezado.getLeft() + miEncabezado.getRight()) / 2;
            int cy = (miEncabezado.getTop() + miEncabezado.getBottom()) / 2;

            int radioFinal = Math.max(miEncabezado.getWidth(), miEncabezado.getHeight());

            Animator anim = ViewAnimationUtils.createCircularReveal(miEncabezado, cx, cy, 0, radioFinal);

            miEncabezado.setVisibility(View.VISIBLE);
            anim.start();
        }
    }
}
