package nuttyzzz.xogamemvp.Board_Game;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import nuttyzzz.xogamemvp.R;

public class BoardActivity extends AppCompatActivity implements BoardView,View.OnClickListener{
    private Dialog mDialog;
    private BoardPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        presenter = new BoardPresenter(this,getApplicationContext());
    }

    @Override
    public void onClick(View view) {
        presenter.playTurn(view);
    }


    @Override
    public void setImage(View view, Drawable drawable) {
        ImageView mark = (ImageView) view;
        mark.setImageDrawable(drawable);
    }

    @Override
    public void removeImage() {
        Integer[] mark = {R.id.mark1,R.id.mark2,R.id.mark3,R.id.mark4,R.id.mark5,R.id.mark6,R.id.mark7,R.id.mark8,R.id.mark9};
        for (int i = 0 ; i < 9 ; i++){
            ((ImageView)findViewById(mark[i])).setImageDrawable(null);
        }
    }

    @Override
    public void showDialog(Dialog dialog) {
        this.mDialog = dialog;
        mDialog.show();
    }

    @Override
    public void onClickReset(View view) {
        presenter.setupGame();
        mDialog.dismiss();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
