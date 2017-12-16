package mobapde.royalrumble.firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Patrick Sy on 12/16/2017.
 */

public class FirebaseConnection
{
    private static final FirebaseConnection fb = new FirebaseConnection();

    DatabaseReference dbReference;

    public FirebaseConnection()
    {
        dbReference = FirebaseDatabase.getInstance().getReference();
    }

    public static FirebaseConnection getInstance()
    {
        return fb;
    }

    public DatabaseReference getReference()
    {
        return dbReference;
    }
}
