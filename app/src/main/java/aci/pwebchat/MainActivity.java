package aci.pwebchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText etKetik;
    Button btSend;
    User user;

    public EditText getEtKetik() {
        return etKetik;
    }

    public void setEtKetik(EditText etKetik) {
        this.etKetik = etKetik;
    }

    public Button getBtSend() {
        return btSend;
    }

    public void setBtSend(Button btSend) {
        this.btSend = btSend;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



// sesuaikan dengan data Anda
        user = new User();
        user.setNama("Sofyan Thayf");
        user.setEmail("sofyan.thayf@kharisma.ac.id");
        user.setTelepon("08152507600");
        user.register();
        etKetik = (EditText)findViewById(R.id.etketik);
        btSend = (Button)findViewById(R.id.btSend);
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chat chat = new Chat();
                chat.setPesan( etKetik.getText().toString() );
                chat.setTanggal( new Date().getTime() );
                chat.setSender( user );
                chat.send();
            }
        });
    }
}
