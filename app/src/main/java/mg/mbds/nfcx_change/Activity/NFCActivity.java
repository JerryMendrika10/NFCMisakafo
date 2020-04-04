package mg.mbds.nfcx_change.Activity;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import mg.mbds.nfcx_change.R;
import mg.mbds.nfcx_change.Session.SessionManager;
import mg.mbds.nfcx_change.Utilitaire.Utilitaire;

public class NFCActivity extends AppCompatActivity implements NfcAdapter.CreateNdefMessageCallback  {


    ImageView image_user_1;
    ImageView image_user_2;
    TextView user_name_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc);
        init();
    }

    public void init(){
        initView();
        initNFC();
        //setData();
    }

    public void initView(){

    }

    public void setData(){
        SessionManager sessionManager = new SessionManager();


    }


    public void initNFC(){

        NfcAdapter mAdapter = NfcAdapter.getDefaultAdapter(this);
        if (mAdapter == null) {
            Toast.makeText(this, "Sorry this device does not have NFC.", Toast.LENGTH_LONG).show();
            return;
        }

        if (!mAdapter.isEnabled()) {
            Toast.makeText(this, "Please enable NFC via Settings.", Toast.LENGTH_LONG).show();
        }

        mAdapter.setNdefPushMessageCallback(this, this);
    }


    @Override
    public NdefMessage createNdefMessage(NfcEvent event) {
        /*SessionManager sessionManager = new SessionManager();
        String userId = sessionManager.getPreferences(this,"UserId");
        String requestServiceId = sessionManager.getPreferences(this,"checkbox");*/

        String message = "5c84e4f2b5344f00174cd912";
        //String message = sessionManager.getPreferences(this,"checkbox");;
        NdefRecord ndefRecord = NdefRecord.createMime("text/plain", message.getBytes());
        NdefMessage ndefMessage = new NdefMessage(ndefRecord);
        return ndefMessage;
    }

}
