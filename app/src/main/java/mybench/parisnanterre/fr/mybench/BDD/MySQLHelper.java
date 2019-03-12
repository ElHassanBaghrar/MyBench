package mybench.parisnanterre.fr.mybench.BDD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Classe qui permet de crée la base de données nomées markerlocations.db
public class MySQLHelper extends SQLiteOpenHelper {


    public static final String TABLE_NAME = "locations";

    public static final String ID_COL = "loc_id";
    public static final String TITLE = "loc_title";
    public static final String SNIPPET = "loc_snippet";
    public static final String POSITION = "loc_position";
    public static final String ENVIRONNEMENT = "loc_environnement";

    private static final int D_VERSION = 1;

    private static final String DB_NAME = "markerlocations.db";
    private static final String DB_CREATE =
            "create table " + TABLE_NAME + "("
                    + ID_COL + " integer primary key autoincrement, "
                    + TITLE + " text, "
                    + SNIPPET + " text, "
<<<<<<< HEAD
                    + ENVIRONNEMENT + "text,"
                    + POSITION + " text);"
            ;
=======
                    + POSITION + " text);";

>>>>>>> ed91151aa43fd8f4fad016c75fc7dab418616213
    public MySQLHelper(Context context) {
        super(context, DB_NAME, null, D_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}


<<<<<<< HEAD
}
=======
>>>>>>> ed91151aa43fd8f4fad016c75fc7dab418616213
